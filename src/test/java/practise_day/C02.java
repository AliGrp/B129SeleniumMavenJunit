package practise_day;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;

public class C02 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");
        // sayfa baslıgının "Google" kelimesini icerdigini test edin
        if (driver.getTitle().contains("Google")){
            System.out.println("Google Kelimesini Iceriyor");
        }else System.out.println("Google Kelimesini Icermiyor");
        // arama cubuguna "Nutella" yazıp aratın
        driver.findElement(By.xpath("//input[@class='gLFyf']")).sendKeys("Nutella", Keys.ENTER);
        // bulunan sonuc sayısını yazdırın
        WebElement sonuzYazisi = driver.findElement(By.xpath("//*[@id='result-stats']"));
        String sonucSayisi = sonuzYazisi.getText().split(" ")[1];
        System.out.println("sonucSayisi = " + sonucSayisi);
        // sonuc sayısının 100000000  fazla oldugunu test edin
        sonucSayisi=sonucSayisi.replace("\\D","");
        int actual = Integer.parseInt(sonucSayisi);
        if (actual>100000000){
            System.out.println("100000000 Fazla" );
        }else System.out.println("100000000 Fazla" );

        // sayfayı kapatın
        driver.close();
    }
}
