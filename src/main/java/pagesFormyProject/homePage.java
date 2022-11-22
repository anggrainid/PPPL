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
            Thread.sleep(1000); //bukan best practice karena tergantung kecepatan internet, bisa menggunakan bawaan selenium yaitu waits
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new cwfPage(driver);

        //Wait Explicit dgn menggunakan wait element until...
        //Ada implicitWait, mirip spt thread, bedanya, kalau impicitWait ketika sudah bisa diclick dalam waktu kurang dari max, maka tidak perlu menggu max, smntara thread itu tetap mnunggu dlm milisekon trntntu
        //Jangan langsung menggunakan keduanya implicit dan explicit secara bersamaan
        //Tidak disarankan menggunakan time out atau thread sleep bawaan java memperlambat testing
    }



}
