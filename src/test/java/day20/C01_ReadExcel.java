package day20;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C01_ReadExcel {
         /*
        Capitals.xlsx dosyasından 1. satır 2. sütundaki hücreyi yazdırın
        3. Satır 1. sütun değerini yazdırın ve "France" olduğunu test edin
        Kullanılan satır sayısın bulun
        Ülke-Başkent şeklinde verileri yazdırın
         */

    @Test
    public void readExcelTest01() throws IOException {
        //Dsoyayi al:
        FileInputStream fileInputStream=new FileInputStream("src/test/java/reseources/Capitals.xlsx");

        //FileInputStream objesini WorkBook(Excel) dosyasi olarak ac
        Workbook workbook=WorkbookFactory.create(fileInputStream);

        //Sayfayi ac
        Sheet sheet1=workbook.getSheet("Sheet1");

        //Satira git
        Row row =sheet1.getRow(0);//1inci satir indeksi 0'dan baslar

        //Birinci hucreyi al
        Cell cell=row.getCell(0);
        System.out.println("cell = " + cell);

//        Capitals.xlsx dosyasından 1. satır 2. sütundaki hücreyi yazdırın
        Cell cell1=sheet1.getRow(0).getCell(1);
        System.out.println("cell1 = " + cell1);

//        3. Satır 1. sütun değerini yazdırın ve "France" olduğunu test edin
        Cell cell2=sheet1.getRow(2).getCell(0);
        System.out.println("cell2 = " + cell2);
        Assert.assertEquals("France",cell2.toString());

//        Kullanılan satır sayısıni bulun
        int sonKullanilanSatirIndeksi =sheet1.getLastRowNum();//Son kullanilan satirin indeksini verir
        System.out.println("sonKullanilanSatirIndeksi = " + sonKullanilanSatirIndeksi);

        System.out.println("sheet1.getPhysicalNumberOfRows() = " + sheet1.getPhysicalNumberOfRows());//Fiziksel olarak kullanmis satir sayisi yani arada bos olanlari saymiyor

//        Ülke-Başkent şeklinde verileri yazdırın
        Map<String,String> ulkeVeBaskentleri= new HashMap<>();

        for (int satirIndeks = 1; satirIndeks < sheet1.getPhysicalNumberOfRows(); satirIndeks++) {
            String ulkeAdi= sheet1.getRow(satirIndeks).getCell(0).toString();
            String baskentAdi= sheet1.getRow(satirIndeks).getCell(1).toString();

            ulkeVeBaskentleri.put(ulkeAdi,baskentAdi);

        }

        System.out.println("ulkeVeBaskentleri = " + ulkeVeBaskentleri);

    }
}
