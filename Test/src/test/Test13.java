/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.Scanner;

/**
 *
 * @author vvlasov
 */
public class Test13 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        Scanner scanner = new Scanner(System.in);

        try {
            builder.append(scanner.next().substring(0, 3))
                    .append("!").append(scanner.nextInt())
                    .append("!").append(String.format("%03d", (int) (Math.random() * 999 + 1)))
                    .append("0");

            System.out.println(builder.toString());
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("String ist zu kurz");
        } catch (Exception e) {
            System.out.println("Mach kein Unsinn!!");
        }
    }

}
