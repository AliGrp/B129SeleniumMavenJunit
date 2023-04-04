package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class C01_WindowHandle extends TestBase {

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
    public void windowHandle() {
        driver.get("https://www.techproeducation.com");
        Assert.assertTrue(driver.getTitle().contains("Techpro Education | Online It Courses & Bootcamps"));
        String techproHandle=driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB).get("https://www.youtube.com");
        String youtubeHandle=driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB).get("https://www.linkedin.com");
        System.out.println(driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains("LinkedIn"));
        String linkHnadle=driver.getWindowHandle();

        List<String> windowHandleList = new ArrayList<>(driver.getWindowHandles());
        System.out.println("windowHandleList = " + windowHandleList);


        driver.switchTo().window(windowHandleList.get(0));
        driver.switchTo().window(windowHandleList.get(1));
        driver.switchTo().window(windowHandleList.get(2));
    }

    @Test
    public void windowHnadle02() {
        driver.get("https://www.techproeducation.com");
        Assert.assertTrue(driver.getTitle().contains("Techpro Education | Online It Courses & Bootcamps"));
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.youtube.com");
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.linkedin.com");

        switchToWindow(0);
        switchToWindow(1);
        switchToWindow(2);
        switchToWindow(0);
    }
}
