package testCases;

import appModules.*;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.BaseClass;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;

import com.getbase.Client;
import com.getbase.Configuration;
import com.getbase.models.Lead;
import com.getbase.services.LeadsService;

import java.util.List;

public class TestBaseWorkflow {
    public WebDriver driver;
    private String sTestCaseName;
    private int iTestCaseRow;

    @BeforeMethod
    public void beforeMethod() throws Exception {
        cleanUpLeads();

        DOMConfigurator.configure("log4j.xml");

        sTestCaseName = this.toString();
        sTestCaseName = Utils.getTestCaseName(this.toString());

        Log.startTestCase(sTestCaseName);

        ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Sheet1");

        iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName, Constant.Col_TestCaseName);

        driver = Utils.OpenBrowser(iTestCaseRow);

        new BaseClass(driver);
    }

    @Test
    public void main() throws Exception {

        try {

            SignIn_Action.Execute(iTestCaseRow);
            CreateNewLead_Action.Execute(iTestCaseRow);
            VerifyLeadStatusIsNew_Action.Execute();
            ChangeNewStatusName_Action.Execute(Constant.NewStatus);
            VerifyLeadStatusIsChanged_Action.Execute(driver);

            if (BaseClass.bResult) {
                ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.Col_Result);
            } else {
                throw new Exception("Test Case Failed because of Verification");
            }

        } catch (Exception e) {
            ExcelUtils.setCellData("Fail", iTestCaseRow, Constant.Col_Result);
            Utils.takeScreenshot(driver, sTestCaseName);
            Log.error(e.getMessage());
            throw (e);
        }

    }

    @AfterMethod
    public void afterMethod() throws Exception {
        Log.endTestCase(sTestCaseName);

        try {
            ChangeNewStatusName_Action.Execute("New");
        } catch (Exception e) {
            Log.error("After Method: " + e.getMessage());
        }

        driver.close();
    }

    private void cleanUpLeads(){
        String token = "32a3f51cc34cee6344f7625ddb66d27d8c7467ab609e47bac34e1b1fc2bd0d17";
        Client baseClient = new Client(new Configuration.Builder()
                .accessToken(token)
                .verbose()
                .build());

        System.out.println("Cleaning Up Lead Data:");
        List<Lead> leadList = baseClient.leads().list(new LeadsService.SearchCriteria());
        for (Lead lead : leadList) {
            System.out.println("deleting: " + lead.getLastName());
            baseClient.leads().delete(lead.getId());
        }
    }

}
