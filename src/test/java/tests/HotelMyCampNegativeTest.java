package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.Driver;
import utilities.Screenshot;

import java.io.IOException;

public class HotelMyCampNegativeTest {

    // HotelMyCampNegativeTest
    //1 ) Bir Class olustur : NegativeTest
    //2) Bir test method olustur NegativeLoginTest()
    //https://www.concorthotel.com/ adresine git
    //login butonuna bas
    //test data username: manager1 ,
    //test data password : manager1!
    //Degerleri girildiginde sayfaya girilemedigini test et
    HotelMyCampPage hotelMyCampPage;

    @Test
    public void test01() throws IOException {

        Driver.getDriver().get("https://www.concorthotel.com/");
        hotelMyCampPage=new HotelMyCampPage();
        hotelMyCampPage.ilkLoginLinki.click();
        hotelMyCampPage.usernameBox.sendKeys("manager1");
        hotelMyCampPage.passwordBox.sendKeys("manager1!");
        hotelMyCampPage.loginButonu.click();

        Assert.assertTrue(hotelMyCampPage.gecersizGirisYazisi.isDisplayed());
        Screenshot.webElementScreenshot(hotelMyCampPage.loginCercevesi);
        Screenshot.tumSayfaScreenshot();

    }
}