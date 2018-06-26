/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javarush1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author vvlasov
 */
public class Solution1 {

    public static void main(String[] args) {
        /*String[] arr = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "Oktober", "November", "December"};
        List<String> list = new ArrayList(Arrays.asList(arr));
        String month = new Scanner(System.in).nextLine();
        System.out.printf("%s is %d month\n", month, list.indexOf(month)+1);*/

 /*public static void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if(array[i]>array[i-1]){
                array[i]^=array[i-1];
                array[i-1]^=array[i];
                array[i]^=array[i-1];
                if(i>1) i-=2;
            }
        }*/
        String x = "233  456556 231221 a345 4g43 32 345 1274 233432 777";

        Pattern pattern = Pattern.compile("(\\A\\d{3}\\W)|(\\W\\d{3}\\W)|(\\d{3}\\z)");
        Matcher matcher = pattern.matcher(x);
        while (matcher.find()) {
            System.out.println(matcher.group().trim());
        }

        /*List<String> list = new ArrayList(Arrays.asList(x.split(" ")));
        System.out.println(list.stream().mapToInt(i-> Integer.parseInt(i.trim()))
                .filter(i-> i==new Scanner(System.in).nextInt())
                .findFirst().getAsInt());*/

    }

}
