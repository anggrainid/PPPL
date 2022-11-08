package pagesSearch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class searchPage {
    private By search_bar = new By.ByName("q");
    private By button = new By.ByName("btnK");
    private WebDriver driver;

    public searchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setSearch_bar(String query) {
        driver.findElement(search_bar).sendKeys(query);
    }

    public searchResultPage clickButton(){
        driver.findElement(button).submit();
        return new searchResultPage(driver);

    }
}
