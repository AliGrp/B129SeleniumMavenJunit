package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C06 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //    1.“https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");
        //            2.Username kutusuna “standard_user” yazdirin
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        //3.Password kutusuna “secret_sauce” yazdirin
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        //4.Login tusuna basin
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        //5.Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        WebElement urun = driver.findElement(By.xpath("//img[@alt='Sauce Labs Backpack']"));
        System.out.println("urun: "+urun.getText());
        urun.click();
        //6.Add to Cart butonuna basin
        driver.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-backpack']")).click();
        //7.Alisveris sepetine tiklayin
        driver.findElement(By.xpath("//*[@id='shopping_cart_container']")).click();
        //8.Sectiginiz urunun basarili olarak sepete eklendigini control edin
        //Sectiginiz urunun basarili olarak sepete eklendigini control edin
        Thread.sleep(3000);
        String expected = "Sauce Labs Backpack";
        String actual = driver.findElement(By.xpath("//*[@class='inventory_item_name']")).getText();
        if (actual.equals(expected)) {
            System.out.println("Urun dogru");
        } else
            System.out.println("Urun YANLIS");
        //9.Sayfayi kapatin



    }

}
