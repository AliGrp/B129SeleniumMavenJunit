package day20;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02 {

    @Test
    public void name() throws IOException {
           /*
    Bir "NÜFUS" sütunu oluşturup başkent nüfuslarını excel doyasına yazınız:
    (D.C: 712816, Paris: 2161000, London: 8982000, Ankara: 5663000 ...)
     */
        Workbook workbook = WorkbookFactory.create(new FileInputStream("C:\\Users\\ASUS\\IdeaProjects\\B129SeleniumMavenJunit\\src\\test\\java\\reseources\\Capitals.xlsx"));

        Sheet sheet1=workbook.getSheet("Sheet1");
        Cell yeniHucreNufus = sheet1.getRow(0).createCell(3);
        yeniHucreNufus.setCellValue("NÜFUS2");
        System.out.println("yeniHucreNufus = " + yeniHucreNufus);

        sheet1.getRow(1).createCell(3).setCellValue(712816);
        sheet1.getRow(2).createCell(3).setCellValue(2161000);
        sheet1.getRow(3).createCell(3).setCellValue(8982000);
        sheet1.getRow(4).createCell(3).setCellValue(5663000);
        sheet1.getRow(5).createCell(3).setBlank();

        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\ASUS\\IdeaProjects\\B129SeleniumMavenJunit\\src\\test\\java\\reseources\\Capitals.xlsx");

        workbook.write(fileOutputStream);

    }
}
