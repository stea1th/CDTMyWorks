/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.applet.Applet;
import java.awt.Graphics;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author vvlasov
 */
public class TestApplet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*int[][] i =  {{1, 111, 11111, 1111111},
           {22, 2222222, 22222222},
           {333, 333333333, 33333333, 3333, 3333333}
       };
       
       
       IntStream.range(0, i.length).forEach((y)->{
           IntStream.range(0, i[y].length).forEach((x)->{
               System.out.println(i[y][x]);
               });
       });*/
        int[][] r = {{25, 30, 12, 31, 22, 24, 19, 25, 16, 23, 33, 40}, {42, 12, 25, 84, 23, 22, 12, 65, 125, 23, 44, 95}, {70, 33, 51, 25, 26, 44, 85, 24, 123, 25, 66, 201}};
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println(r[scanner.nextInt() - 1][scanner.nextInt() - 1]);
        } catch (Exception e) {
            System.err.println("Falsche Eingabe");
        }

    }

}
