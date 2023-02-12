package org.example;
import java.net.SocketOption;
import java.util.Random;


public class Main {
    public static int k = 2000;
    public static void main(String[] args) {
       // k = 2000;
        int i = new Random().nextInt(k); //это кидалка случайных чисел!)
        System.out.println(i);
        printBinary(i);
        System.out.println();
        System.out.println(Integer.toBinaryString(i));
    }
    private static void printBinary(int val) {
        if (val < 2){
            System.out.print(val);
            return;
        }
        int digit = val % 2;
        printBinary(val / 2);
        System.out.print(digit);
    }
}