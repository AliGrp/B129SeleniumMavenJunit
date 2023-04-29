package practise_day05;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C03_Read_Excel {
    // Ulkeler dosyasındaki 3.satırdaki indexin, 3.sutunundaki indexinin
    // "Cezayir" oldugunu test eden method olusturunuz


    @Test
    public void name() throws IOException {
        String actual=method(3,3);
        Assert.assertEquals("Cezayir",actual);


    }

    public String method(int a, int b) throws IOException {
        FileInputStream fis=new FileInputStream("C:\\Users\\ASUS\\Downloads\\ulkeler.xlsx");
        Workbook wb = WorkbookFactory.create(fis);
        String istenenData=wb.getSheet("Sayfa1").getRow(a).getCell(b).toString();

        return istenenData;
    }
}
