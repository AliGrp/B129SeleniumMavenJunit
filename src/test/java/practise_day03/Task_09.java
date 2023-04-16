package practise_day03;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class Task_09 extends TestBase {


    @Test
    public void name() {
        //https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver sayfasına gidelim
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");
//Click me, to open an alert after 5 seconds butonuna basalım
        driver.findElement(By.id("alert")).click();
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
         wait.until(ExpectedConditions.alertIsPresent()).accept();

//Çıkan alert'i kapatalım
    }
}
