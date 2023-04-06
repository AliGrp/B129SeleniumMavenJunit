package practise_day02;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_CheckBox extends TestBase {
    // https://demo.guru99.com/test/radio.html adresine gidin
    // checkbox elementlerini locate edin
    // checkbox1 ve checkbox3  secili degil ise secin
    // checkbox1 ve checkbox3 elementlerinin secili oldugunu Test edin
    // checkbox2 elementinin secili olmadıgını test edin

    @Test
    public void test01() {
        driver.get("https://demo.guru99.com/test/radio.html");
        WebElement check1=driver.findElement(By.xpath("//input[@id='vfb-6-0']"));
        WebElement check2=driver.findElement(By.xpath("//input[@id='vfb-6-1']"));
        WebElement check3=driver.findElement(By.xpath("//input[@id='vfb-6-2']"));



        if (!check1.isSelected() && !check3.isSelected()){
            check1.click();
            check3.click();
        }

        Assert.assertTrue(check1.isSelected() && check3.isSelected());
        Assert.assertFalse(check2.isSelected());

    }
}
