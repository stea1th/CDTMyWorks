/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author vvlasov
 */
public class NewAufg2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*int [] x = IntStream.iterate(2, (i)-> i+2)
                .limit(5)
                .toArray();
        Arrays.stream(x).forEach((i)-> System.out.print(i+" "));
        System.out.println("Summe: " + Arrays.stream(x)
                                        .sum());
        System.out.println("");*/

        int[] x = {17, 4, 32, 1, 12, 3, 1, 101, 1};
        /*System.out.println(Arrays.stream(x)
                .sorted()
                .boxed()
                .map(String::valueOf)
                //.reduce((s1, s2) -> s1 + " " + s2).get());
                .collect(Collectors.joining(", ")));
        System.out.println("MAX: "+Arrays.stream(x)
                .max().getAsInt());
        System.out.println("MIN: "+Arrays.stream(x)
                .min().getAsInt());*/
        for (int i = 1; i < x.length; i++) {
            if (x[i] < x[i - 1]) {
                /*int temp = x[i];
                x[i] = x[i-1];
                x[i-1] = temp;*/

                x[i] ^= x[i - 1];
                x[i - 1] ^= x[i];
                x[i] ^= x[i - 1];
                if (i > 1) {
                    i -= 2;
                }
            }
        }
        for (Integer i : x) {
            System.out.print(i + " ");
        }
        System.out.println("");
        System.out.println("MIN: " + x[0]);
        System.out.println("MAX: " + x[x.length - 1]);

    }

}
