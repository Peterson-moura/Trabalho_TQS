package SWAGGLABS.Trabalho.Artur.Peterson.TQS.TI18.Framework;

import SWAGGLABS.Trabalho.Artur.Peterson.TQS.TI18.Framework.Browser.DriverManager;
import SWAGGLABS.Trabalho.Artur.Peterson.TQS.TI18.Framework.Browser.TypeDriver;
import SWAGGLABS.Trabalho.Artur.Peterson.TQS.TI18.Framework.Report.Report;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import static SWAGGLABS.Trabalho.Artur.Peterson.TQS.TI18.Framework.Browser.DriverManager.quitDriver;

public class BaseTest extends DriverManager {

    private String url = ("https://www.saucedemo.com/");

    private static WebDriver driver;

    public WebDriver getDriver(){
        return driver = getDriver(TypeDriver.CHROME);
    }

    @BeforeEach
    public void setUp(){

        Report.setExtentReports();
        getDriver().get(url);
    }

    @AfterEach
    public void tearDown(){
        Report.endReport();
        quitDriver();
    }


}
