import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pagesSauceDemo.inventoryPage;
import pagesSauceDemo.loginPage;

import java.time.Duration;

public class pagesSauceDemoTest {

    private static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void loginTest(){
        loginPage login_page = new loginPage(driver, Duration.ofSeconds(10));
        login_page.setUsername("standard_user");
        login_page.setPassword("secret_sauce");
        inventoryPage inventory_page = login_page.submitButton();
        String inventoryPageURL = inventory_page.getURL();
        Assert.assertEquals("https://www.saucedemo.com/inventory.html", inventoryPageURL);
    }

    @Test
    public void loginLockedOutUser(){
        loginPage login_page = new loginPage(driver, Duration.ofSeconds(10));
        login_page.setUsername("locked_out_user");
        login_page.setPassword("secret_sauce");
        login_page.submitButton();
        WebElement error_message = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h3")));
        //Assert.assertEquals("Epic sadface: Sorry, this user has been locked out.", );
        System.out.println(error_message.getText());
    }
}
