package practise_day02;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.WatchEvent;
import java.util.ArrayList;
import java.util.List;

public class C06_Task06 extends TestBase {
    // https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
// ikinci emojiye tıklayın
// İkinci emoji öğelerini yazdırınız
// Parent iframe e geri donun
// Formu doldurun,(Formu istediğiniz metinlerle doldurun)
// Apply button a basiniz

    @Test
    public void test01() {
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
        WebElement iframe=driver.findElement(By.xpath("//iframe[@id='emoojis']"));
        driver.switchTo().frame(iframe);
        WebElement fare=driver.findElement(By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]"));
        fare.click();

        List<WebElement>list=driver.findElements(By.xpath("//div[@id='nature']"));
        list.forEach(t-> System.out.println(t.getText()));

        driver.switchTo().defaultContent();

        driver.findElement(By.xpath("//input[@id='text']")).sendKeys("ali",Keys.ENTER);
        driver.findElement(By.xpath("//input[@id='smiles']")).sendKeys(":)",Keys.ENTER);
        driver.findElement(By.xpath("//input[@id='nature']")).sendKeys("jungle",Keys.ENTER);
        driver.findElement(By.xpath("//input[@id='food']")).sendKeys("domates corbasi",Keys.ENTER);
        driver.findElement(By.xpath("//input[@id='activities']")).sendKeys("bok atma",Keys.ENTER);
        driver.findElement(By.xpath("//input[@id='places']")).sendKeys("babildeki bahce",Keys.ENTER);
        driver.findElement(By.xpath("//input[@id='objects']")).sendKeys("-----",Keys.ENTER);
        driver.findElement(By.xpath("//input[@id='symbols']")).sendKeys("8==>",Keys.ENTER);
        driver.findElement(By.xpath("//input[@id='flags']")).sendKeys("++",Keys.ENTER);
        driver.findElement(By.xpath("//input[@id='hide']")).sendKeys("alo",Keys.ENTER);
        driver.findElement(By.xpath("//input[@id='active']")).sendKeys("saatler gecmiyoo",Keys.ENTER);
        driver.findElement(By.xpath("//button[@id='send']")).click();


    }
}
