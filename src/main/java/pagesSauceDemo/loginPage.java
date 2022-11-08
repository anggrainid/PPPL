package pagesSauceDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {

    private By username = new By.ByName("user-name");
    private By password = new By.ByName("password");
    private By button = new By.ByName("login-button");

    private WebDriver driver;

    public loginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setUsername(String input_username) {
        driver.findElement(username).sendKeys(input_username);
    }

    public void setPassword(String input_password) {
        driver.findElement(password).sendKeys(input_password);

    }

    public inventoryPage submitButton(){
        driver.findElement(button).submit();
        return new inventoryPage(driver);
    }
}
