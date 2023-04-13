package day16;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_TimeOutException extends TestBase {
    @Test
    public void TimeOutException() {
        driver.get("https://www.techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

            WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("Yanlış Locator")));//org.openqa.selenium.TimeoutException
        //TimeoutException explicit wait kullanımında web element bulunamadığı zaman alınır.

    }

    @Test
    public void TimeOutException02() {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.xpath("//div[@id='start']//button")).click();

        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(2));

        boolean isTrue=wait.until(ExpectedConditions.textToBe(By.xpath("//div[@id='finish']//h4"),"Hello World!"));//org.openqa.selenium.TimeoutException
        //Locator doğru ama yeterli bekleme süresi olmadığı için TimeoutException alıyoruz.
        System.out.println(isTrue);
    }
}