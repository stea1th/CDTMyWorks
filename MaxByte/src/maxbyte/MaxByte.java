/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maxbyte;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author vvlasov
 */
public class MaxByte {

    private static ArrayList<String> fileNames = new ArrayList();
    private static Map<String, Character> resultItem = new HashMap<String, Character>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws InterruptedException {
        // TODO code application logic here
        setFileNames(fileNames);
        for(String fileName : fileNames){
            System.out.println(fileName);
            Thread thread = new ReadThread(fileName);
            thread.start();
            thread.join();
            
            System.out.println("----------------------------------");
        }
        for(Map.Entry<String, Character> entry : resultItem.entrySet()){
            System.out.println("Found Item "+entry.getKey()+" equal "+entry.getValue());
        }
    }
    
    private static ArrayList<String>setFileNames(ArrayList<String> list){
        System.out.println("Please set file name: ");
        Scanner scanner = new Scanner(System.in);
        while(true){
            String name = scanner.nextLine();
            String file = "C:\\Users\\vvlasov\\Desktop\\"+name+".txt";
            if(name.equals("exit")){
                break;
            }else{
                list.add(file);
            }
        }
        return list;
       }
    public static class ReadThread extends Thread{
        private static String fileName;
        private static Map<Character, Integer> map = new HashMap<Character, Integer>();

        public ReadThread(String fileName) {
           this.fileName=fileName;
        }

        @Override
        public void run() {
            System.out.println("This Thread name is:  "+Thread.currentThread().getName());
            ArrayList<Character> list = new ArrayList<>();
            try{
             FileInputStream input = new FileInputStream(fileName);
             while(input.available()>0){
                 int x = input.read();
                 if(0<x&&x<128){
                    char data = (char)x;
                    list.add(data);
                    map.put(data, 0);
                 }
             }
             input.close();
            }catch (Exception e){
                System.out.println(e.getClass().getName());
                System.out.println("Fuck off ");
            }
            try{
            findMaxByte(list);
            }catch (Exception e){
                System.out.println(e.getClass().getName());
                System.out.println("OMFG!!!");
            }
            map.clear();
            
        }
        
        public static void findMaxByte(ArrayList<Character> list){
            
            for (Character data : list){
                for (Map.Entry<Character, Integer> entry : map.entrySet()){
                    if (entry.getKey().equals(data)){
                        entry.setValue(entry.getValue()+1);
                    }
                }
            }
            for(Map.Entry entry : map.entrySet()){
                System.out.println(entry.getKey()+" "+entry.getValue());
            }
           
            sortAndResult(map);
        }
        
        public static void sortAndResult(Map<Character, Integer> map){
            
            ArrayList<Integer> forSort = new ArrayList();
            for(Map.Entry entry : map.entrySet()){
                forSort.add((Integer) entry.getValue());
            }
            Collections.sort(forSort,Collections.reverseOrder());
            int x = forSort.get(0);
            Iterator iterator = map.entrySet().iterator();
            while(iterator.hasNext()){
                Map.Entry pair = (Map.Entry)iterator.next();
                if(pair.getValue().equals(x)){
                    System.out.println("This Item "+pair.getKey().toString().toUpperCase()+" repeats "+pair.getValue()+" times");
                    resultItem.put(fileName,(char)pair.getKey() );
                }
            }
        }
   }
    
}
