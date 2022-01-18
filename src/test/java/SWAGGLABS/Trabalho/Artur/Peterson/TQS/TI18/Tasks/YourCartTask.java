package SWAGGLABS.Trabalho.Artur.Peterson.TQS.TI18.Tasks;

import SWAGGLABS.Trabalho.Artur.Peterson.TQS.TI18.Framework.Report.Report;
import SWAGGLABS.Trabalho.Artur.Peterson.TQS.TI18.Framework.Report.Screenshot;
import SWAGGLABS.Trabalho.Artur.Peterson.TQS.TI18.Pages.YourCartPage;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class YourCartTask {

    private WebDriver driver;
    private YourCartPage yourCartPage;

    public YourCartTask(WebDriver driver){
        this.driver = driver;
        yourCartPage = new YourCartPage(this.driver);
    }

    public void pressCheckout(){
        validarYourCart();
        yourCartPage.getCheckoutButton().click();
    }

    private void validarYourCart(){
        try{
            Assertions.assertTrue(yourCartPage.getCheckoutButton().isDisplayed());
            Report.extentTest.log(Status.PASS, "Página do carrinho carregada com sucesso.", Screenshot.base64(driver));
        }catch(Exception e){
            Report.extentTest.log(Status.FAIL, e.getMessage(), Screenshot.base64(driver));
        }
    }
}
