package Suporte;

//import com.sun.jna.platform.FileUtils;
//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class Scrennshot {
    public static void tirar(WebDriver navegador, String arquivo){
        File screenshot = ((TakesScreenshot)navegador).getScreenshotAs(OutputType.FILE);
        try {
            //FileUtils.copyFile(screenshot, new File(arquivo));

        }catch (Exception e){

        }
    }



}
