package pagesInternetHeroku;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class hoversPage {

    WebDriver driver;

    private By first_image = new By.ByTagName("img");
    private By first_name_image = new By.ByTagName("h5");

    public hoversPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setFirst_image() {
        driver.findElement(first_image);
    }

    public void setFirst_name_image() {
        driver.findElement(first_name_image);
    }
}
