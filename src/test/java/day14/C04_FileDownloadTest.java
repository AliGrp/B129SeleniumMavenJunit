package day14;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C04_FileDownloadTest extends TestBase {
    /*
 "https://testcenter.techproeducation.com/index.php?page=file-download"   adresine gidin
 "b10 all test cases" dosyasını indirin
  Dosyanın başarıyla indirilip indirilmediğini test edin.
 */

    @Test
    public void name() {
//        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");
//        driver.findElement(By.xpath("//*[text()='b10 all test cases, code.docx']")).click();
//        bekle(3);
        String userHome=System.getProperty("user.home");
        boolean exist=Files.exists(Paths.get(userHome+"/Downloads/b10 all test cases, code (1).docx"));
        Assert.assertTrue(exist);


    }
}
