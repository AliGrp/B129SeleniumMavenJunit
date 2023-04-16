package day18;

import org.junit.Test;
import utilities.TestBase;

public class C01_ScreenShot extends TestBase {

    @Test
    public void ssTest1() {

        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");


//Sayfanın resmini alalım
        tumSayfaResmi();
//Sonra amazon sayfasına gidelim
        driver.get("https://www.amazon.com");
//Amazon sayfasının ekran görüntüsünü alalım
        tumSayfaResmi();
    }
}
