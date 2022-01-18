package SWAGGLABS.Trabalho.Artur.Peterson.TQS.TI18.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YourCartPage {
    
    private WebDriver driver;
    
    public YourCartPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getCheckoutButton(){
        return driver.findElement(By.id("checkout"));
    }

}
