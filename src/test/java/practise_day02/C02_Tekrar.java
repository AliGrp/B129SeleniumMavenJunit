package practise_day02;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class C02_Tekrar extends TestBase {

    // https://www.amazon.com/ sayfasina gidin
    // dropdown'dan "Baby" secenegini secin
    // sectiginiz option'i yazdirin
    // dropdown'daki optionlarin toplam sayısının 28'e esit oldugunu test edin
    // dropdown'daki optionların tamamını yazdırın


    @Test
    public void test01() {
        driver.get("https://www.amazon.com/");
        WebElement ddm =driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        ddmVisibleText(ddm,"Baby");
        Select select=new Select(ddm);
        System.out.println(select.getFirstSelectedOption().getText());

        Assert.assertTrue(select.getOptions().size()==28);

        List<WebElement>list=select.getOptions();
        list.forEach(t-> System.out.println(t.getText()));




    }
}
