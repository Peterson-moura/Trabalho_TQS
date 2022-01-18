package SWAGGLABS.Trabalho.Artur.Peterson.TQS.TI18.Tasks;

import SWAGGLABS.Trabalho.Artur.Peterson.TQS.TI18.Framework.Report.Report;
import SWAGGLABS.Trabalho.Artur.Peterson.TQS.TI18.Framework.Report.Screenshot;
import SWAGGLABS.Trabalho.Artur.Peterson.TQS.TI18.Pages.OverviewPage;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OverviewTask {

    private WebDriver driver;
    private OverviewPage overviewPage;

    public OverviewTask(WebDriver driver){
        this.driver = driver;
        this.overviewPage = new OverviewPage(this.driver);
    }

    public void pressFinishButton(){
        validarOverview();
        overviewPage.getFinishButton().click();
    }

    public void validarOverview(){
        try{
            Assertions.assertTrue(overviewPage.getFinishButton().isDisplayed());
            Report.extentTest.log(Status.PASS, "Página de \"Overview\" carregada com sucesso.",
                    Screenshot.base64(driver));
        }
        catch(Exception e){
            Report.extentTest.log(Status.FAIL, e.getMessage(), Screenshot.base64(driver));
        }
    }
}
