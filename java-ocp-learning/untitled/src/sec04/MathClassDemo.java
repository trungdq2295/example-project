package sec04;

import java.util.Scanner;

public class MathClassDemo {

    public static void main(String[] args) {
        System.out.println(Math.PI);            //3.14
        System.out.println(Math.max(3, 5));     //5
        System.out.println(Math.min(3, 5));     //3
        System.out.println(Math.abs(-5));       //5
        System.out.println(Math.sqrt(4));       //2
        System.out.println(Math.sqrt(-1));      //NaN = not a number
        System.out.println(0 / 0.0);            //NaN
        System.out.println((0 / 0.0) + 5);      //NaN

        System.out.println(5 / 0.0);            // Infinity
        System.out.println(-5 / 0.0);            // Infinity
    }
}
