/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author vvlasov
 */
public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        IntStream.range(0, 5)
                .forEach(i-> {
            try {
                list.add(i, Integer.parseInt(reader.readLine()));
            } catch (IOException ex) {
                Logger.getLogger(Solution.class.getName()).log(Level.SEVERE, null, ex);
            }
                    
        });
        
        list.stream()
                .sorted()
                .forEach(System.out::println);
                
                
               
        
                
        
                
        

        //напишите тут ваш код
    }
}
