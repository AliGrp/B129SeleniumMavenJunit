package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class C01_Assertion {

//    1)https://www.amazon.com adresine gidin
//    2)Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin
//          => Sayfa başlığının “Amazon” oldugunu test edin
//          => Amazon resminin görüntülendiğini (isDisplayed()) test edin
//          ○  Search Box 'in erisilebilir oldugunu test edin (isEnabled())
//          ○  wrongTitleTest => Sayfa basliginin “amazon” icermedigini dogrulayin

WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.close();
    }

    @Test//=> Sayfa başlığının “Amazon” oldugunu test edin
    public void test01() {
    String actual =driver.getTitle();
    String expected = "Amazon";
       boolean iceriyormu = actual.contains(expected);
       Assert.assertTrue(iceriyormu);

    }
    @Test
    public void test02() {
        WebElement logo = driver.findElement(By.xpath("//a[@id='nav-logo-sprites']"));
        boolean gorunurMu=logo.isDisplayed();
        Assert.assertTrue(gorunurMu);
    }
    @Test
    public void test03() {
        WebElement searchBox=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        Assert.assertTrue(searchBox.isEnabled());


    }
    @Test
    public void test04() {
        String actual =driver.getTitle();
        String expected = "amazon";
        boolean iceriyormu = actual.contains(expected);
        Assert.assertFalse(iceriyormu);

    }


}
