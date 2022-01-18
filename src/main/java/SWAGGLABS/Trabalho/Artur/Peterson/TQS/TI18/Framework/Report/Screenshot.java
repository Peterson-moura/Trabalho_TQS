package SWAGGLABS.Trabalho.Artur.Peterson.TQS.TI18.Framework.Report;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.model.Media;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Screenshot {

    private static String PATH_SCREENSHOT = Report.PATH_REPORT + File.separator + "screenshot";

    public static Media capture(WebDriver driver){
        try{
            CreateFolder.createFolderReport(PATH_SCREENSHOT);
            File scrshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            String screenShotPath = PATH_SCREENSHOT + File.separator + "Imagem_" + DateTime.getDateTimeFormat() + ".png";
            FileUtils.copyFile(scrshot, new File(screenShotPath));
            return MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build();

        }catch (IOException e){

            System.out.println("Erro ao copiar o arquivo" + e.getMessage());

        }
        return null;
    }

    public static Media base64(WebDriver driver){

        try{
            return  MediaEntityBuilder.createScreenCaptureFromBase64String(((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64)).build();

        }catch (Exception e){

            System.out.println("Erro ao criar string" + e.getMessage());
        }
        return null;
    }
}
