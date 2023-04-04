package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C02_BasicAuthentication extends TestBase {
    @Test
    public void authentication() {

        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        String paragraf=driver.findElement(By.xpath("//p")).getText();
        Assert.assertTrue(paragraf.contains("Congratulations"));


    }

}
