package practise_day03;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Task10 extends TestBase {
    //https://www.selenium.dev/downloads/ adresine gidelim
    //Sayfanın resmini alalım
    //Platforms Supported by Selenium altındaki Browsers bölümü görünene kadar sayfayı indirelim
    //Browser bölümünden Chrome driver bölümündeki documentation linkine tıklıyalım
    //Documentation webelementinin resmini alalım
    //All versions available in Downloads altında Latest stable release olan linki tıklayalım
    //Açılan pencerede chromedriver'i indirelim
    //Driver'in indiğini doğrulayalım
    //İndirmiş olduğumuz dosyayı silelim
    //Silindiğini doğrulayalım
    //Not: Bu task'in her adımı için Html rapor oluşturalım(Extent Report)


    @Test
    public void name() throws IOException {
        extentTest=extentReports.createTest("Extents","Test Raporu");
        driver.get("https://www.selenium.dev/downloads/");
        extentTest.info("Selenium.com sayfasina gidildi");
        String firstPage =driver.getWindowHandle();
        extentTest.info("Selenium.com sayfasinin window handle degeri alindi");
       tumSayfaResmi();
        extentTest.info("Selenium.com sayfasinin anasayfasinin ekran resmi alindi alindi");

        Actions actions = new Actions(driver);
        actions.keyDown(Keys.PAGE_DOWN).keyDown(Keys.PAGE_DOWN).perform();
        bekle(3);
        extentTest.info("Selenium.com sayfasinda Browser bolumune kadar actions methodlari ile sayfa indirildi ");


        driver.findElement(By.xpath("(//button[@class='btn btn-dark btn-lg btn-block rounded-0 text-left'])[1]")).click();
        extentTest.info("Selenium.com sayfasinda browser bolumu click edildi.");
        driver.findElement(By.xpath("(//*[text()='documentation'])[5]")).click();
        extentTest.info("Browser bölümünden Chrome driver bölümündeki documentation linkine tıklandi.");tumSayfaResmi();
        extentTest.info("Documentation webelementinin ekran resmi alindi");


        driver.findElement(By.xpath("//*[text()='ChromeDriver 112.0.5615.49']")).click();
        Set<String> pages =driver.getWindowHandles();
        List<String> pages2 = new ArrayList<>(pages);
        String birinci =pages2.get(0);
        String ikinci =pages2.get(1);
        if (firstPage.equals(birinci)){
            driver.switchTo().window(ikinci);
        }else {
            driver.switchTo().window(birinci);
        }

        driver.findElement(By.xpath("//a[text()='chromedriver_win32.zip']")).click();
        extentTest.info("Acilen yeni pencereye gecilerek chromedriver'i indirdik ");

        String userHome=System.getProperty("user.home");
        Assert.assertTrue(Files.exists(Paths.get(userHome+"/Downloads/chromedriver_win32 (1).zip")));
        extentTest.info("Chrome driverin bilgisarimiza indirildigini dogruladik ");

        Files.deleteIfExists(Path.of(userHome+"/Downloads/chromedriver_win32 (1).zip"));
        extentTest.info("Bilgisayarimiza otomasyon ile indirdigimiz chrome driveri sildik ");
        Assert.assertFalse(Files.exists(Paths.get(userHome+"/Downloads/chromedriver_win32 (1).zip")));
        extentTest.info("Bilgisayarimiza otomasyon ile indirdigimiz chrome driverin silindigini dogruladik ");

    }
}
