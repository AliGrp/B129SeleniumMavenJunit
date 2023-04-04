package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04 extends TestBase {
    @Test
    public void iframe() {
//        https://the-internet.herokuapp.com/iframe sayfasına gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");
//        Kalın yazının "Editor" kelimesini içerdiğini doğrulayınız
        String actual=driver.findElement(By.xpath("//*[text()='An iFrame containing the TinyMCE WYSIWYG Editor']")).getText();
        Assert.assertTrue(actual.contains("Editor"));
//        Textbox içindeki yazıyı siliniz.
        driver.switchTo().frame(0);
        WebElement textBox=driver.findElement(By.xpath("//*[text()='Your content goes here.']"));
        textBox.clear();
//        Sildiğiniz yazı yerine "Bu textbox iFrame içinde yer almaktadır" yazınız.
        textBox.sendKeys("ali..");
//                Sayfadaki "Elemental Selenium" yazısının görünür olduğunu doğrulayınız.
        driver.switchTo().defaultContent();
        WebElement elemental =driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        Assert.assertTrue(elemental.isDisplayed());

    }
}
