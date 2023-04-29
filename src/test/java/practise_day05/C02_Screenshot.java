package practise_day05;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Screenshot extends TestBase {

    // https://www.teknosa.com/ adresine gidin
    // arama cubuguna oppo yazip enter'a basınız
    // sonuc sayisini yazdiriniz
    // ikinci urunun fotografını cekin
    // cikan ikinci urune tiklayiniz
    // iki ArrowDown sayfayı asagiya kaydirin
    // sepete ekleyiniz
    // sepetim'e git tilayiniz
    // "Siparis Ozeti" webelementinin text'ini yazdiriniz
    // Alisverisi tamamlayiniz
    // "Teknosa'ya hos geldiniz" webelementinin text'ini yazdiriniz
    // driver'i kapatiniz


    @Test
    public void name() {
        // https://www.teknosa.com/ adresine gidin
        driver.get("https://www.teknosa.com/");

        try {
            driver.findElement(By.xpath("//div[@id='button-1580496494']")).click();
        } catch (Exception e) {
            System.out.println("cookies cıkmadı");
        }


        // arama cubuguna oppo yazip enter'a basınız
        driver.findElement(By.xpath("//input[@id='search-input']")).sendKeys("Oppo" + Keys.ENTER);
        bekle(3);
        WebElement sonucYazisi=driver.findElement(By.xpath("//div[@class='plp-info']"));
        String sonucSayisi = sonucYazisi.getText().split(" ")[0];
        System.out.println("sonucSayisi = " + sonucSayisi);

        WebElement ikinciUrun=driver.findElement(By.xpath("(//a[@class='prd-link gowitPlp-js'])[2]"));
       // webElementResmi(ikinciUrun);
        ikinciUrun.click();

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        WebElement sepeteEKle=driver.findElement(By.xpath("//button[@id='addToCartButton']"));
        clickByJS(sepeteEKle);


//        WebElement reklam =driver.findElement(By.xpath("//*[@class='icon icon-close']"));//reklami kapat
//        clickByJS(reklam);
        WebElement sepeptim=driver.findElement(By.xpath("//a[@class='btn btn-primary']"));
        clickByJS(sepeptim);

        WebElement siparisOzeti =driver.findElement(By.xpath("//*[@class='cart-sum-body']"));
        System.out.println("siparisOzeti = " + siparisOzeti.getText());

        driver.findElement(By.xpath("//*[@class='btn btn-primary js-checkout-controls']")).click();

        WebElement message =driver.findElement(By.xpath("//*[@class='lrp-title']"));
        Assert.assertEquals("Teknosa’ya Hoş Geldiniz",message.getText());

    }
}
