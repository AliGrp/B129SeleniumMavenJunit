package practise_day02;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05_Alert extends TestBase {
    //http://demo.guru99.com/test/delete_customer.php adresine gidin
    //customer id kısmına 53920 yazın
    //submit butonuna tıklayın
    //cıkan alert mesajını yazdırın
    //alerti kabul edin
    //cıkan 2. alert mesajını yazdırın
    //cıkan 2. alerti kabul edin
    @Test
    public void test01() {
        //http://demo.guru99.com/test/delete_customer.php adresine gidin
        driver.get("http://demo.guru99.com/test/delete_customer.php");
        //customer id kısmına 53920 yazın
        driver.findElement(By.xpath("//*[@type='text']")).sendKeys("53920");
        //submit butonuna tıklayın
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        bekle(3);
        //cıkan alert mesajını yazdırın
        System.out.println(driver.switchTo().alert().getText());
        //alerti kabul edin
        driver.switchTo().alert().accept();
        bekle(3);
        //cıkan 2. alert mesajını yazdırın
        driver.switchTo().alert().getText();
        //cıkan 2. alerti kabul edin
        driver.switchTo().alert().accept();

    }
}
