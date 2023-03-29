package practise_day;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class C03 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        // https://ebay.com sayfasına gidiniz
        driver.get("https://ebay.com");
        // electronics bolumune tıklayınız
        driver.findElement(By.xpath("(//*[text()='Electronics'])[2]")).click();
        // genisligi 225 ve uzunlugu 225 olan resimlerin hepsine sırasıyla tıklayınız ve sayfa baslıgını yazdırınız
int sum =1;
        for (int i = 0; i <24 ; i++) {
            List<WebElement> resimler= driver.findElements(By.xpath("//img[@width='225' and @height='225']"));
            resimler.get(i).click();
            System.out.println(sum+")"+driver.getTitle());
            driver.navigate().back();
            sum++;

        }
        // sayfayı kapatınız
    }
}
