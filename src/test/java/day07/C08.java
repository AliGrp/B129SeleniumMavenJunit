package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C08 extends C08_Parent {
//    https://www.facebook.com adresine gidin
//            - Cookies’i kabul edin
//- “Create an Account” button’una basin
//- “radio buttons” elementlerini locate edin
//- Secili degilse cinsiyet butonundan size uygun olani
//            secin


    @Test
    public void test01(){
        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        WebElement ad =driver.findElement(By.xpath("//input[@name='firstname']"));
        ad.sendKeys("ali", Keys.ENTER);

        WebElement erkek=driver.findElement(By.xpath("//*[text()='Erkek']"));
        WebElement kadin=driver.findElement(By.xpath("//*[text()='Kadın']"));
        WebElement ozel=driver.findElement(By.xpath("//*[text()='Özel']"));
        if (!erkek.isSelected()){
            erkek.click();
        }
    }
    @Test
    public void test02(){
        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        WebElement ad =driver.findElement(By.xpath("//input[@name='firstname']"));
        ad.sendKeys("ali", Keys.ENTER);
        WebElement soyad =driver.findElement(By.xpath("//input[@name='lastname']"));
        soyad.sendKeys("can", Keys.ENTER);
        WebElement mesaj = driver.findElement(By.xpath("u_3_g_D0"));
        System.out.println(mesaj.getText());
        System.out.println(mesaj.isDisplayed());


    }
}
