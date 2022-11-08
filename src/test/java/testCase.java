import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pagesSearch.searchPage;
import pagesSearch.searchResultPage;

public class testCase {

    private static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://google.com/");
    }

    @Test
    public void googleSearchTest(){
        searchPage search_page = new searchPage(driver);
        search_page.setSearch_bar("enji");
        searchResultPage resultPage = search_page.clickButton();
        String result = resultPage.getPageTitle().toLowerCase();
        Assert.assertTrue(result.contains("enji"));
    }
}
