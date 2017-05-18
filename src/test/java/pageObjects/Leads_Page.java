package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.Constant;
import utility.Log;

public class Leads_Page extends BaseClass {
    private static WebElement element = null;

    public Leads_Page(WebDriver driver) {
        super(driver);
    }

    public static WebElement btn_NewLead() throws Exception {
        try {
            element = driver.findElement(By.id("leads-new"));
            Log.info("NewLead button is found on the Leads Page");
        } catch (Exception e) {
            Log.error("NewLead button is not found on the Leads Page");
            throw (e);
        }
        return element;
    }

    public static WebElement lnk_AddedLead() throws Exception {
        try {
            element = driver.findElement(By.xpath(".//a[contains(text(), '"
                    + Constant.Col_FirstName + " "
                    + Constant.Col_FirstName + "')]"));

            Log.info("AddedLead link is found on the Leads Page");
        } catch (Exception e) {
            Log.error("AddedLead link is not found on the Leads Page");
            throw (e);
        }
        return element;
    }

}
