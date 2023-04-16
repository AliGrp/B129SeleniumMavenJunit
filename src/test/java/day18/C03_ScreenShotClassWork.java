package day18;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C03_ScreenShotClassWork extends TestBase {

    @Test
    public void classWork() {
        //Techpro sayfasina git
        driver.get("https://techproeducation.com");
        //sayfanin resmini al
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        tumSayfaResmi();
        //java arat
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys("java", Keys.ENTER);
        //ve sonuc yazisinin resmini alalim
        WebElement sonucYazisi1= driver.findElement(By.xpath("//h1"));
        webElementResmi(sonucYazisi1);
        //yeni bir sekmede amazona gidelim
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com");
        //sayfanin resmini alalim
        tumSayfaResmi();
        //iphone arat
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone",Keys.ENTER);
        //sonuc yazisinin resmini al
        tumSayfaResmi();
        //tekrar techproya gec ss al
        switchToWindow(0);
        tumSayfaResmi();
    }
}
