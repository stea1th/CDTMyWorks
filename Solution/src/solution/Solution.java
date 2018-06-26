/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solution;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static solution.Solution.ReadFromFile.writeIntoFile;

/**
 *
 * @author vvlasov
 */
public class Solution {
    
    public static String fileNameToWrite;
    public static ArrayList<String> list = new ArrayList();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws Exception, InterruptedException {
        // TODO code application logic here
        //fileNameToWrite = setFileName();
        Thread readOne = new Thread(new ReadFromFile("C:\\Users\\vvlasov\\Desktop\\ReadOne.txt"));
        readOne.start();
        readOne.join();
        Thread readTwo = new Thread(new ReadFromFile("C:\\Users\\vvlasov\\Desktop\\ToReadTwo.txt"));
        readTwo.start();
        readTwo.join();
        
        writeIntoFile(list);
        }
    
    public static String setFileName() throws IOException{
        
        return new Scanner(System.in).nextLine();
    }
    
    public static class ReadFromFile implements Runnable{
        public static String line;

        public ReadFromFile(String line)throws IOException {
            ReadFromFile.line=line;
        }
        BufferedReader reader = null;

        @Override
        public void run()  {
            try {
                reader = new BufferedReader(new FileReader(line));
                System.out.println(line);
                
                    while (reader.ready()){
                        list.add(reader.readLine());
                        
                    }
                    reader.close();
                    for (String string : list) {
                        System.out.println(string);
                    
                }
                } catch (IOException ex) {
            }
        }
        
        public static void writeIntoFile(ArrayList list)throws Exception{
            FileOutputStream output = new FileOutputStream(new File("C:\\Users\\vvlasov\\Desktop\\ToWrite.txt"));
            for (int i = 0; i < list.size(); i++) {
                String lines = (String) list.get(i);
                lines = lines+System.getProperty("line.separator");
                output.write(lines.getBytes());
                
            }
            output.close();
        }
        
        
    }
}