package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ReactShoppingPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class ReactShoppingTest {


    @Test
    public void shoppingTest() {

        Driver.getDriver().get(ConfigReader.getProperty("ReactshopURL"));
        ReactShoppingPage reactShoppingPage=new ReactShoppingPage();
        // 2.Web sitesindeki tüm öğeleri listeleyin ve yazdirin
        for (int i=0 ; i<reactShoppingPage.tumOgeler.size() ; i++ ) {
            System.out.println( i+1 + ".ürün: " + reactShoppingPage.tumOgeler.get(i).getText() );
        }
        // 3.Stringlerden olusan bir ArrayList oluşturun ve Ürün Adlarını ArrayList'e yerleştirin
        ArrayList<String> urunAdlariList=new ArrayList<>();
        for (WebElement e: reactShoppingPage.urunAdlari
             ) {
            urunAdlariList.add(e.getText());
            System.out.println("Ürün adi: " + e.getText());
        }
        // 4.Siteden Rastgele 5 öğe seçin, sepete ekleyin ve sectiginiz öğelerin adlarını yazdırın
        // (Her ürün 1 defadan fazla eklenemez!)
        Faker faker=new Faker();
        List<String> secilenOgelerinAdlariList=new ArrayList<>();
        List<WebElement> secilenOgelerList=new ArrayList<>();
        String secilenUrunToplamFiyat="";
        do {
            JavascriptExecutor js= (JavascriptExecutor) Driver.getDriver();
            WebElement secilenUrun=reactShoppingPage.urunAdlari.get(faker.random().nextInt(1,16));
            js.executeScript("arguments[0].scrollIntoView()" , secilenUrun);

            if ( !(secilenOgelerList.contains(secilenUrun)) ) {
                secilenOgelerList.add(secilenUrun);
                secilenUrun.click();
                Driver.bekle(4);
                secilenOgelerinAdlariList.add(secilenUrun.getText());
                secilenUrunToplamFiyat=reactShoppingPage.secilenUrunlerToplamFiyatWebSitesi.getText().replace("$" , "").trim();
            }

            if ( !(secilenOgelerList.size() == 5) ) {
                reactShoppingPage.sepeteEkleCarpıButonu.click();
            }

        } while ( secilenOgelerList.size() <= 4 );

        for (int i=0; i < secilenOgelerinAdlariList.size() ; i++) {
            System.out.println( i+1 + ". ürün: "  + secilenOgelerinAdlariList.get(i));
        }

        // 5.Her bir öğenin fiyatını toplayın ve sonucunuzu web sitesiyle karşılaştırın
        List <String> secilenUrunlerFiyati=new ArrayList<>();
        for (WebElement e:reactShoppingPage.secilenUrunlerFiyatListesi
             ) {
            secilenUrunlerFiyati.add(e.getText().replace("$" , "").trim());
        }

        double actualResult= Double.parseDouble(secilenUrunToplamFiyat);
        double expectedResult=0.0;
        for (String s:secilenUrunlerFiyati
             ) {
            expectedResult += Double.parseDouble(s);
        }

        expectedResult= (Math.round(expectedResult*100.0)/100.0);
        Assert.assertEquals(actualResult,expectedResult, "Sonuçlar eşleşmiyor. FAİLED");

        System.out.println(actualResult);
        System.out.println(expectedResult);
        // 6.Sonuçlar eşleşiyorsa  konsola test pass yazirin
        if (expectedResult==actualResult) System.out.println("Test PASS");

        // 7.Checkout'a tıklayın
        reactShoppingPage.checkoutButonu.click();


    }

}
