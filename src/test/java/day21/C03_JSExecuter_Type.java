package day21;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_JSExecuter_Type extends TestBase {
    @Test
    public void name() {
         /*
Techpro education ana sayfasina git
Arama kutusuna QA yaz
 */
        driver.get("https://techproeducation.com/");
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();

        WebElement searchBox=driver.findElement(By.xpath("//input[@class='elementor-search-form__input']"));
//        JavascriptExecutor Js= (JavascriptExecutor) driver;
//        Js.executeScript("arguments[0].setAttribute('value','QA');",searchBox);

        typeWithJs(searchBox,"QA");
        searchBox.submit();

    }
}
