package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

public class HotelMyCampPage {


    public HotelMyCampPage(){
        PageFactory.initElements(Driver.getDriver(), this);
     }

    @FindBy(xpath="//a[text()='Log in']")
    public WebElement ilkLoginLinki;

    @FindBy(xpath="//input[@id='UserName']")
    public WebElement usernameBox;

    @FindBy(xpath="//input[@id='Password']")
    public WebElement passwordBox;

    @FindBy(xpath="//input[@id='btnSubmit']")
    public WebElement loginButonu;

    @FindBy(xpath="//span[.='Try again please']")
    public WebElement gecersizGirisYazisi;

    @FindBy (xpath="(//div[@class='row'])[2]")
    public WebElement loginCercevesi;

    @FindBy (xpath = "//span[.='Hotel Management']")
    public WebElement hotelManagementButton;

    @FindBy (xpath = "//a[@href='/admin/HotelRoomAdmin']")
    public WebElement hotelRoomsButton;

    @FindBy (className = "hidden-480")
    public WebElement addHotelRoomButton;

    @FindBy (xpath = "//select[@id='IDHotel']")
    public WebElement hotelDropdown;

    @FindBy (xpath = "//input[@id='Code']")
    public WebElement codeKutusu;

    @FindBy (id= "uniform-IsAvailable")
    public WebElement approvedButton;

    @FindBy (xpath = "//button[@id='btnSubmit']")
    public WebElement hotelRoomsSaveButton;

    @FindBy (xpath = "//div[.='HotelRoom was inserted successfully']")
    public WebElement basariliGirisOnayTexti;

    @FindBy (xpath = "//button[@data-bb-handler='ok']")
    public WebElement basariliGirisOnayTextiOKButonu;


    @FindBy (xpath = "//span[.='List Of Hotelrooms']")
    public WebElement hotelRoomsListOnayYazisi;




    public void loginOl() {
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        ilkLoginLinki.click();
        usernameBox.sendKeys(ConfigReader.getProperty("HMCValidUsername"));
        passwordBox.sendKeys(ConfigReader.getProperty("HMCValidPassword"));
        loginButonu.click();
    }


    public void bekle(int saniye){
        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }








}


