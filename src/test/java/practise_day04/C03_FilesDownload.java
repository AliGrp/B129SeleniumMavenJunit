package practise_day04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FilesDownload extends TestBase {
    // 'https://the-internet.herokuapp.com/download' adresine gidiniz

    // some-file.txt dosyasini indirelim
    // dosyanin bilgisayarınızda Downloads(indirilenler)'a basariyla indirilip indirilmedigini test ediniz

    @Test
    public void name() {
//        driver.get("https://the-internet.herokuapp.com/download");
//        driver.findElement(By.xpath("//*[text()='some-file.txt']")).click();
        Assert.assertTrue(Files.exists(Paths.get("C:/UsersASUS/Downloads/some-file.txt")));

    }
}
