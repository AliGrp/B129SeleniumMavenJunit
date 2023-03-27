package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_MavenIlkTest {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        //    1. https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com/");
        //    2. arama kutusunu locate edelim
        WebElement aramaKutuusu = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        //    3. “Samsung headphones” ile arama yapalim
        aramaKutuusu.sendKeys("Samsung headphones", Keys.ENTER);
        //    4. Bulunan sonuc sayisini yazdiralim
        WebElement sonuc = driver.findElement(By.xpath("//*[text()='1-16 of 220 results for']"));
        String sonucSayisi=sonuc.getText().split(" ")[2];
        System.out.println("sonucSayisi = " + sonucSayisi);
        //    5. Ikinci urunu tiklayalim
        WebElement urun = driver.findElement(By.xpath("(//img[@class='s-image'])[2]"));
        urun.click();
        //    6. Sayfadaki tum basliklari yazdiralim
        List<WebElement> basliklar = driver.findElements(By.xpath("//h1"));
        for (WebElement w:basliklar) {
            System.out.println("baslilar = " + w.getText());
        }
        basliklar.stream().forEach(t-> System.out.println(t.getText()));
    }



}
