package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

public class ReactShoppingPage {


    public ReactShoppingPage() {
        PageFactory.initElements(Driver.getDriver() , this);
    }

    @FindBy (xpath = "//div[@class='shelf-item']")
    public List<WebElement> tumOgeler;

    @FindBy (xpath = "//p[@class='shelf-item__title']")
    public List<WebElement> urunAdlari;

    @FindBy (xpath = "//div[@class='shelf-item__buy-btn']")
    public List<WebElement> sepeteEkleButonlari;

    @FindBy (xpath = "//div[@class='float-cart__close-btn']")
    public WebElement sepeteEkleCarpıButonu;

    @FindBy (xpath = "(//p[@class='title']")
    public List <WebElement> secilenWebelementleri;

    @FindBy (xpath = "//div[@class='float-cart__shelf-container']//div[@class='shelf-item__price']//p")
    public List <WebElement> secilenUrunlerFiyatListesi;

    @FindBy (xpath = "//div[@class='float-cart__footer']//div[@class='sub-price']//p")
    public WebElement secilenUrunlerToplamFiyatWebSitesi;

    @FindBy (xpath = "//div[.='Checkout']")
    public WebElement checkoutButonu;




}
