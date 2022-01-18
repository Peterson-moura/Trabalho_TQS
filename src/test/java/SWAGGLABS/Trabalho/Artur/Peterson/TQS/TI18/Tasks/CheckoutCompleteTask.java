package SWAGGLABS.Trabalho.Artur.Peterson.TQS.TI18.Tasks;

import SWAGGLABS.Trabalho.Artur.Peterson.TQS.TI18.Framework.Report.Report;
import SWAGGLABS.Trabalho.Artur.Peterson.TQS.TI18.Framework.Report.Screenshot;
import SWAGGLABS.Trabalho.Artur.Peterson.TQS.TI18.Pages.CheckoutCompletePage;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class CheckoutCompleteTask {

    private WebDriver driver;
    private CheckoutCompletePage checkoutCompletePage;

    public CheckoutCompleteTask(WebDriver driver){
        this.driver = driver;
        checkoutCompletePage = new CheckoutCompletePage(this.driver);
    }

    public void pressBackHomeButton(){
        validarCheckoutComplete();
        checkoutCompletePage.getBackHomeButton().click();
    }

    private void validarCheckoutComplete(){
        try{
            Assertions.assertTrue(checkoutCompletePage.getBackHomeButton().isDisplayed());
            Report.extentTest.log(Status.PASS, "Página de Checkout completa carregada com sucesso.", Screenshot.base64(driver));
        }catch(Exception e){
            Report.extentTest.log(Status.FAIL, e.getMessage(), Screenshot.base64(driver));
        }
    }
}
