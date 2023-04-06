package day13;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Actions02 extends TestBase {
    @Test
    public void test01() {
        /*
    Amazon anasayfasına gidin
    "Account & List" üzerinde bekleyin (mouse over - hover over)
    Açılan menüde "Account" linkine tıklayın
    Açılan sayfanın başlığının "Your Account" içerdiğini doğrulayın
     */
        driver.get("https://www.amazon.com");
        Actions actions = new Actions(driver);
        WebElement accountList=driver.findElement(By.xpath("//*[@id='nav-link-accountList']"));
        actions.moveToElement(accountList).perform();
        driver.findElement(By.xpath("//*[text()='Account']")).click();

        WebElement baslik =driver.findElement(By.xpath("//h1"));
        System.out.println("baslik = " + baslik.getText());
        Assert.assertEquals("Your Account",baslik.getText());
    }
}
