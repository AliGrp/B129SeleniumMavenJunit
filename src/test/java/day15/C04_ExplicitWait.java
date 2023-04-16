package day15;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C04_ExplicitWait extends TestBase {

      /*
    https://the-internet.herokuapp.com/dynamic_controls sayfasına gidin
    Add tuşuna basın
    "It's gone!" yazısını doğrulayın
     */

    @Test
    public void explicitWait(){
//        https://the-internet.herokuapp.com/dynamic_controls sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
//        Remove Tusna basin
        driver.findElement(By.xpath("//*[text()='Remove']")).click();

//       "It's gone!" yazısını
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.findElement(By.xpath("//*[@id='message']"));

    }

    @Test
    public void fluentWait(){
//        https://the-internet.herokuapp.com/dynamic_controls sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
//        Remove Tusna basin
        driver.findElement(By.xpath("//*[text()='Remove']")).click();

//       "It's gone!" yazısını
        Wait<WebDriver> wait=new FluentWait<>(driver).withTimeout(Duration.ofSeconds(20)).
                pollingEvery(Duration.ofSeconds(3)).withMessage("selam").ignoring(TimeoutException.class);

        WebElement waits=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='message']")));
        Assert.assertTrue(waits.isDisplayed());

    }
}
