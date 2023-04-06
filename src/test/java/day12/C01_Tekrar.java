package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class C01_Tekrar extends TestBase {
    /*
https://www.techproeducation.com adresine gidiniz
Başlığın "Techpro Education | Online It Courses & Bootcamps" olduğunu doğrulayın
Tab 2'de https://www.youtube.com sayfasını açınız
Tab 3'te https://www.linkedin.com sayfasını açınız
techproeducation sayfasına geçiniz
youtube sayfasına geçiniz
linkedIn sayfasına geçiniz
 */

    @Test
    public void test01() {
        driver.get("https://www.techproeducation.com");
        Assert.assertEquals("Techpro Education | Online It Courses & Bootcamps",driver.getTitle());

        driver.switchTo().newWindow(WindowType.TAB).get("https://www.youtube.com");
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.linkedin.com");

        List<String> handles= new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(handles.get(0));
        driver.switchTo().window(handles.get(2));
        driver.switchTo().window(handles.get(1));


    }
}
