package day14;

import net.bytebuddy.implementation.bytecode.ShiftLeft;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class CO1_Axtions extends TestBase {
    /*
"https://techproeducation.com/" gidin
İlk kelime SHIFT tuşuna basılı şekilde, ikinci kelime basılmadan "TECHPRO education" araması yapın.
 */

    @Test
    public void name() {
        driver.get("https://techproeducation.com/");
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();
        Actions actions = new Actions(driver);
        WebElement search =driver.findElement(By.xpath("//*[@class='elementor-search-form__input']"));
        actions.keyDown(search,Keys.SHIFT).sendKeys("techpro").keyUp(Keys.SHIFT).sendKeys(" education",Keys.ENTER).build().perform();
    }
}
