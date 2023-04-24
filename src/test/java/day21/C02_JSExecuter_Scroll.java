package day21;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_JSExecuter_Scroll extends TestBase {

    @Test
    public void name() {
                /*
        Techpro education ana sayfasına git
        We Offer elementi görünür olacak şekilde üzerine scroll et ve ekran görüntüsünü al
        Aynı sayfada Enroll Free elementi görünür olacak sekilde scroll et ve ekran görüntüsünü al
        Aynı sayfada WHY US? elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
        Aynı sayfada tekrar Enroll Free elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
         */

        driver.get("https://techproeducation.com/");
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        // We Offer elementi görünür olacak şekilde üzerine scroll et ve ekran görüntüsünü al
        Actions actions = new Actions(driver);
        WebElement offer =driver.findElement(By.xpath("(//*[@class='thim-color'])[2]"));
        actions.scrollToElement(offer).perform();
        webElementResmi(offer);
        bekle(3);

        JavascriptExecutor jse= (JavascriptExecutor) driver;
        WebElement enrol = driver.findElement(By.xpath("//*[text()='Enroll Online IT Course']"));
        jse.executeScript("arguments[0].scrollIntoView(true);",enrol);
        bekle(3);


        WebElement whyUs = driver.findElement(By.xpath("(//div[@class='elementor-widget-wrap elementor-element-populated'])[25]"));
       scrollByJavaSc(whyUs);
       bekle(3);


       scrollEndJS();//sayfayi en alta kayidrir
        scrollTopJS();//sayfayi en uste kaydirir
    }
}
