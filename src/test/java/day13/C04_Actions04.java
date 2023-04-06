package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_Actions04 extends TestBase {
    /*
https://jqueryui.com/droppable/ adresine gidin
"Drag me to my target" elementini "Drop here" elementi üzerine bırakınız.
*/
    @Test
    public void test01() {
        driver.get("https://jqueryui.com/droppable/");
        Actions actions = new Actions(driver);
        WebElement iframe=driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
        driver.switchTo().frame(iframe);
        WebElement firstBox=driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement secondBox=driver.findElement(By.xpath("//div[@id='droppable']"));
        actions.dragAndDrop(firstBox,secondBox).perform();

    }

    @Test
    public void actionsTest2() {
//        https://jqueryui.com/droppable/ adresine gidin
        driver.get("https://jqueryui.com/droppable");

//        "Drag me to my target" elementini "Drop here" elementi üzerine bırakınız.
        //Sayfada iFrame olduğu için "switch" yapıyoruz:
        driver.switchTo().frame(0);

        //Kaynak ve hedef web elementlerini locate ediyoruz:
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        Actions actions = new Actions(driver);
        bekle(2);
        actions.
                clickAndHold(source).//clickAndHold web elementi tıklar ve tutar
                moveToElement(target).//moveToElement mouse'u bir element üzerine taşır
                release().//release methodu tıklanıp tutulan mouse'u bırakır
                perform();
        //Burada dragAndDrop'tan farklı olarak işlemleri kendimiz sırayla belirttik.

    }

    @Test
    public void test03() {
        driver.get("https://jqueryui.com/droppable/");
        Actions actions = new Actions(driver);
        WebElement iframe=driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
        driver.switchTo().frame(iframe);
        WebElement firstBox=driver.findElement(By.xpath("//div[@id='draggable']"));

        actions.clickAndHold(firstBox).moveByOffset(165,19).perform();


    }
}
