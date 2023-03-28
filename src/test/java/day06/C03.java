package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;

public class C03 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

//        https://www.amazon.com/ sayfasina gidelim
        driver.get("https://www.amazon.com/");
//        arama kutusunu locate edelim
        WebElement aramaKutusu=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
//        “Samsung headphones” ile arama yapalim
        aramaKutusu.sendKeys("Samsung Headphones", Keys.ENTER);
//        Bulunan sonuc sayisini yazdiralim
        WebElement sonuc=driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String sonucSayisi = sonuc.getText().split(" ")[2];
        System.out.println("sonucSayisi = " + sonucSayisi);

        Arrays.stream(sonuc.getText().split(" ")).skip(2).limit(1).forEach(t-> System.out.println("sonuc sayisi: "+t));
//        Ilk urunu tiklayalim
        List<WebElement> urunler = driver.findElements(By.xpath("//img[@class='s-image']"));
        urunler.get(0).click();
//        Sayfadaki tum basliklari yazdiralim
        List<WebElement> basliklar = driver.findElements(By.xpath("//h1"));
        for (WebElement w:basliklar) {
            System.out.println("baslilar = " + w.getText());
        }
        basliklar.stream().forEach(t-> System.out.println(t.getText()));

    }
}
