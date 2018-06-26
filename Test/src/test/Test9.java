/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Formatter;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import javax.swing.text.DefaultEditorKit;

/**
 *
 * @author vvlasov
 */
public class Test9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        String s = "C:\\Users\\vvlasov\\Desktop\\1.txt";
        Formatter format = new Formatter(s);
        format.format("Hi %s", "Vadim");
        format.out().append("\r\ndu bist schön!");
        //System.out.println();
        //Files.createFile(Paths.get(s));
        format.flush();
        format.close();
        
        //TimeUnit.SECONDS.sleep(5);
        
        //Files.delete(Paths.get(s));
        /*Files.createDirectory(Paths.get("C:\\Users\\vvlasov\\Desktop\\Test"));
        Files.createFile(Paths.get("C:\\Users\\vvlasov\\Desktop\\Test\\3.txt"));
        TimeUnit.SECONDS.sleep(5);
        Files.deleteIfExists(Paths.get("C:\\Users\\vvlasov\\Desktop\\Test"));*/
       /* File dir = new File("C:\\Users\\vvlasov\\Desktop\\Test");
        File file = new File("C:\\Users\\vvlasov\\Desktop\\Test\\3.txt");
        dir.mkdir();
        file.createNewFile();
        TimeUnit.SECONDS.sleep(5);
        dir.delete();*/
       //goInside(Paths.get("C:\\Users\\vvlasov\\Desktop\\slf4j-1.7.25"));
       
       Files.copy(Paths.get("C:\\Users\\vvlasov\\Desktop\\1.txt"), Paths.get("C:\\Users\\vvlasov\\Desktop\\2.txt"), StandardCopyOption.REPLACE_EXISTING);
       
       //Files.move(Paths.get("C:\\Users\\vvlasov\\Desktop\\1.txt"), Paths.get("C:\\Users\\vvlasov\\Desktop\\2.txt"),StandardCopyOption.REPLACE_EXISTING);
       
        }
    
    public static void goInside(Path file) throws IOException{
        for(File f : file.toFile().listFiles()){
            if(f.isDirectory()){
                System.out.println("Dir - "+ f.getName());
                goInside(f.toPath());
            }else if(f.isFile()){
                System.out.println(f.getCanonicalPath());
            }
        }
    }
    
}
