package SWAGGLABS.Trabalho.Artur.Peterson.TQS.TI18.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutCompletePage {
    
    private WebDriver driver;
    
    public CheckoutCompletePage(WebDriver driver){
        this.driver = driver;
    }
    
    public WebElement getBackHomeButton(){
        return driver.findElement(By.id("back-to-products"));
    }
}
