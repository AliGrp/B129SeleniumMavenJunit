package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_AlertMethods extends TestBase {
    @Test
    public void acceptAlert() throws InterruptedException {
//        https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
//        Bir metod olusturun: acceptAlert
//        1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  “You successfully clicked an alert” oldugunu test edin.
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        Thread.sleep(3000);
       bekle(3);
       alertAccept();
        String actualText = driver.findElement(By.xpath("//*[@id='result']")).getText();
        String expectedText = "You successfully clicked an alert";
        Assert.assertEquals(expectedText,actualText);

//                Bir metod olusturun: dismissAlert
//        2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
//    “successfuly” icermedigini test edin.
//                Bir metod olusturun: sendKeysAlert
//        3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
////        tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.



    }
    @Test
    public void dismissAlert() throws InterruptedException {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        //    2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        driver.findElement(By.cssSelector("button[onclick='jsConfirm()']")).click();
       bekle(3);
        alertDismiss();
        bekle(3);
        String actualText = driver.findElement(By.xpath("//*[@id='result']")).getText();
        String expectedText = "successfuly";
        Assert.assertFalse(actualText.contains(expectedText));
    }

    @Test
    public void getText() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        alertText();
    }
    @Test
    public void sendKeys() throws InterruptedException {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        alertPrompt("Ali..");
       bekle(3);
       alertAccept();

        WebElement name=driver.findElement(By.xpath("//*[@id='result']"));
        String actualName =name.getText().split(" ")[2];
        String expectedname = "Ali..";
        Assert.assertTrue(actualName.contains(expectedname));
    }


}
