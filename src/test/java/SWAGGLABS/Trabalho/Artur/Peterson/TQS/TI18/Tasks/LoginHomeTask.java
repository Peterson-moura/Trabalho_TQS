package SWAGGLABS.Trabalho.Artur.Peterson.TQS.TI18.Tasks;

import SWAGGLABS.Trabalho.Artur.Peterson.TQS.TI18.Framework.Browser.Waits;
import SWAGGLABS.Trabalho.Artur.Peterson.TQS.TI18.Framework.Report.Report;
import SWAGGLABS.Trabalho.Artur.Peterson.TQS.TI18.Framework.Report.Screenshot;
import SWAGGLABS.Trabalho.Artur.Peterson.TQS.TI18.Pages.LoginHomePage;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class LoginHomeTask {

    private static WebDriver driver;

    private static LoginHomePage loginHomePage;

    private static Waits waits;

    public LoginHomeTask(WebDriver driver) {
        this.driver = driver;
        loginHomePage = new LoginHomePage(this.driver);
        waits = new Waits(this.driver);
    }

    public void preencherLogin(){
        waits.loadElement(loginHomePage.getUsername());
        loginHomePage.getUsername().sendKeys("standard_user");
        loginHomePage.getPassword().sendKeys("secret_sauce");
        validarLoginHome();
        loginHomePage.getLoginButton().click();
    }

    private void validarLoginHome(){
        try{
            Assertions.assertTrue(loginHomePage.getLoginButton().isDisplayed());
            Report.extentTest.log(Status.PASS, "Página de login carregada com sucesso.", Screenshot.base64(driver));
        }catch(Exception e){
            Report.extentTest.log(Status.FAIL, e.getMessage(), Screenshot.base64(driver));
        }
    }

    public void validarEncerramentoSessao(){
        try{
            Assertions.assertTrue(loginHomePage.getLoginButton().isDisplayed());
            Report.extentTest.log(Status.PASS, "Sessão encerrada com sucesso.", Screenshot.base64(driver));
        }catch(Exception e){
            Report.extentTest.log(Status.FAIL, e.getMessage(), Screenshot.base64(driver));
        }
    }

}
