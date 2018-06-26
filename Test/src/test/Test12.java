/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author vvlasov
 */
public class Test12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Pattern pattern = Pattern.compile("[G-X]{1}");
            Matcher matcher = pattern.matcher(new Scanner(System.in).next());
            if (matcher.find()) {
                System.out.println(matcher.group());
            } else {
                throw new IOException("Falsch!!!");
            }
        } catch (IOException e) {
            System.out.println("Abgefangen");
        }
    }

}
