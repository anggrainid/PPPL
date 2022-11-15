package pagesFormyProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class cwfPage {

    private WebDriver driver;
    private By first_name = new By.ById("first-name");
    private By last_name = new By.ById("last-name");
    private By job_title = new By.ById("job-title");

    private By education = new By.ById("radio-button-1");
    private By sex = new By.ById("checkbox-1");

    private By experience = new By.ById("select-menu");
    private By date = new By.ById("datepicker");

    private By submit_button = new By.ByLinkText("Submit");

//    private Select drpExperience = new Select(driver.findElement(experience));
    public cwfPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setFirst_name(String input_first_name) {
        driver.findElement(first_name).sendKeys(input_first_name);
    }

    public void setLast_name(String input_last_name) {
        driver.findElement(last_name).sendKeys(input_last_name);
    }

    public void setJob_title(String input_job_title) {
        driver.findElement(job_title).sendKeys(input_job_title);
    }

    public void setEducation() {
        driver.findElement(education).click();
    }

    public void setSex() {
        driver.findElement(sex).click();
    }

    public void setDrpExperience(String select_drpExperience) {
        new Select(driver.findElement(experience)).selectByVisibleText(select_drpExperience);
    }

    public void setDate(String input_date) {
        driver.findElement(date).sendKeys(input_date);
    }
    public thanksPage submitButton(){
        driver.findElement(submit_button).click();
        return new thanksPage(driver);
    }



}
