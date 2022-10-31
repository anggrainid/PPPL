import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;

public class ExampleTest {



    @Test
    public void chromeTest(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        String title = driver.getTitle();
        System.out.println(title);
        //driver.quit();

    }

    @Test
    public void latihan1Test(){
        System.setProperty("webdriver.edge.driver", "src/main/resources/msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.google.com/");
        String title = driver.getTitle();
        System.out.println(title);
        //driver.quit();
    }
    @Test
    public void latihan2Test(){
        //System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        List<WebElement> lists = driver.findElements(By.tagName("li"));
        System.out.println(lists);

        for (WebElement webElement:lists){
            String name = webElement.getText();
            System.out.println(name);
        }
        //driver.quit();
    }
}
