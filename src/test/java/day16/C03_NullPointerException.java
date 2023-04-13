package day16;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.TestBase;

public class C03_NullPointerException  {
    WebDriver driver;
    Faker faker;
    int number;
    String name;
    @Test
    public void NullPointerException() {
        driver.get("https://www.techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();//Java.lang.NullPointerException ==> nul degere sahip objeler üzerinde yapılan işlemler sonrası alınır.

    }

    @Test
    public void NullPointerException02() {
        // faker = new Faker();

        System.out.println(faker.number().numberBetween(1, 10));//java.lang.NullPointerException

    }

    @Test
    public void NullPointerException03() {
        //number = 4;
        System.out.println(number + 6);//java.lang.NullPointerException
    }

    @Test
    public void NullPointerException04() {
        //name = "Ali";
        System.out.println(name.charAt(0));//java.lang.NullPointerException
    }
}
