package SWAGGLABS.Trabalho.Artur.Peterson.TQS.TI18.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage {

    private WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getAddToCartButton() {
        return driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
    }

    public WebElement getRemoveOfCartButton(){
        return driver.findElement(By.id("remove-sauce-labs-backpack"));
    }

    public WebElement getCartButton() {
        return driver.findElement(By.id("shopping_cart_container"));
    }

    public WebElement getLateralMenu() {
        return driver.findElement(By.id("react-burger-menu-btn"));
    }

    public WebElement getLogOutButton(){
        return driver.findElement(By.id("logout_sidebar_link"));
    }

}

