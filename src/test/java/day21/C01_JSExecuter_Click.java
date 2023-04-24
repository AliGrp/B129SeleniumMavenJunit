package day21;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import static org.junit.Assert.assertEquals;

public class C01_JSExecuter_Click extends TestBase {

    @Test
    public void javaScript() {

        /*
http://www.uitestpractice.com/Students/Form sayfasına git
Formu doldur
Submit tuşuna tıkla
Sayfa adresinin "http://www.uitestpractice.com/Students/Form?optradio=on" olduğunu doğrula.
*/

        driver.get("http://www.uitestpractice.com/Students/Form");

        driver.findElement(By.id("firstname")).sendKeys(Faker.instance().name().firstName());
        driver.findElement(By.id("lastname")).sendKeys(Faker.instance().name().lastName());
        driver.findElement(By.id("email")).sendKeys(Faker.instance().internet().emailAddress());

        WebElement submit=driver.findElement(By.xpath("//button[text()='Submit']"));
        //submit.click(); Seleniium click calismadi Js Executer deniyorum

        clickByJS(submit);
//        // JavascriptExecutor kullanmak icin ilk adim olarak driver’imizi JavascriptExecutor’a cast
//        //edelim
//        JavascriptExecutor jsExecuter=(JavascriptExecutor) driver;
//
//        //executeScript() metodu ile uygun script'i çalıştırıyoruz:
//        jsExecuter.executeScript("arguments[0].click();",submit);

        //        Sayfa adresinin "http://www.uitestpractice.com/Students/Form?optradio=on" olduğunu doğrula.
        assertEquals("http://www.uitestpractice.com/Students/Form?",driver.getCurrentUrl());


    }
}
