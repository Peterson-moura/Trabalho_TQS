package SWAGGLABS.Trabalho.Artur.Peterson.TQS.TI18.Framework.Report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class Report {

    public static WebDriver driver;
    public static String PATH_REPORT = System.getProperty("user.dir") + File.separator + "Report" + File.separator + "Report_" + DateTime.getDateTimeFormat();
    public static ExtentSparkReporter sparkReporter;
    public static ExtentTest extentTest;
    public static ExtentReports extentReports;

    public static void setExtentReports(){
        CreateFolder.createFolderReport(PATH_REPORT);

        sparkReporter = new ExtentSparkReporter(PATH_REPORT + File.separator + "Execucao_" +

                DateTime.getDateTimeFormat() + ".htmal");

        sparkReporter.config().setDocumentTitle("Relatorio de Execução de Testes Automatizados");
        sparkReporter.config().setReportName("Relatorio de Execucao de uma Compra do Site Saucedemo");
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setEncoding("UTF-8");
        sparkReporter.config().setTimeStampFormat(" EEE , MMM dd , yyyy , hh:mm a '('zzz')'");

        extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);
    }

    public static void startReport(String testName){
        extentTest = extentReports.createTest(testName);
    }

    public static void endReport(){
        extentReports.flush();
        if(driver!=null){
            driver.quit();
            driver = null;
        }
    }

}
