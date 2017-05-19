package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.Log;

public class LeadStatuses_Page extends BaseClass {
    private static WebElement element;

    public LeadStatuses_Page(WebDriver driver) {
        super(driver);
    }

    public static WebElement btn_Edit() throws Exception {
        element = null;
        try {
            element = driver.findElement(By.xpath("//*[@id=\"lead-status\"]/div[1]/span[1]/div/div/div/div/span[1]/button"));
            Log.info("Edit (New) button on Lead Statuses page is found.");
        } catch (Exception e) {
            Log.error("Edit (New) button on Lead Statuses page is not found");
            throw (e);
        }
        return element;
    }

    public static WebElement txtbx_Name() throws Exception {
        element = null;
        try {
            element = driver.findElement(By.xpath("//*[@id=\"lead-status\"]//fieldset/div[2]/div/input[@id=\"name\"]"));
            Log.info("Name textbox on Lead Statuses page is found.");
        } catch (Exception e) {
            Log.error("Name textbox on Lead Statuses page is not found");
            throw (e);
        }
        return element;
    }

    public static WebElement btn_Save() throws Exception {
        element = null;
        try {
            element = driver.findElement(By.xpath(".//*[@id='lead-status']//button[contains(text(), 'Save')]"));
            Log.info("Save button on Lead Statuses page is found.");
        } catch (Exception e) {
            Log.error("Save button on Lead Statuses page is not found");
            throw (e);
        }
        return element;
    }

}
