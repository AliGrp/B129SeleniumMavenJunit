package practise_day02;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C07_Task07 extends TestBase {

    @Test
    public void test01() {
//        http://szimek.github.io/signature_pad/ sayfasına gidiniz
        driver.get("http://szimek.github.io/signature_pad/");
//        - Çıkan ekrana istediğiniz çizgi yada şekli çiziniz
        Actions actions = new Actions(driver);
        WebElement cizim = driver.findElement(By.xpath("//*[@class='signature-pad--body']"));

       actions.clickAndHold(cizim).
               moveByOffset(20,35).
               moveByOffset(20,25).
               moveByOffset(17,0).
               moveByOffset(-70,-50).release().perform();
        bekle(3);

//        - Çizimden sonra clear butonuna basınız
        driver.findElement(By.xpath("//*[text()='Clear']")).click();
//        - Sayfayi kapatiniz
    }
}
