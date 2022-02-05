package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class Driver {

    private Driver () {    // Bu üyelere başka classlardan ulaşabilmm için
        // getter setter yapmam gerekiyor. Getter Setter yapmadıgım sürece burdaki private ögelere ulaşamam.
    }

    private static WebDriver driver;

    public static WebDriver getDriver(){

        if (driver==null) { // bu if sayesinde kod çalışırken bir kere new keyword ile driver oluşturulacak
            // diger kullanımlarda devreye girmeyecek.
            switch (ConfigReader.getProperty("browser")) {
                case "chrome" :
                    driver=new ChromeDriver();
                    WebDriverManager.chromedriver().setup();
                    break;
                case "firefox" :
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break;
                case "opera" :
                    WebDriverManager.operadriver().setup();
                    driver=new OperaDriver();
                    break;
                case "safari" :
                    WebDriverManager.safaridriver().setup();
                    driver=new SafariDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();
            }

        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        return driver;
    }
// Bu methodu her çagırdıgımda yeni bir driver çagırıyor. Tekrardan oluşturuyor.


    public static void closeDriver() {

        if (driver!=null) {
            driver.quit();
            driver=null; // null ataması yapmazsam açılırken nulla eşit olmadıgı için yeni sayfa açmaz ve hata verir
            // kapattıktan sonra driveri sıfırlıyorum ki bir daha çagırdıgımda nulla takılsın ve setup methodunda driveri
            // çagırsın ve çalıştırsın
        }
    }




}
