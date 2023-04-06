package day13;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Actions01 extends TestBase {
 /*
https://the-internet.herokuapp.com/context_menu  sitesine gidin
Kutuya sağ tıklayın
Alert'te cikan yazinin "You selected a context menu" oldugunu test edin
Tamam diyerek alert'i kapatın
 */

    @Test
    public void actionTest() {
        driver.get("https://the-internet.herokuapp.com/context_menu");
        Actions actions = new Actions(driver);
        WebElement box=driver.findElement(By.xpath("//div[@id='hot-spot']"));
        actions.contextClick(box).perform();
        String mesaj =driver.switchTo().alert().getText();
        Assert.assertEquals("You selected a context menu",mesaj);
        driver.switchTo().alert().accept();
    }
}
