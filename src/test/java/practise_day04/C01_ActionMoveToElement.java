package practise_day04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.Set;

public class C01_ActionMoveToElement extends TestBase {
    // https://amazon.com adresine gidiniz
    // sag ust bolumde bulunan dil secenek menusunun acilmasi icin mause'u bu menunun ustune getirelim
    // Change country/region butonuna basiniz
    // United States dropdown'undan 'Turkey (Türkiye)' seciniz
    // Go to website butonuna tiklayiniz
    // acilan yeni sayfadanin Title'inin Elektronik icerdigini test ediniz


    @Test
    public void name() {
        driver.get("https://amazon.com");
        String sayfa1Handle=driver.getWindowHandle();
        Actions action = new Actions(driver);
        WebElement dil =driver.findElement(By.xpath("(//span[@class='nav-line-2'])[1]"));
        action.moveToElement(dil).build().perform();
        bekle(3);

        driver.findElement(By.xpath("//*[text()='Change country/region.']")).click();
        WebElement ddm =driver.findElement(By.xpath("(//*[@id='icp-dropdown'])[1]"));
        Select options= new Select(ddm);
        options.selectByVisibleText("Turkey (Türkiye)");
        bekle(3);
        esc();
        bekle(3);
        //driver.findElement(By.xpath("(//*[@class='a-text-bold'])[1]")).click();//dropdown menu kapanmasi maksadiyla bos olan bir yere tikliyoruz

        driver.findElement(By.xpath("(//*[@class='a-button-input'])[1]")).click();

        Set<String> handle=driver.getWindowHandles();
        System.out.println("handle = " + handle);

        String sayfa2;
        for (String e:handle) {
            if (!e.equals(sayfa1Handle)){
                sayfa2=e;
                driver.switchTo().window(sayfa2);
            }

        }

       Assert.assertTrue(driver.getTitle().contains("Elektronik"));

    }
}
