package practise_day02;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class C01_DropDownMenu extends TestBase {
    @Test
    public void test01() {
        // https://www.amazon.com/ sayfasina gidin
        // dropdown'dan "Books" secenegini secin
        // arama cubuguna "Java" aratın
        // arama sonuclarinin Java icerdigini test edin

        driver.get("https://www.amazon.com/");
        WebElement books=driver.findElement(By.xpath("//select[@class='nav-search-dropdown searchSelect nav-progressive-attrubute nav-progressive-search-dropdown']"));
        ddmVisibleText(books,"Books");
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("java", Keys.ENTER);

        WebElement aramaSonucu=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        System.out.println("aramaSonucu = " + aramaSonucu.getText());
        String sonucYazisi=aramaSonucu.getText();
        Assert.assertTrue(sonucYazisi.contains("java"));


    }
}
