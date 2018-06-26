/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modularisierung;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 *
 * @author vvlasov
 */
public class Beispiel6 {

    
    public static void main(String[] args) {
       
      while(true){
          int x = getDigit();
          if(x<0){
              return;
          }
          System.out.printf("Fakultät von %d ist: %d\n", x, getResult(x));
      }
    }
    
    public static int getDigit(){
        return new Scanner(System.in).nextInt();
    }
    
    public static long getResult(int a){
        /*long x = 1;
        for (int i = 2; i <= a ; i++) {
            x*=i;
        }
        return x;*/
        return a>1 ? a*getResult(a-1) : 1;
    }
    
    
    
    
    
    
}
