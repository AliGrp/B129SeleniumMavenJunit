package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public abstract class TestBase {
    //TestBase class'indan obje olusturmanin onune gecilmesi icin abstract yapilabilir
//Orn: TestBase base=new TestBase();
//Bu class'a extend ettigimiz test classlarinda ulasabiliriz.
   protected static WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() throws Exception {
        bekle(3);
        driver.quit();
    }
    public static void bekle(int saniye){

        try {
            Thread.sleep(saniye * 1000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }

    }
    public static void alertAccept(){
        driver.switchTo().alert().accept();
    }
    public static void alertDismiss(){
        driver.switchTo().alert().dismiss();
    }
    public static void alertText(){
        driver.switchTo().alert().getText();
    }
    public static void alertPrompt(String text){
        driver.switchTo().alert().sendKeys(text);
    }
    public static void ddmVisibleText(WebElement ddm, String secenek){
        //DropDown VisibleText
    /*
        Select select2 = new Select(gun);
        select2.selectByVisibleText("7");

        //ddmVisibleText(gun,"7"); --> Yukarıdaki kullanım yerine sadece method ile handle edebilirim
     */
        Select select = new Select(ddm);
        select.selectByVisibleText(secenek);
    }
    public static void ddmIndex(WebElement ddm, int index){

        Select select = new Select(ddm);
        select.selectByIndex(index);
    }
    public static void ddmValue(WebElement ddm, String secenek){

        Select select = new Select(ddm);
        select.selectByValue(secenek);
    }
    //SwitchTo: Sayfalar arasi gecis methodu/
    //Index sifirdan baslar girilen indexteki windowHandle degerini alarak o safaya geis yapar
    public static void switchToWindow(int sayfaIndex){
        List<String> windowHandleList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowHandleList.get(sayfaIndex));
    }

}
