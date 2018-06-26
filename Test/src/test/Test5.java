/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vvlasov
 */
public class Test5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        
        try {
            /*BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\vvlasov\\Desktop\\1.txt"));
            while(reader.ready()){
            System.out.println(reader.readLine());
            }*/
            
            //System.out.println(Files.readAllLines(Paths.get("C:\\Users\\vvlasov\\Desktop\\1.txt")));
            Files.lines(Paths.get("C:\\Users\\vvlasov\\Desktop\\1.txt"))
                    .forEach(System.out::println);
        } catch (IOException ex) {
            System.err.println("Hujnia");
        }
    }

}
