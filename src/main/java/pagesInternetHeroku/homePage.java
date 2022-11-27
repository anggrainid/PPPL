package pagesInternetHeroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class homePage {

    WebDriver driver;

    private By hovers = new By.ByLinkText("Hovers");

    public homePage(WebDriver driver) {
        this.driver = driver;
    }

    public hoversPage clickLink(){
        driver.findElement(hovers).click();
        return new hoversPage(driver);
    }
}
