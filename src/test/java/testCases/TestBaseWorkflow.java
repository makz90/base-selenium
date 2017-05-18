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

public class TestBaseWorkflow {
    public WebDriver driver;
    private String sTestCaseName;
    private int iTestCaseRow;

    @BeforeMethod
    public void beforeMethod() throws Exception {
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
            ChangeNewStatusName_Action.Execute();
            VerifyLeadStatusIsChanged_Action.Execute();

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
    public void afterMethod() {
        Log.endTestCase(sTestCaseName);
        driver.close();
    }

}
