/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modularisierung;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 *
 * @author vvlasov
 */
public class Beispiel1 {

    public static void main(String[] args) {

        Beispiel1 bsp = new Beispiel1();
        int[] arr = {47, 11, -3, 10000, 345};
        System.out.println(Arrays.stream(arr)
                .boxed()
                .map(String::valueOf)
                .collect(Collectors.joining(", "))
        );
                
        bsp.getMax(arr);
    }

    public void getMax(int[] arr) {
        
        System.out.printf("Max - %d\n", Arrays.stream(arr)
                .max()
                .getAsInt());
        
        System.out.println(Arrays.stream(arr)
                .boxed()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", "))
        );
        
        System.out.println(Arrays.stream(arr)
                .boxed()
                .map(String::valueOf)
                .collect(Collectors.joining(", "))
        );
    }

}
