/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modularisierung;

import java.util.Scanner;

/**
 *
 * @author vvlasov
 */
public class Beispiel8 {

    public static void main(String[] args) {
        int x = getDigit();
        System.out.printf("Quersumme für %d ist: %d\n", x, getAverage(x));
    }
    
    public static int getDigit(){
        return new Scanner(System.in).nextInt();
    }
    
    public static byte getAverage(int x){
        byte sum = 0;
        if(x<0)
            x = -x;
        while(x>0){
            sum+=x%10;
            x=x/10;
            /*if(sum>9){
                x=sum;
                sum=0;
            }*/
        }
        return sum;
    }
    
}
