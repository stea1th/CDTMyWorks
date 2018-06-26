/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author vvlasov
 */
public class Aufg4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int employee = 1;
        int tag = 20;
        int sum = 0;

        for (int i = 0; i < tag; i++) {
            for (int j = 0; j < i; j++) {
                employee *= 2;

            }
            System.out.println((double) employee / 100*2);
            sum+=employee;
            employee = 1;

        }
        System.out.println((double)sum /100);
    }

}
