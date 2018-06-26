/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dual;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;

/* 
Построй дерево(1)
 */
public class Dual {

    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor#Dpljr#&C,₷B'3");
        System.out.println(decode(reader, -3));  //Hello Amigo #@)₴?$0
    }

    public static String decode(StringReader reader, int key) throws IOException {
        if (reader != null) {
            StringWriter stringWriter = new StringWriter();
            try (BufferedReader bufferedReader = new BufferedReader(reader)) {
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    stringWriter.write(line);
                }
            }
            return stringWriter.toString()
                    .chars()
                    .map(i -> i + key)
                    .mapToObj(i -> (char) i)
                    .map(String::valueOf)
                    .reduce((s1, s2) -> s1 + s2).get();
        }
        return "";
    }
}
