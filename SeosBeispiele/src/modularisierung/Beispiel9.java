/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modularisierung;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 *
 * @author vvlasov
 */
public class Beispiel9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int x = getDigit();
        System.out.printf("%d ist %s\n", x, isPrimeDigit(x) ? "eine Primzahl" : "keine Primzahl");
    }

    public static int getDigit() {
        return new Scanner(System.in).nextInt();
    }

    public static boolean isPrimeDigit(int x) {
        /*int count = 0;
        for (int i = 1; i <= x; i++) {
            if(x%i==0)
                count++;
        }
        return count==2? true : false;*/
        return IntStream.range(1, x + 1)
                .parallel()
                .filter(i -> x % i == 0)
                .count() == 2 ? true : false;
    }

    /*private static int[] getArray(int x) {
        int[] arr = new int[x];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        return arr;
    }

    private static boolean checkIt(int[] arr, int x) {
        for (int m = 0; m < arr.length; m++) {
            for (int j = 1; j < m; j++) {
                if (arr[j - 1] != 0 && j != 1 && arr[m] % arr[j - 1] == 0) {
                    arr[m] = 0;
                }
            }
            if (x == arr[m]) {
                return true;
            }
        }
        return false;
    }
    
    private static boolean checkIt2(int x){
        int count = 0;
        for (int i = 1; i <= x; i++) {
            if(x%i==0)
                count++;
        }
        return count==2? true : false;
    }*/
}
