/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.Arrays;
import java.util.Collections;
import java.util.function.Function;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static jdk.nashorn.tools.ShellFunctions.input;

/**
 *
 * @author vvlasov
 */
public class Test14 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String text = "Hi mY BabY!!!";
        /*int klein = 0;
        int gross = 0;
        char[] arr = text.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (Character.isUpperCase(arr[i])) {
                gross++;
            } else if (Character.isLowerCase(arr[i])) {
                klein++;
            }
        }
        System.out.printf("Gross - %d\nKlein - %d\n", gross, klein);*/
        
        System.out.printf("Gross - %d\nKlein - %d\n", text.chars().filter(Character::isUpperCase)
                .count(), text.chars().filter(Character::isLowerCase)
                .count());
        
       
    }
    
   
}
