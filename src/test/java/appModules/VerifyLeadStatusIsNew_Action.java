package appModules;

import org.testng.Reporter;
import pageObjects.LeadDetails_Page;
import utility.Log;

import static org.junit.Assert.assertEquals;

public class VerifyLeadStatusIsNew_Action {
    public static void Execute() throws Exception {

        String sNewLeadStatus = LeadDetails_Page.txt_Status().getText();
        assertEquals("New", sNewLeadStatus);
        Log.info("Lead status assertion is performed (New)");

        Reporter.log("VerifyLeadStatusIsNew Action is successfully performed");
    }
}
