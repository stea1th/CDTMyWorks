/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javarush1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

/**
 *
 * @author vvlasov
 */
public class Solution2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            InputStream fileInputStream = null;
            
            while (fileInputStream == null) {
                try {
                    fileInputStream = getInputStream(reader.readLine());
                } catch (FileNotFoundException e) {
                    System.out.println("Файл не существует");
                }
            }
            OutputStream fileOutputStream = getOutputStream(reader.readLine());

            while (fileInputStream.available() > 0) {
                int data = fileInputStream.read();
                fileOutputStream.write(data);
            }

            fileInputStream.close();
            fileOutputStream.close();
        }
    }

    public static InputStream getInputStream(String fileName) throws IOException {
        return new FileInputStream(fileName);
    }

    public static OutputStream getOutputStream(String fileName) throws IOException {
        return new FileOutputStream(fileName);
    }

}
