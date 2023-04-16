package practise_day04;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_Files {
            // Desktop(masaustu)'da bir text dosyası olusturun
            // Desktop(masaustu)'da text dosyasının olup olmadıgını test edin
        //C:\Users\ASUS\Desktop\Clone Projesi


    @Test
    public void name() {
        String userHome= System.getProperty("user home");
        boolean isexist=Files.exists(Paths.get(userHome +"/Desktop/Clone Projesi"));
        Assert.assertTrue(isexist);
    }
}
