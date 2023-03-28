package day07;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class C04_BeforeClassAfterClass {
    /*
    @BeforeClass ve @AfterClass notasyonlari sadece static methodlar ile calisir
     */
    @BeforeClass
    public static void setUp(){
        System.out.println("Tum Testler Once Calisir");
        System.out.println("===============");
    }
    @AfterClass
    public static void teardown(){
        System.out.println("Tum Testler sonra bir kez Calisir");
        System.out.println("===============");
    }
    @Before
    public void setUp01() {
        System.out.println("Her testten önce çalışır");
        System.out.println("===============");
    }


    @Test
    public void test01(){
        System.out.println("Ilk Test");
        System.out.println("===============");
    }
    @Test
    public void test02(){
        System.out.println("Ikinci Test");
        System.out.println("===============");
    }
    @Test
    public void test03(){
        System.out.println("Ucuncu Test");
        System.out.println("===============");
    }

}
