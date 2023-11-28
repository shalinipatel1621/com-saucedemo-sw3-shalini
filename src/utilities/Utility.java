package utilities;

import browserfactory.BaseTest;
import org.openqa.selenium.By;

public class Utility extends BaseTest {

    public void clickOnElement(By by) {

        driver.findElement(by).click();

    }

    public void sendTextElement(By by, String text) {
        driver.findElement(by).sendKeys(text);


    }

    public String getTextElement(By by) {
        return driver.findElement(by).getText();

    }
}
