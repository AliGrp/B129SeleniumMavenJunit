package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class C02_WindowHandle extends TestBase {
    @Test
    public void windowHandle() throws InterruptedException {
//    https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
//    İlk sayfanın ID'sini alın.
        String window1Handle=driver.getWindowHandle();
        System.out.println("window1Handle = " + window1Handle);

//    Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement text1=driver.findElement(By.xpath("//*[text()='Opening a new window']"));
        Assert.assertEquals(text1.getText(),"Opening a new window");
//    Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        Assert.assertTrue(driver.getTitle().contains("The Internet"));
//            "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("//*[.='Click Here']")).click();
//    Açılan pencereye geçin.
        //bu safhada 2 pencere acik 2nci pencecreye gecis yapiyorum
        Set<String> allWindowHandles=driver.getWindowHandles();
        System.out.println("allWindowHandles = " + allWindowHandles);
        for (String w:allWindowHandles){
            if (!w.equals(window1Handle)){
                driver.switchTo().window(w);
            }
        }

//    Açılan yeni pencerenin sayfa başlığının(title) “New Window” olduğunu doğrulayın.
        Assert.assertEquals("New Window",driver.getTitle());
        String window2Handle=driver.getWindowHandle();
        System.out.println("window2Handle = " + window2Handle);
//    Bir önceki pencereye dönüp sayfa başlığının “The Internet” olduğunu  doğrulayın.
        driver.switchTo().window(window1Handle);
        bekle(3);
        Assert.assertEquals("The Internet",driver.getTitle());
//            2. pencereye tekrar geçin.
        driver.switchTo().window(window2Handle);
        bekle(3);
//    1. pencereye tekrar dönün.
        driver.switchTo().window(window1Handle);
        bekle(3);
    }


}
