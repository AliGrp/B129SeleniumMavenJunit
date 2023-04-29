package practise_day04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;
import java.util.concurrent.TimeoutException;

public class Task12 extends TestBase {
    //https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html adresine gidelim
    //Hesap makinasından 2 basamaklı random iki tane sayı seçelim ve random 4 işlemden birini yaptıralım
    //Sonucu konsola yazdırıp
    //Sonucun doğrulamasını yapalım
    @Test
    public void test01() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");
        WebElement beklemeSuresi = driver.findElement(By.id("delay"));
        beklemeSuresi.clear();
        beklemeSuresi.sendKeys("0");

        driver.findElement(By.xpath("//*[text()='7']")).click();
        driver.findElement(By.xpath("//*[text()='8']")).click();
        driver.findElement(By.xpath("//*[text()='x']")).click();
        driver.findElement(By.xpath("//*[text()='9']")).click();
        driver.findElement(By.xpath("//*[text()='1']")).click();
        driver.findElement(By.xpath("//*[text()='=']")).click();

        WebElement sonuc = driver.findElement(By.xpath("//*[@class='screen']"));
        System.out.println("sonuc = " + sonuc.getText());

        int actual = Integer.parseInt(sonuc.getText());
        int expected = 78 * 91;

        Assert.assertEquals(expected, actual);


    }

    @Test
    public void name() {

        driver.get("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");
//        WebElement beklemeSuresi=driver.findElement(By.id("delay"));
//        beklemeSuresi.clear();
//        beklemeSuresi.sendKeys("0");

        driver.findElement(By.xpath("//*[text()='7']")).click();
        driver.findElement(By.xpath("//*[text()='8']")).click();
        driver.findElement(By.xpath("//*[text()='x']")).click();
        driver.findElement(By.xpath("//*[text()='9']")).click();
        driver.findElement(By.xpath("//*[text()='1']")).click();
        driver.findElement(By.xpath("//*[text()='=']")).click();
        bekle(10);
        WebElement sonuc = driver.findElement(By.xpath("//*[@class='screen']"));
        System.out.println("sonuc = " + sonuc.getText());

//        WebDriverWait wdb = new WebDriverWait(driver, Duration.ofSeconds(60));
//        wdb.until(ExpectedConditions.visibilityOfElementLocated(By.xpath()));
//        WebElement sonuc=driver.findElement(By.xpath("//*[@class='screen']"));
//        System.out.println("sonuc = " + sonuc.getText());

//        Wait<WebDriver> wait= new FluentWait<>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(6)).
//                ignoring(TimeoutException.class);
//        WebElement sonuc= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='screen']")));
//        System.out.println("sonuc = " + sonuc.getText());


//        int actual = Integer.parseInt(sonuc.getText());
//        int expected= 78 * 91;
//
//        Assert.assertEquals(expected,actual);
    }
}
