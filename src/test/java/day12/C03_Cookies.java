package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.List;
import java.util.Set;

public class C03_Cookies extends TestBase {
    /*
1-Amazon anasayfaya gidin
2-tum cookie'leri listeleyin
3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
5-ismi "en sevdigim cookie" ve degeri "cikolatali" olan bir cookie  olusturun ve sayfaya ekleyin
6-eklediginiz cookie'nin sayfaya eklendigini test edin
7-ismi skin olan cookie'yi silin ve silindigini test edin
8-tum cookie'leri silin ve silindigini test edin
 */

    @Test
    public void cookiesTest() {
        driver.get("https://www.amazon.com");
       // 2-tum cookie'leri listeleyin
        Set<Cookie> cokies=driver.manage().getCookies();
        System.out.println("cokies = " + cokies);
        cokies.forEach(t-> System.out.println(t));

        //3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        int cokiesSayisi=cokies.size();
        Assert.assertTrue(cokies.size()>5);

        //4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        String cookieValue =driver.manage().getCookieNamed("i18n-prefs").getValue();
        Assert.assertEquals("USD",cookieValue);

        //5-ismi "en sevdigim cookie" ve degeri "cikolatali" olan bir cookie  olusturun ve sayfaya ekleyin
        Cookie yeniCookie=new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(yeniCookie);

        //6-eklediginiz cookie'nin sayfaya eklendigini test edin
        System.out.println("eklendikten sonra"+driver.manage().getCookies().size());
        String yeneCookies=driver.manage().getCookieNamed("en sevdigim cookie").getValue();
        Assert.assertEquals("cikolatali",yeneCookies);

        //7-ismi skin olan cookie'yi silin ve silindigini test edin
        int cookiesSilinmedenOnce= driver.manage().getCookies().size();
        driver.manage().deleteCookieNamed("skin");
        int cookiesSilindiktenSonra= driver.manage().getCookies().size();
        Assert.assertEquals(1,cookiesSilinmedenOnce-cookiesSilindiktenSonra);

        //8-tum cookie'leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        Assert.assertEquals(0,driver.manage().getCookies().size());

    }


    }

