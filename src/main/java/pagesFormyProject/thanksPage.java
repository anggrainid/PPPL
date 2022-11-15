package pagesFormyProject;

import org.openqa.selenium.WebDriver;

public class thanksPage {

    WebDriver driver;

    public thanksPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getURL(){
        return driver.getCurrentUrl();
    }
}
