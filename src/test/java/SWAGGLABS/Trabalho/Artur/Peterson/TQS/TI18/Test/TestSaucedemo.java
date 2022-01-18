package SWAGGLABS.Trabalho.Artur.Peterson.TQS.TI18.Test;

import SWAGGLABS.Trabalho.Artur.Peterson.TQS.TI18.Framework.BaseTest;
import SWAGGLABS.Trabalho.Artur.Peterson.TQS.TI18.Framework.Report.Report;
import SWAGGLABS.Trabalho.Artur.Peterson.TQS.TI18.Framework.Report.Screenshot;
import SWAGGLABS.Trabalho.Artur.Peterson.TQS.TI18.Tasks.*;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class TestSaucedemo extends BaseTest {

    private WebDriver driver = this.getDriver();
    private LoginHomeTask loginHomeTask = new LoginHomeTask(driver);
    private ProductsPageTask productsPageTask = new ProductsPageTask(driver);
    private YourCartTask yourCartTask = new YourCartTask(driver);
    private YourInformationTask yourInformationTask = new YourInformationTask(driver);
    private OverviewTask overviewTask = new OverviewTask(this.driver);
    private CheckoutCompleteTask checkoutCompleteTask = new CheckoutCompleteTask(this.driver);

    @Test
    public void realizarCompra(){
        try{
            Report.startReport("Realizar compra no site.");
            loginHomeTask.preencherLogin();
            productsPageTask.adicionarProdutoCarrinho();
            productsPageTask.acessarCarrinho();
            yourCartTask.pressCheckout();
            yourInformationTask.toCompleteInformationForm();
            overviewTask.pressFinishButton();
            checkoutCompleteTask.pressBackHomeButton();
            productsPageTask.pressLateralMenuAndLogOut();
            loginHomeTask.validarEncerramentoSessao();
        }
        catch(Exception e){
            Report.extentTest.log(Status.FAIL,e.getMessage(), Screenshot.base64(driver));
        }
    }

}
