package practise_day;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        // https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");
        // arama kutusunun, tagName'inin 'input' oldugunu test ediniz
        WebElement aramaKutusu= driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        String actualTag =aramaKutusu.getTagName();
        String expectedTag = "input";

        if (actualTag.equals(expectedTag)){
            System.out.println("Test Passed");
        }else System.out.println("Test Failed");
        // arama kutusunun, name attribute'nun degerinin 'field-keywords' oldugunu test edin
        String actualATT=aramaKutusu.getAttribute("name");
        String expectedATT="field-keywords";
       if (actualATT.equals(expectedATT)){
           System.out.println("Test Passed");
       }else System.out.println("Test Failed");
        // sayfayi kapatiniz
        driver.close();
    }
}
