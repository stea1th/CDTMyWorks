/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javarush1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 *
 * @author vvlasov
 */
public class JavaRush1 {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        IntStream.range(0, 10)
                .forEach(i-> list.add(scanner.nextLine()));
        String min = list.stream()
                .min((String o1, String o2) -> o1.length()-o2.length())
                .get();
        String max = list.stream()
                .max((String o1, String o2) -> o1.length()-o2.length())
                .get();
        System.out.println(list.indexOf(min)< list.indexOf(max)? min : max);
                
            
                
    }
    
}
