package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

//        http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");
//        Signin buttonuna tiklayin
//        Login alanine  “username” yazdirin
//        Password alanine “password” yazdirin
//        Sign in buttonuna tiklayin
//        Pay Bills sayfasina gidin
//        amount kismina yatirmak istediginiz herhangi bir miktari yazin
//        tarih kismina “2020-09-10” yazdirin
//        Pay buttonuna tiklayin
//        “The payment was successfully submitted.” mesajinin ciktigini control edin
    }
}
