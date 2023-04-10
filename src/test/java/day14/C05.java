package day14;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05 extends TestBase {
    @Test
    public void name() {
//        https://the-internet.herokuapp.com/
//        upload
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.linkText("File Upload")).click();
        WebElement dosya =driver.findElement(By.xpath("//*[@id='file-upload']"));
        System.getProperty("user.home"+"/Desktop/Yeni Metin Belgesi.txt");

    }
}
