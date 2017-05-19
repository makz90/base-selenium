package appModules;

import org.testng.Reporter;
import pageObjects.Home_Page;
import pageObjects.LeadDetails_Page;
import pageObjects.Leads_Page;
import pageObjects.NewLead_Page;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;

public class CreateNewLead_Action {
    public static void Execute(int iTestCaseRow) throws Exception {

        Home_Page.lnk_Leads().click();
        Log.info("Leads navigation link is clicked");

        Leads_Page.btn_NewLead().click();
        Log.info("Click action is performed on New Lead button");

        String sFirstName = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_FirstName);
        NewLead_Page.txtbx_FirstName().sendKeys(sFirstName);
        Log.info("FirstName text is entered into first name textbox");

        String sLastName = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_LastName);
        NewLead_Page.txtbx_LastName().sendKeys(sLastName);
        Log.info("LastName text is entered into last name textbox");

        NewLead_Page.btn_Save().click();
        Log.info("Click action is performed on Save button");

        Utils.waitForElement(LeadDetails_Page.txt_Status());

        Reporter.log("CreateNewLead Action is successfully performed");
    }
}
