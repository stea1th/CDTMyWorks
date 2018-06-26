/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notenverwaltung;

import java.util.Scanner;

/**
 *
 * @author vvlasov
 */
public class ConsoleHelper {

    public static String read() {
        return new Scanner(System.in).nextLine();
    }

    public static int readInt() {
        return Integer.parseInt(read());
    }

    public static void println(String s) {
        System.out.println(s);
    }

    public static void print(String s) {
        System.out.print(s);
    }

}
