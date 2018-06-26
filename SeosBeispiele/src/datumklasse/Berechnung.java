/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datumklasse;

/**
 *
 * @author vvlasov
 */
public class Berechnung {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String line = "2718281828458567";
        System.out.println("Prüfsumme: " + exam(line));
    }

    public static boolean exam(String line) {
        int sum = 0;
        for (int i = 0; i < line.length() - 1; i++) {
            int x = (line.charAt(i) - '0');
            if (i % 2 == 0) {
                sum += x * 2 > 9 ? x * 2 % 10 + 1 : x * 2;
            } else {
                sum += x;
            }
        }
        return ((sum % 10 == 0 ? 0 : 10 - sum%10))
                == line.charAt(line.length() - 1) - '0';
    }

}
