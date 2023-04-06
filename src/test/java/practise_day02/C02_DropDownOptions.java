package practise_day02;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class C02_DropDownOptions extends TestBase {
    // https://www.amazon.com/ sayfasina gidin
    // dropdown'dan "Baby" secenegini secin
    // sectiginiz option'i yazdirin
    // dropdown'daki optionlarin toplam sayısının 28'e esit oldugunu test edin
    // dropdown'daki optionların tamamını yazdırın

    @Test
    public void test01() {
        // https://www.amazon.com/ sayfasina gidin
        driver.get("https://www.amazon.com/");
        // dropdown'dan "Baby" secenegini secin
        WebElement ddm=driver.findElement(By.xpath("//select[@class='nav-search-dropdown searchSelect nav-progressive-attrubute nav-progressive-search-dropdown']"));
        ddmVisibleText(ddm,"Baby");
        // sectiginiz option'i yazdirin
        Select select=new Select(ddm);
        String seciliOptions=select.getFirstSelectedOption().getText();
        System.out.println("seciliOptions = " + seciliOptions);
        // dropdown'daki optionlarin toplam sayısının 28'e esit oldugunu test edin
        Assert.assertTrue(select.getOptions().size()==28);

        // dropdown'daki optionların tamamını yazdırın
        List<WebElement> opsiyonlar =select.getOptions();
        opsiyonlar.forEach(t-> System.out.println(t.getText()));

    }
}
