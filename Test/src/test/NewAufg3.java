/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 *
 * @author vvlasov
 */
public class NewAufg3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NewAufg3 model = new NewAufg3();
        model.printResult(model.getNewArray());
    }

    public int[] getNewArray() {
        return IntStream.iterate(1, (f) -> f + 1)
                .parallel()
                .limit(30)
                .toArray();
        /*int[]x = new int[30];
        int y = 1;
        for (int i = 0; i < x.length; i++) {
            x[i]+=y++;
            
        }
        return x;*/
    }

    public void printResult(int[] x) {
        for (int i = 0; i < x.length; i++) {
            for (int j = 1; j < i; j++) {
                if (x[j - 1] != 0 && j != 1 && x[i] % x[j - 1] == 0) {
                    x[i] = 0;
                }
            }
            //System.out.print(x[i]>1? x[i]+" " : "");
        }
        
        

        Arrays.stream(x)
                .parallel()
                .filter((a) -> a > 1)
                
                .forEachOrdered((a) -> {
                    System.out.print(a + " ");
                });
        System.out.println("");
    }

}
