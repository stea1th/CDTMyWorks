/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vvlasov
 */
public class Test11 {

    
    public static void main(String[] args) {
        try {
            Files.readAllLines(Paths.get("C:\\Users\\vvlasov\\Desktop\\1.txt")).forEach(System.out::println);
        } catch (IOException ex) {
            System.out.println("Sorry, Datei existiert nicht");
        }
    }
}
