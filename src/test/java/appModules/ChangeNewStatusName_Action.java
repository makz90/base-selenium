package appModules;

import org.testng.Reporter;
import pageObjects.Home_Page;
import pageObjects.LeadStatuses_Page;
import pageObjects.LeadsSettings_Page;
import pageObjects.Settings_Page;
import utility.Constant;
import utility.Log;

public class ChangeNewStatusName_Action {
    public static void Execute(String sChangedStatus) throws Exception {

        Home_Page.lnk_DropdownSettings().click();
        Log.info("Settings Dropdown link is clicked");

        Home_Page.lnk_Settings().click();
        Log.info("Click action is performed on Settings button");

        Settings_Page.btn_Leads().click();
        Log.info("Click action is performed on Leads button on the Settings Page");

        LeadsSettings_Page.lnk_LeadStatuses().click();
        Log.info("Lead Statuses tab is visible");

        LeadStatuses_Page.btn_Edit().click();
        Log.info("Edit button near New status is clicked");

        LeadStatuses_Page.txtbx_Name().clear();
        LeadStatuses_Page.txtbx_Name().sendKeys(sChangedStatus);
        Log.info(sChangedStatus + "status text is entered into the textbox");

        LeadStatuses_Page.btn_Save().click();
        Log.info("Edit button near New status is clicked");

        Reporter.log("CreateNewLead Action is successfully performed");
    }
}
