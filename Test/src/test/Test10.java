/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author vvlasov
 */
public class Test10 {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Serial s = new Serial(10, "John", 12.3);
        byte[] buff;
        try (ByteArrayOutputStream output = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(output)) {
            oos.writeObject(s);
            buff = output.toByteArray();
        }
        Serial x;
        try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(buff))) {
            x = (Serial) ois.readObject();
        }
        System.out.printf("x: %d - %s\n", x.getAge(), x.getName());
        x.setAge(45);
        x.setName("Peter");
        System.out.printf("s: %d - %s\n", s.getAge(), s.getName());
        System.out.printf("x: %d - %s\n", x.getAge(), x.getName());
    }
}
