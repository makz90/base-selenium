package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.Log;

public class LeadDetails_Page extends BaseClass {
    private static WebElement element = null;

    public LeadDetails_Page(WebDriver driver) {
        super(driver);
    }

    public static WebElement txt_Status() throws Exception {
        try {
            element = driver.findElement(By.xpath("//*[@id='details']//span[contains(text(), 'status')]/preceding-sibling::span[@class='lead-status']"));
            Log.info("Status text is found on the Lead Detail Page");
        } catch (Exception e) {
            Log.error("Status text is not found on the Lead Detail Page");
            throw (e);
        }
        return element;
    }

}
