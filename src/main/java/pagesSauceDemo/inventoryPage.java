package pagesSauceDemo;

import org.openqa.selenium.WebDriver;


public class inventoryPage {
    private WebDriver driver;
    public inventoryPage(WebDriver driver) {
        this.driver = driver;
    }
    public String getURL(){
        return driver.getCurrentUrl();
    }
}
