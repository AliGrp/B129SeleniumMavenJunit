package day07;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C02_BeforeAfter {
    @Before
    public void setUp(){
        System.out.println("Her Test Method Oncesi Bir Kez Calisir");//2 kez calisir cunku 2 test var
    }
    @After
    public void tearDown(){
        System.out.println("Her Test Method Sonrasi Bir Kez Calisir");//2 kez calisir cunku 2 test var
    }

    @Test
    public void test01(){
        System.out.println("Ilk Test");

    }
    @Test
    public void test02(){
        System.out.println("Ikinci Test");

    }
}
