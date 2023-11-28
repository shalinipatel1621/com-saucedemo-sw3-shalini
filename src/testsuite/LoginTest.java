package testsuite;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class LoginTest extends Utility {

    String baseURL = "https://www.saucedemo.com/";

    @Before
    public void setup() {
        openBrowser(baseURL);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Enter Username on username field
        sendTextElement(By.id("user-name"), "standard_user");
        //Enter password on password field
        sendTextElement(By.name("password"), "secret_sauce");
        //click on Login button
        clickOnElement(By.name("login-button"));
//Verify the text Products
        String expectedText = "Products";
        String actualText = getTextElement(By.xpath("//span[contains(text(),'Products')]"));
        //Verifying actual and expected text
        Assert.assertEquals(expectedText, actualText);
    }


    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        //Enter username on username field
        sendTextElement(By.id("user-name"), "standard_user");
        //Enter password on password field
        sendTextElement(By.name("password"), "secret_sauce");

        //click on Login button
        clickOnElement(By.name("login-button"));
        //verify that six products are displayed on page
        driver.findElement(By.className("inventory_name")).getSize();
    }

    public void clickMenu(String menu) {
        List<WebElement> elementList = driver.findElements(By.xpath("//span[contains(text(),'Products')]"));
        for (WebElement e : elementList) {
            if (e.getText().equalsIgnoreCase(menu)) {
                e.click();
            }
        }

    }


}

