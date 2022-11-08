import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pagesSauceDemo.inventoryPage;
import pagesSauceDemo.loginPage;

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
        loginPage login_page = new loginPage(driver);
        login_page.setUsername("standard_user");
        login_page.setPassword("secret_sauce");
        inventoryPage inventory_page = login_page.submitButton();
        String inventoryPageURL = inventory_page.getURL();
        Assert.assertEquals("https://www.saucedemo.com/inventory.html", inventoryPageURL);
    }
}
