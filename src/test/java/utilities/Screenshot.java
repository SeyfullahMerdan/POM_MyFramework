package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Screenshot {


    public static void webElementScreenshot(WebElement webElement) throws IOException {
        String tarih=new SimpleDateFormat("yyMMddhhmmss").format(new Date());
        File webElementSS=new File("target/screenshot/WebElementSS"+tarih+".jpg");
        File geciciResim=webElement.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciResim,webElementSS);
    }


    public static void tumSayfaScreenshot() throws IOException {
        TakesScreenshot tss= (TakesScreenshot) Driver.getDriver();
        String tarih=new SimpleDateFormat("yyMMddhhmmss").format(new Date());
        File tumSayfa=new File("target/screenshot/tumSayfaSS"+tarih+".jpg");
        File geciciResim=tss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciResim,tumSayfa);
    }





}
