import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SauceDemoTest {

    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void googleSearch(){
        driver.get("https://google.com/");
        WebElement search_bar = driver.findElement(By.name("q"));
        search_bar.sendKeys("akbar");//+ Keys.ENTER);??

        WebElement button = driver.findElement(By.name("btnK"));
        button.submit();

        String title = driver.getTitle();
        Assert.assertTrue(title.contains("akbar"));

    }
    @Test
    public void login_standard_user(){
        driver.get("https://www.saucedemo.com/");
        WebElement input_username = driver.findElement(By.name("user-name"));
        input_username.sendKeys("standard_user");//+ Keys.ENTER);??
        WebElement input_password = driver.findElement(By.name("password"));
        input_password.sendKeys("secret_sauce");

        WebElement button = driver.findElement(By.name("login-button"));
        button.submit();


        String url = driver.getCurrentUrl();
        Assert.assertEquals("https://www.saucedemo.com/inventory.html", url);

    }
    @Test
    public void login_locked_user(){
        driver.get("https://www.saucedemo.com/");
        WebElement input_username = driver.findElement(By.name("user-name"));
        input_username.sendKeys("locked_out_user");
        WebElement input_password = driver.findElement(By.name("password"));
        input_password.sendKeys("secret_sauce");

        WebElement login_button = driver.findElement(By.name("login-button"));
        login_button.submit();

        WebElement error_button = driver.findElement(By.tagName("h3"));
        String error_text = error_button.getText();
        Assert.assertEquals("Epic sadface: Sorry, this user has been locked out.", error_text);
    }

    @Test
    public void login_problem_user(){
        driver.get("https://www.saucedemo.com/");
        WebElement input_username = driver.findElement(By.name("user-name"));
        input_username.sendKeys("problem_user");
        WebElement input_password = driver.findElement(By.name("password"));
        input_password.sendKeys("secret_sauce");

        WebElement login_button = driver.findElement(By.name("login-button"));
        login_button.submit();

        WebElement img = driver.findElement(By.className("inventory_item_img"));
        String src_img = img.getAttribute("src");
        System.out.println(src_img);

        //Assert.assertEquals("Epic sadface: Sorry, this user has been locked out.", image);
    }

    @AfterClass
    public static void teardown(){
        driver.quit();
    }

}
