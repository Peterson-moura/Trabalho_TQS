package SWAGGLABS.Trabalho.Artur.Peterson.TQS.TI18.Tasks;

import SWAGGLABS.Trabalho.Artur.Peterson.TQS.TI18.Framework.Browser.Waits;
import SWAGGLABS.Trabalho.Artur.Peterson.TQS.TI18.Framework.Report.Report;
import SWAGGLABS.Trabalho.Artur.Peterson.TQS.TI18.Framework.Report.Screenshot;
import SWAGGLABS.Trabalho.Artur.Peterson.TQS.TI18.Pages.ProductsPage;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class ProductsPageTask {

    private static WebDriver driver;

    private static ProductsPage productsPage;
    private Waits waits;

    public ProductsPageTask(WebDriver driver) {
        this.driver = driver;
        productsPage = new ProductsPage(this.driver);
        waits = new Waits(this.driver);
    }

    public void adicionarProdutoCarrinho(){
        productsPage.getAddToCartButton().click();
        validarProductsPage();
    }

    public void acessarCarrinho(){
        productsPage.getCartButton().click();
    }

    public void pressLateralMenuAndLogOut(){
        productsPage.getLateralMenu().click();
        waits.loadElement(productsPage.getLogOutButton());
        validarLogOut();
        productsPage.getLogOutButton().click();
    }

    private void validarProductsPage(){
        try{
            Assertions.assertTrue(productsPage.getRemoveOfCartButton().isDisplayed());
            Report.extentTest.log(Status.PASS, "Página de lista de produtos carregada e produto " +
                    "adicionado ao carrinho com sucesso.", Screenshot.base64(driver));
        }catch(Exception e){
            Report.extentTest.log(Status.FAIL, e.getMessage(), Screenshot.base64(driver));
        }
    }

    private void validarLogOut(){
        try{
            Assertions.assertTrue(productsPage.getLogOutButton().isDisplayed());
            Report.extentTest.log(Status.PASS, "Retorno à página inicial com sucesso.", Screenshot.base64(driver));
        }catch(Exception e){
            Report.extentTest.log(Status.FAIL, e.getMessage(), Screenshot.base64(driver));
        }
    }
}
