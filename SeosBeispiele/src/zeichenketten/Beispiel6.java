/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zeichenketten;

import java.util.Scanner;

/**
 *
 * @author vvlasov
 */
public class Beispiel6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.print("Geben sie was ein: ");
        String s = new Scanner(System.in).nextLine();
        System.out.printf("%s ist %sein Float-Wert\n", s, float_ok(s) ? "" : "k");
        /*String x = "\ts";
        System.out.println("\ts".length());
        System.out.println(x.charAt(1));*/

    }

    public static boolean float_ok(String s) {
        int anf = 0;
        int ende = s.length() - 1;
        int lange = s.length();
        int countP = 0;
        int countD = 0;
        int i = 0;
        while (true) {
            if (s.charAt(i) == ' ' || s.charAt(i) == '\u0009') {
                anf++;
                lange--;
                i++;
            } else {
                i = 1;
                break;
            }
        }
        while (true) {
            if (s.charAt(s.length() - i) == ' ' || s.charAt(s.length() - i) == '\u0009') {
                ende--;
                lange--;
                i++;
            } else {
                break;
            }
        }

        if (s.charAt(anf) == '+' || s.charAt(anf) == '-') {
            anf++;
            lange--;
        }

        for (i = anf; i <= ende; i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                countD++;
            } else if (s.charAt(i) == '.') {
                countP++;
            }
        }
        return ((countP <= 1 && (s.charAt(anf) != '.' || s.charAt(ende) != '.')) && (countD + countP == lange));
    }
}
