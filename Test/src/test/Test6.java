/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author vvlasov
 */
public class Test6 {

    public static void main(String[] args) throws IOException, InterruptedException, InstantiationException, IllegalAccessException {
        /*try(FileWriter writer = new FileWriter("C:\\Users\\vvlasov\\Desktop\\2.txt", true)){
            writer.write("Hi fi16"+System.getProperty("line.separator")+
                    "willst du mit mir gehen?");
        }*/
        /*char[] buff = new char[20];
        try(FileReader reader = new FileReader("C:\\Users\\vvlasov\\Desktop\\2.txt")){
            while(reader.read(buff)>0){
                System.out.print(buff);
                TimeUnit.MILLISECONDS.sleep(1000);
            }
        }*/

         /*try(BufferedReader reader = new BufferedReader(new InputStreamReader(Files.newInputStream(Paths.get("C:\\Users\\vvlasov\\Desktop\\2.txt"))))){
            while(reader.ready()){
                System.out.println(reader.readLine());
            }
        }*/
        /*try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("C:\\Users\\vvlasov\\Desktop\\2.txt"), StandardCharsets.UTF_8, StandardOpenOption.APPEND);
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8))) {
            
            writer.write(reader.readLine());
            writer.newLine();
            
            
        }
        System.out.println(System.getProperty("user.language"));*/
        //Files.readAllLines(Paths.get("C:\\Users\\vvlasov\\Desktop\\DieMade.txt")).forEach(System.out::println);
        char[] buff = new char[1024];
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream("C:\\Users\\vvlasov\\Desktop\\DieMade.txt"))) {
            while (reader.read(buff) > 0) {
                System.out.println(buff);
            }
        }
    }
}
