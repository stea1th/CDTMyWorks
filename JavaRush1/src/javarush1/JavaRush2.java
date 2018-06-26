/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javarush1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 *
 * @author vvlasov
 */
public class JavaRush2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        IntStream.range(0, scanner.nextInt())
                .forEach(i-> list.add(scanner.next()));
        String[] arr = list.stream()
                .limit(scanner.nextInt())
                .toArray(String[]::new);
        list.removeAll(Arrays.asList(arr));
        list.addAll(Arrays.asList(arr));
        list.forEach(System.out::println);
    }
}
