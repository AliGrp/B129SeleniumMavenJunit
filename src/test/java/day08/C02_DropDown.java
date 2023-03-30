package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02_DropDown {

//    ● https://the-internet.herokuapp.com/dropdown adresine gidin.
//            1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
//            2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
//            3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
//            4.Tüm dropdown değerleri(value) yazdırın
//            5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True ,degilse False yazdırın.

    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.close();
    }

    @Test
    public void selectByIndex() {
        //1.Locate Dropdown Element
        WebElement year=driver.findElement(By.xpath("//select[@id='year']"));
        //2.Select objesi olusturuyorum
        Select yearDropDown =new Select(year);
        //3.Select objesini kullanarak 3 farkli sekilde secim yapiyoruz
        yearDropDown.selectByIndex(0);

    }

    @Test
    public void selectByValue() {
        WebElement day = driver.findElement(By.xpath("//select[@id='day']"));
        Select dayDD = new Select(day);
        dayDD.selectByValue("6");
    }

    @Test
    public void selectByVisibleText() {
        WebElement month = driver.findElement(By.xpath("//select[@id='month']"));
        Select monthDD = new Select(month);
        monthDD.selectByVisibleText("July");

    }

    @Test
    public void getOptions() {
        WebElement tumWE = driver.findElement(By.xpath("//select[@id='state']"));
        Select tumDD = new Select(tumWE);
        List<WebElement> stateList = tumDD.getOptions();
        for (WebElement each:stateList) {
            System.out.println("=> "+each.getText());
        }
        stateList.forEach(t-> System.out.println(t.getText()));

    }
}
