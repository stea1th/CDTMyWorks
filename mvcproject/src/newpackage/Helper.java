/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Helper {
    
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    
    public static String read() throws IOException{
        return reader.readLine();
    }
    
    public static long readLong() throws IOException{
        return Long.parseLong(read());
    }
    
    public static double readDouble() throws IOException{
        return Double.parseDouble(read());
    }
    
    public static int readInt()  {
        try {
            return Integer.parseInt(read());
        } catch (Exception ex) {
            Helper.print("Falsches format");
        }
        return 0;
    }
    
    public static void print(String message){
        System.out.println(message);
    }
}
