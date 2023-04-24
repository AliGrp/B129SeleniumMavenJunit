package day21;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_JSExecuter_GetValue extends TestBase {
    @Test
    public void getValueJSTest() {
        //  1)getValueTest metotu olustur
        // 2)https://www.carettahotel.com/ a git
        //  3)Tarih kısmındaki Yazili metinleri al ve yazdır

        driver.get("https://www.carettahotel.com/");
        driver.findElement(By.id("details-button")).click();
        driver.findElement(By.id("proceed-link")).click();


//        JavascriptExecutor js= (JavascriptExecutor) driver;
//        String checkin_date= (String) js.executeScript("return document.getElementById('checkin_date').value");
//        System.out.println("checkin_date = " + checkin_date);
        getValueJS("checkin_date","value");
        getValueJS("checkin_date","placeholder");
    }
}
