package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.Log;

public class NewLead_Page extends BaseClass {
    private static WebElement element = null;

    public NewLead_Page(WebDriver driver) {
        super(driver);
    }

    public static WebElement txtbx_FirstName() throws Exception {
        try {
            element = driver.findElement(By.id("lead-first-name"));
            Log.info("FirstName text box is found on the NewLead Page");
        } catch (Exception e) {
            Log.error("FirstName text box is not found on the NewLead Page");
            throw (e);
        }
        return element;
    }

    public static WebElement txtbx_LastName() throws Exception {
        try {
            element = driver.findElement(By.id("lead-last-name"));
            Log.info("LastName text box is found on the NewLead Page");
        } catch (Exception e) {
            Log.error("LastName text box is not found on the NewLead Page");
            throw (e);
        }
        return element;
    }

    public static WebElement btn_Save() throws Exception {
        try {
            element = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div/div/div[2]/button"));
            Log.info("Save button is found on the NewLead page");
        } catch (Exception e) {
            Log.error("Save button is not found on the NewLead Page");
            throw (e);
        }
        return element;
    }
}
