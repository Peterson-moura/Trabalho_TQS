package SWAGGLABS.Trabalho.Artur.Peterson.TQS.TI18.Pages;

import SWAGGLABS.Trabalho.Artur.Peterson.TQS.TI18.Framework.Browser.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginHomePage {

    private WebDriver driver;
    private Waits waits;

    public LoginHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getUsername(){
            return  driver.findElement(By.id("user-name"));
        }

        public WebElement getPassword(){
            return  driver.findElement(By.id("password"));
        }

        public WebElement getLoginButton(){
        return  driver.findElement(By.id("login-button"));
    }



    }

