import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import pagesInternetHeroku.*;

public class pagesInternetHeroku {

    private static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void testHover(){
        driver.get("https://the-internet.herokuapp.com/hovers");
        WebElement first_image = driver.findElement(By.xpath("//img[@alt='User Avatar']"));
        Actions action = new Actions(driver);
        action.moveToElement(first_image).perform();
        WebElement first_name_image = driver.findElement(By.tagName("h5"));
        Assert.assertEquals("name: user1", first_name_image.getText());
    }

    @Test
    public void testDragnDrop(){
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
        WebElement from = driver.findElement(By.id("column-a"));
        WebElement to = driver.findElement(By.id("column-b"));
        Actions action = new Actions(driver);
        Action dragAndDrop = action.clickAndHold(from).moveToElement(to).clickAndHold(to).moveToElement(from).build();
        dragAndDrop.perform();
        //action.dragAndDrop(to, from).perform();
    }
    @Test
    public void testDragnDropFormy(){
        driver.get("https://formy-project.herokuapp.com/dragdrop");
        WebElement from = driver.findElement(By.xpath("//img[@alt='Selenium logo']"));
        WebElement to = driver.findElement(By.id("box"));
        Actions action = new Actions(driver);
        action.dragAndDrop(from, to).perform();
    }

    @Test
    public void testKeyPresses(){
        driver.get("https://the-internet.herokuapp.com/key_presses");
        WebElement input_box = driver.findElement(By.id("target"));
        //input_box.sendKeys(Keys.SHIFT);
        Actions action = new Actions(driver);
        action.sendKeys(input_box, Keys.SHIFT).perform();
        WebElement result = driver.findElement(By.id("result"));
        Assert.assertEquals("You entered: SHIFT", result.getText());
    }


}
