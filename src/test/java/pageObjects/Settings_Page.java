package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.Log;

public class Settings_Page extends BaseClass {
    private static WebElement element;

    public Settings_Page(WebDriver driver) {
        super(driver);
    }

    public static WebElement btn_Leads() throws Exception {
        element = null;
        try {
            element = driver.findElement(By.xpath("//*[@id=\"sidebar\"]/ul/li[14]/a"));
            Log.info("Leads button on Settings page is found.");
        } catch (Exception e) {
            Log.error("Leads button on Settings page is not found");
            throw (e);
        }
        return element;
    }


}
