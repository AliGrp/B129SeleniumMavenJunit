package practise_day02;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_RadioButton extends TestBase {
    // https://demo.guru99.com/test/radio.html adresine gidin
    // radiobutton elementlerini locate edin
    // option2'yi secin
    // option2 elementlerinin secili oldugunu Test edin
    // option1 elementlerinin secili olmadıgını test edin
    // option3 elementlerinin secili olmadıgını test edin
    @Test
    public void test01() {
        // https://demo.guru99.com/test/radio.html adresine gidin
        driver.get("https://demo.guru99.com/test/radio.html");
        // radiobutton elementlerini locate edin
        WebElement option1=driver.findElement(By.xpath("//input[@id='vfb-7-1']"));
        WebElement option2=driver.findElement(By.xpath("//input[@id='vfb-7-2']"));
        WebElement option3=driver.findElement(By.xpath("//input[@id='vfb-7-3']"));

        // option2'yi secin
        option2.click();
        // option2 elementlerinin secili oldugunu Test edin
        Assert.assertTrue(option2.isSelected());
        // option1 elementlerinin secili olmadıgını test edin
        Assert.assertFalse(option1.isSelected());
        // option3 elementlerinin secili olmadıgını test edin
        Assert.assertFalse(option3.isSelected());

    }
}
