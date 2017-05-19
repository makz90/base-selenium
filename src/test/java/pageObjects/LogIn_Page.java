package pageObjects;

import org.openqa.selenium.*;

import utility.Log;

public class LogIn_Page extends BaseClass {
    private static WebElement element = null;

    public LogIn_Page(WebDriver driver) {
        super(driver);
    }

    public static WebElement txtbx_UserEmail() throws Exception {
        try {
            element = driver.findElement(By.id("user_email"));
            Log.info("UserEmail text box is found on the Login Page");
        } catch (Exception e) {
            Log.error("UserEmail text box is not found on the Login Page");
            throw (e);
        }
        return element;
    }

    public static WebElement txtbx_UserPassword() throws Exception {
        try {
            element = driver.findElement(By.id("user_password"));
            Log.info("UserPassword text box is found on the Login page");
        } catch (Exception e) {
            Log.error("UserPassword text box is not found on the Login Page");
            throw (e);
        }
        return element;
    }

    public static WebElement btn_LogIn() throws Exception {
        try {
            element = driver.findElement(By.xpath("//*[@id=\"user_new\"]/fieldset//div/button"));
            Log.info("LogIn button is found on the Login page");
        } catch (Exception e) {
            Log.error("LogIn button is not found on the Login Page");
            throw (e);
        }
        return element;
    }
}
