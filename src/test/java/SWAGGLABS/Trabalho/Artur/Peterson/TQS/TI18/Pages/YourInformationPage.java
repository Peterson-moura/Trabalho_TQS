package SWAGGLABS.Trabalho.Artur.Peterson.TQS.TI18.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YourInformationPage {

    private WebDriver driver;

    public YourInformationPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getName(){
        return driver.findElement(By.id("first-name"));
    }

    public WebElement getLastName(){
        return driver.findElement(By.id("last-name"));
    }

    public WebElement getPostalCode(){
        return driver.findElement(By.id("postal-code"));
    }

    public WebElement getContinueButton(){
        return driver.findElement(By.id("continue"));
    }
}
