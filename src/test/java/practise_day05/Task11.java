package practise_day05;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Task11 extends TestBase {

    /*
    -İki tane test methodu oluşturalım
    -İlkinde masaüstünde java ile data.xlsx isimli bir dosya oluşturalım
    -Birinci satır birinci hücreye email ve ikinci hücreye password
    -ikinci satır birinci hücreye evren.techproed@gmail.com ve ikinci hücreye asdfgh yazdıralım
    -Dosyayı kaydedelim
    -İkinci methodda https://www.bluerentalcars.com/ adresine gidip
    -Excel dosyasından aldığımız kullanıcı bilgileri ile login olalım
    -Login olduğumuzu doğrulayalım
*/

    @Test
    public void name() throws IOException {

        FileInputStream fileInputStream=new FileInputStream("C:\\Users\\ASUS\\Desktop\\task.xlsx");
        Workbook workbook= WorkbookFactory.create(fileInputStream);
        Sheet sayfa1=workbook.getSheet("Sayfa1");

        Cell yeniHucre=sayfa1.getRow(0).createCell(0);
        yeniHucre.setCellValue("email");
        Cell yeniHucre2=sayfa1.getRow(0).createCell(1);
        yeniHucre2.setCellValue("password");

        Cell yeniHucre3=sayfa1.getRow(1).createCell(0);
        yeniHucre3.setCellValue("evren.techproed@gmail.com");
        Cell yeniHucre4=sayfa1.getRow(1).createCell(1);
        yeniHucre4.setCellValue("asdfgh");

        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\ASUS\\Desktop\\task.xlsx");
        workbook.write(fileOutputStream);

    }

    @Test
    public void test01() throws IOException {
        FileInputStream fileInputStream=new FileInputStream("C:\\Users\\ASUS\\Desktop\\task.xlsx");
        Workbook workbook= WorkbookFactory.create(fileInputStream);
        Sheet sayfa1=workbook.getSheet("Sayfa1");

        driver.get("https://www.bluerentalcars.com");
        driver.findElement(By.xpath("//*[@class='btn btn-primary btn-sm']")).click();
        driver.findElement(By.id("formBasicEmail")).sendKeys(sayfa1.getRow(1).getCell(0).toString());
        driver.findElement(By.id("formBasicPassword")).sendKeys(sayfa1.getRow(1).getCell(1).toString());
        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();

        WebElement ddm=driver.findElement(By.id("dropdown-basic-button"));
        Assert.assertTrue(ddm.isEnabled());



    }
}
