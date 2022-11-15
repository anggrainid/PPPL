package pagesFormyProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class homePage {

    private WebDriver driver;

    private By cwfLink = new By.ByLinkText("Complete Web Form");

    public homePage(WebDriver driver) {
        this.driver = driver;
    }

    public cwfPage clickLink(){
        driver.findElement(cwfLink).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new cwfPage(driver);
    }



}
