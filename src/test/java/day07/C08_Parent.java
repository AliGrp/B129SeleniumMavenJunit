package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C08_Parent {
    WebDriver driver;

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Testimiz Baslamistir");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("Test Bitmistir");
    }

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com");

    }
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

}
