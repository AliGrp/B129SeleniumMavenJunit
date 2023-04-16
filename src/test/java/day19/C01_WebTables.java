package day19;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C01_WebTables extends TestBase {
    //    https://the-internet.herokuapp.com/tables sayfasına gidin
//    Task 1 : Table1’i yazdırın
    // driver.findElement(By.id("table1"));

    //    Task 2 : 3. Satır verilerini yazdırın
//    Task 3 : Son verilerini verileri yazdırın
//    Task 4 : 5. Sütun verilerini yazdırın
//    Task 5 : Iki parametreli bir Java metodu oluşturalım: printData
//    Parameter 1 = satır numarası
//    Parameter 2 = sütun numarası
//    printData(2,3);  => 2. satır, 3. sütundaki veriyi yazdırsın.


    @Test
    public void webTableTest1() {
        //    Task 1 : Table1’i yazdırın
        driver.get("https://the-internet.herokuapp.com/tables");
        String table1=driver.findElement(By.id("table1")).getText();
        System.out.println("table1 = " + table1);

        //elementleri tek tek yazdiralim
        List<WebElement> tumElementler =driver.findElements(By.xpath("//table[@id='table1']//td"));
        for (WebElement w :tumElementler) {
            System.out.println(w.getText());

        }
        tumElementler.forEach(t-> System.out.println(t.getText()));
    }

    @Test
    public void webTableTest2() {
        //    Task 3 : Son satirin verilerini verileri yazdırın
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> sonSatir=driver.findElements(By.xpath("//table[@id='table1']//tbody//tr[last()]//td"));
        //last() methodu son satiri alabiliyoru
        sonSatir.forEach(t-> System.out.print(t.getText()+"|"));
    }
    @Test
    public void webTableTest3() {
        //    Task 2 : 3. Satır verilerini yazdırın
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> satir3=driver.findElements(By.xpath("//table[@id='table1']//tbody//tr[3]//td"));
        satir3.forEach(t-> System.out.print(t.getText()+"|"));
    }
    @Test
    public void webTableTest4() {
        //    //    Task 4 : 5. Sütun verilerini yazdırın
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> sutun=driver.findElements(By.xpath("//table[@id='table1']//tbody//td[5]"));
        sutun.forEach(t-> System.out.print(t.getText()+"|"));
    }


    public void printData(int satir, int sutun) {
        //    Task 5 : Iki parametreli bir Java metodu oluşturalım: printData
        //    Parameter 1 = satır numarası
        //    Parameter 2 = sütun numarası
        //    printData(2,3);  => 2. satır, 3. sütundaki veriyi yazdırsın.
        driver.get("https://the-internet.herokuapp.com/tables");
        WebElement belirliVeri =driver.findElement(By.xpath("//table[@id='table1']//tbody//tr["+satir+"]//td["+sutun+"]"));
        System.out.println(belirliVeri.getText());
    }

    @Test
    public void printDataTest() {
        printData(2,3);
        printData(4,4);
    }
}
