package appModules;

import org.testng.Reporter;
import pageObjects.Home_Page;
import pageObjects.LeadDetails_Page;
import pageObjects.Leads_Page;
import utility.Constant;
import utility.Log;

import static org.junit.Assert.assertEquals;

public class VerifyLeadStatusIsChanged_Action {
    public static void Execute() throws Exception {

        Home_Page.lnk_Leads().click();
        Log.info("Leads link is clicked on main navbar");

        Leads_Page.lnk_AddedLead().click();
        Log.info("Previously created lead name is clicked on Leads page");

        String sChangedLeadStatus = LeadDetails_Page.txt_Status().getText();
        assertEquals(Constant.NewStatus, sChangedLeadStatus);
        Log.info("Lead status assertion is performed (Status name changed)");

        Reporter.log("VerifyLeadStatusIsChanged Action is successfully performed");
    }
}
