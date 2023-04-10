package day14;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist {
      /*
Masaüstünde "logo.jpeg" dosyası oluşturun.
Bu dosyanın varlığını doğrulayın.
 */

    @Test
    public void fileExistTest() {
       String userHome= System.getProperty("user.home");//C:\Users\ASUS
        boolean isExist =Files.exists(Paths.get(userHome+"/Desktop/logo.jpeg"));
        System.out.println("isExist = " + isExist);
        Assert.assertTrue(isExist);

        //C:\Users\ASUS\IdeaProjects\B129SeleniumMavenJunit\src\test\java\day14\C03_FileExist.java
        String userDir=System.getProperty("user.dir");//IDE proje yolunu dinamik olarak verir


        /*
        Fail ise = Dosya masaustunde degildir, dosya adi yanlis, yada onedrive gibi extra  dosyalar olabilir
         */

    }
}
