package practise_day03;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Task02 extends TestBase {
    @Test
    public void name() {
//        - http://the-internet.herokuapp.com/add_remove_elements/ adresine gidiniz
//        - Add Element butonuna 100 defa basınız
//        - 100 defa basıldığını test ediniz
//        - 90 defa delete butonuna basınız
//        - 90 defa basıldığını doğrulayınız
//                - Sayfayı kapatınız

        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        WebElement addButonu=driver.findElement(By.xpath("//*[text()='Add Element']"));

        for (int i = 0; i <100 ; i++) {
            clickByJS(addButonu);
        }

        List<WebElement> deleteSayisi= driver.findElements(By.xpath("//*[text()='Delete']"));
        Assert.assertEquals(100,deleteSayisi.size());


        for (int i = 0; i <90 ; i++) {
            WebElement delete=driver.findElement(By.xpath("//*[text()='Delete']"));
            clickByJS(delete);
        }

        List<WebElement> deleteSayisi01= driver.findElements(By.xpath("//*[text()='Delete']"));
        Assert.assertEquals(10,deleteSayisi01.size());



    }
}
