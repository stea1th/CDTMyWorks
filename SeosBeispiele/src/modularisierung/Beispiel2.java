/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modularisierung;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author vvlasov
 */
public class Beispiel2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        int[]arr = IntStream.range(1, 8)
                .map(i-> i*11)
                .toArray();
        System.out.println(Arrays.stream(arr)
                .boxed()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")));
        System.out.println("");
        
        spiegeln(arr);
    }
    
    public static void spiegeln(int[] arr){
        /*System.out.println(IntStream.iterate(arr.length-1, f-> f-1)
                .limit(7)
                .map(i-> arr[i])
                .boxed()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")));*/
        int x = arr.length-1;
        for (int i = 0; i < arr.length/2; i++) {
            /*int temp = arr[i];
            arr[i] = arr[x];
            arr[x] = temp;*/
            arr[i] = arr[i]^arr[x];
            arr[x] = arr[i]^arr[x];
            arr[i] = arr[i]^arr[x];
            x--;
        }
        
        System.out.println(Arrays.stream(arr)
                .boxed()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")));
        
    }
    
}
