package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.Log;

public class Home_Page extends BaseClass {
    private static WebElement element = null;

    public Home_Page(WebDriver driver) {
        super(driver);
    }

    public static WebElement lnk_DropdownSettings() throws Exception {
        try {
            element = driver.findElement(By.xpath(".//*[@id='user-dd']/a"));
            Log.info("Dropdown Settings link is found on the Home Page");
        } catch (Exception e) {
            Log.error("Dropdown Settings link is not found on the Home Page");
            throw (e);
        }
        return element;
    }

    public static WebElement lnk_Settings() throws Exception {
        try {
            element = driver.findElement(By.xpath(".//*[@id='user-dd']//a[@href='/settings/profile']"));
            Log.info("Settings link is found on the Home Page");
        } catch (Exception e) {
            Log.error("Settings link is not found on the Home Page");
            throw (e);
        }
        return element;
    }

    public static WebElement lnk_Leads() throws Exception {
        try {
            element = driver.findElement(By.id("nav-leads"));
            Log.info("Leads link is found on the Home Page");
        } catch (Exception e) {
            Log.error("Leads link is not found on the Home Page");
            throw (e);
        }
        return element;
    }

}
