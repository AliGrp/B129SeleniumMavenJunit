package practise_day05;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C01_Waits extends TestBase {

    // https://the-internet.herokuapp.com/dynamic_controls adresine gidiniz
    // Textbox'in etkin olmadıgını(enable) test edin
    // Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
    // It's enable! mesajının goruntulendigini test edin
    // Textbox'in etkin oldugunu(enable) test edin

    @Test
    public void name() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement text =driver.findElement(By.cssSelector("[type='text']"));
        Assert.assertFalse(text.isEnabled());

        WebElement enable=driver.findElement(By.xpath("(//button[@type='button'])[2]"));
        enable.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
         wait.until(ExpectedConditions.elementToBeClickable(text));


        WebElement message = driver.findElement(By.id("message"));
        Assert.assertEquals("It's enabled!",message.getText());

        Assert.assertTrue(text.isEnabled());


    }
}
