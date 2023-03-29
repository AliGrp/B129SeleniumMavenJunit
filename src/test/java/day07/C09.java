package day07;

import java.util.Scanner;

public class C09 {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
       music();
    }

    public static void music(){
        Study test = new Study();
        System.out.println("secimizi giriniz");
        String secim = scan.nextLine();

        switch (secim) {
            case "1":
            test.test01();
            //            case "1":
//                dertli();
//                break;
//            case "1":
//                dertli();
//                break;
//            case "1":
//                dertli();
//                break;
        }
   }


}

