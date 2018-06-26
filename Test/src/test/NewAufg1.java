/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.Arrays;
import java.util.Locale;
import java.util.OptionalDouble;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author vvlasov
 */
public class NewAufg1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /*int x[];
        Scanner scanner = new Scanner(System.in);
        x = IntStream.range(0, 4)
                .map((i)->{
                    i=scanner.nextInt();
                        return i;
                }).toArray();
        
        
        Arrays.stream(x)
                .forEach(System.out::println);*/
 /*Scanner scanner = new Scanner(System.in);
        String[] x;
        
         x = IntStream.range(0, 4)
                .boxed()
                .map(String::valueOf)
                .map((s)-> s = scanner.nextLine())
                .toArray(String[]::new);
                
        Arrays.stream(x)
                .skip(2)
                .limit(1)
                .forEach(System.out::println);*/
 /*System.out.printf("Ergebnis: %.2f\n", IntStream.range(0, 4)
                .map((i) -> {
                    i = new Scanner(System.in).nextInt();
                    return i;
                })
                .sorted().forEach(action));*/
        System.out.println(IntStream.range(0, 4)
                .map((i) -> {
                    i = new Scanner(System.in).nextInt();
                    return i;
                })
                .sorted()
                .boxed()
                .map(String::valueOf)
                .distinct()
                .reduce((s1, s2) -> s1 + " " + s2).get());
    }
}
