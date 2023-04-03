package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_Iframe extends TestBase {
    /*
https://the-internet.herokuapp.com/iframe sayfasına gidiniz
Kalın yazının "Editor" kelimesimi içerdiğini doğrulayınız
Textbox içindeki yazıyı siliniz.
Sildiğiniz yazı yerine "Bu textbox iFrame içinde yer almaktadır" yazınız.
Sayfadaki "Elemental Selenium" yazısının görünür olduğunu doğrulayınız.
 */

    @Test
    public void iframe() {
        driver.get("https://the-internet.herokuapp.com/iframe");
        WebElement sayfaBasligi=driver.findElement(By.xpath("//*[text()='An iFrame containing the TinyMCE WYSIWYG Editor']"));
        Assert.assertTrue(sayfaBasligi.getText().contains("Editor"));

        //Textbox içindeki yazıyı siliniz.
        //once iframe gecis yapmaliyiz
        WebElement iFrame= driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(iFrame);

        WebElement textBox=driver.findElement(By.xpath("//*[text()='Your content goes here.']"));
       textBox.clear();
       //Sildiğiniz yazı yerine "Bu textbox iFrame içinde yer almaktadır" yazınız.
        textBox.sendKeys("Bu textbox iFrame içinde yer almaktadır");

        //Sayfadaki "Elemental Selenium" yazısının görünür olduğunu doğrulayınız.
        // Webelementimiz default page icinde oldugu icin once driver'i iframe disina alalim
        driver.switchTo().defaultContent();
        WebElement elemantalSelenium =driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(elemantalSelenium.isDisplayed());
    }
}
