/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modularisierung;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 *
 * @author vvlasov
 */
public class Beispiel12 {

    private final static int FIVE = 5;

    public static void main(String[] args) {
        int[][] arr = {{5, 16, 3, 143, 3},
        {32, 5, 7, 3, 1},
        {46, 67, 3, 10, 2},
        {12, 3, 3, 5, 4},
        {3, 43, 98, 3, 5}};

        //int[][] arr2 = getArray();
        System.out.printf("hsum = %d\n", hsum(arr));
        System.out.printf("nsum = %d\n", nsum(arr));
    }

    public static int[][] getArray() {
        Scanner scanner = new Scanner(System.in);

        int[][] arr = new int[FIVE][FIVE];
        /*for (int i = 0; i < FIVE; i++) {
            for (int j = 0; j < FIVE; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }*/

        IntStream.iterate(0, f -> f + 1)
                .limit(arr.length)
                .forEach(i -> {
                    IntStream.iterate(0, f -> f + 1)
                            .limit(arr[i].length)
                            .forEach(j -> {
                                arr[i][j] = scanner.nextInt();
                            });
                });
        return arr;
    }

    public static long hsum(int[][] arr) {
        /*long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i][i];
        }
        return sum;*/
        return IntStream.range(0, FIVE)
                .map(i -> arr[i][i])
                .sum();
    }

    public static long nsum(int[][] arr) {
        /*long sum = 0;
        int x = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i][x];
            x--;
        }
        return sum;*/
        //int x = arr.length-1;
        return IntStream.iterate(0, f -> f + 1)
                .limit(arr.length)
                .map(i -> arr[i][(arr.length - 1) - i])
                .sum();

    }

}
