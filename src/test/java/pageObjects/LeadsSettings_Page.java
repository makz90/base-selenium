package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.Log;

public class LeadsSettings_Page extends BaseClass {
    private static WebElement element;

    public LeadsSettings_Page(WebDriver driver) {
        super(driver);
    }

    public static WebElement lnk_LeadStatuses() throws Exception {
        element = null;
        try {
            element = driver.findElement(By.xpath(".//*[@id='leads-settings-tabs']/li/a[@href='#lead-status']"));
            Log.info("LeadStatuses link on Leads Settings page is found.");
        } catch (Exception e) {
            Log.error("LeadStatuses link on Leads Settings page is not found");
            throw (e);
        }
        return element;
    }


}
