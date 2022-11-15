import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pagesFormyProject.cwfPage;
import pagesFormyProject.homePage;
import pagesFormyProject.thanksPage;

public class pagesFormyTest {

    private static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://formy-project.herokuapp.com/");
    }

    @Test
    public void homeTest(){
        homePage home_page = new homePage(driver);
        cwfPage cwf_page = home_page.clickLink();
        cwf_page.setFirst_name("Anggraini");
        cwf_page.setLast_name("Dwiansyah");
        cwf_page.setJob_title("Student");
        cwf_page.setEducation();
        cwf_page.setSex();
        cwf_page.setDrpExperience("2-4");
        cwf_page.setDate("11/15/2022");
        thanksPage thanks_page = cwf_page.submitButton();
        String thanksPageURL = thanks_page.getURL();
        Assert.assertEquals("https://formy-project.herokuapp.com/thanks",thanksPageURL);


    }
}
