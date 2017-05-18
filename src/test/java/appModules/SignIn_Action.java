package appModules;

import org.testng.Reporter;

import pageObjects.Home_Page;
import pageObjects.LogIn_Page;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;

public class SignIn_Action {
    public static void Execute(int iTestCaseRow) throws Exception {

        String sUserName = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_UserName);
        LogIn_Page.txtbx_UserEmail().sendKeys(sUserName);
        Log.info(sUserName + " is entered in UserName text box");

        String sPassword = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Password);
        LogIn_Page.txtbx_UserPassword().sendKeys(sPassword);
        Log.info(sPassword + " is entered in Password text box");

        LogIn_Page.btn_LogIn().click();
        Log.info("Click action is performed on Submit button");

        Utils.waitForElement(Home_Page.lnk_DropdownSettings());

        Reporter.log("SignIn Action is successfully performed");
    }
}
