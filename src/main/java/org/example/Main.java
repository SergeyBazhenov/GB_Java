/*Первый семинар.
1. Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i
2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1
4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2

Пункты реализовать в методе main
*Пункты реализовать в разных методах

int i = new Random().nextInt(k); //это кидалка случайных чисел!)*/

package org.example;
import java.net.SocketOption;
import java.util.Random;


public class Main {

    static int i = new Random().nextInt(2000); //это кидалка случайных чисел!)
    static int n = MostSignificantBit();
    public static void main(String[] args) {


        System.out.println("Выпавшее число: " + i + "\n");
        System.out.println();
        System.out.println("Старший значащий бит выпавшего числа: " + n + "\n");
        FirstArray();
        System.out.println("\n");
        SecondArray();
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
    public static int MostSignificantBit() {
        int n = 0;
        while ((int) Math.pow(2, n) <= i) {
            n++;
        }
        n -= 1;
        return n;
    }
    public static void FirstArray() {
        int count = 0;
        for (int j = i; j < Short.MAX_VALUE; j++) {
            if (j % n == 0 ) count++;
        }
        System.out.println("Количество элементов массива m1: " + count);
        int[] m1 = new int[count];
        int k = 0;
        for (int j = i; j <= Short.MAX_VALUE; j++) {
            if (j % n == 0) {
                m1[k] = j;
                k++;
            }
        }
        System.out.print("Массив m1: [");
        for (int j = 0; j < m1.length; j++) {
            if (j != m1.length - 1) System.out.print(m1[j] + ", ");
            else System.out.print(m1[j]);
        }
        System.out.print("]");
    }

    public static void SecondArray() {
        int count = 0;
        for (int j = Short.MIN_VALUE; j < i; j++) {
            if (j % n != 0 ) count++;
        }
        System.out.println("Количество элементов массива m2: " + count);
        int[] m2 = new int[count];
        int k = 0;
        for (int j = Short.MIN_VALUE; j < i; j++) {
            if (j % n != 0) {
                m2[k] = j;
                k++;
            }
        }
        System.out.print("Массив m2: [");
        for (int j = 0; j < m2.length; j++) {
            if (j != m2.length - 1) System.out.print(m2[j] + ", ");
            else System.out.print(m2[j]);
        }
        System.out.print("]");
    }
}