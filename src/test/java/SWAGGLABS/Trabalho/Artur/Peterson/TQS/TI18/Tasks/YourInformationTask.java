package SWAGGLABS.Trabalho.Artur.Peterson.TQS.TI18.Tasks;

import SWAGGLABS.Trabalho.Artur.Peterson.TQS.TI18.Framework.Report.Report;
import SWAGGLABS.Trabalho.Artur.Peterson.TQS.TI18.Framework.Report.Screenshot;
import SWAGGLABS.Trabalho.Artur.Peterson.TQS.TI18.Framework.Utils.FakerGenerations;
import SWAGGLABS.Trabalho.Artur.Peterson.TQS.TI18.Pages.YourInformationPage;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class YourInformationTask {

    private WebDriver driver;
    private YourInformationPage yourInformationPage;
    private FakerGenerations fakerGenerations;

    public YourInformationTask(WebDriver driver) {
        this.driver = driver;
        this.yourInformationPage = new YourInformationPage(this.driver);
        this.fakerGenerations = new FakerGenerations(this.driver);
    }

    public void toCompleteInformationForm(){
        yourInformationPage.getName().sendKeys(fakerGenerations.getFirstName());
        yourInformationPage.getLastName().sendKeys(fakerGenerations.getLastName());
        yourInformationPage.getPostalCode().sendKeys(fakerGenerations.getPostalCode());
        validarYourInformation();
        yourInformationPage.getContinueButton().click();
    }

    public void validarYourInformation(){
        try{
            Assertions.assertTrue(yourInformationPage.getContinueButton().isDisplayed());
            Report.extentTest.log(Status.PASS, "Página de informações carregada e informações preenchidas com sucesso.",
                    Screenshot.base64(driver));
        }
        catch(Exception e){
            Report.extentTest.log(Status.FAIL, e.getMessage(), Screenshot.base64(driver));
        }
    }
}
