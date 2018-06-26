/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archiver;

import archiver.exception.WrongZipFileException;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 *
 * @author vvlasov
 */
public class ContentTest implements Callable<List<FileProperties>> {
    
    private Path file;

    public ContentTest(Path file) {
        this.file = file;
    }
    
    
    
    public List<FileProperties> getFilesList() throws Exception {
        // Проверяем существует ли zip файл
        Path zipFile = file;//Paths.get(file.getAbsolutePath());
        if (!Files.isRegularFile(zipFile)) {
            throw new WrongZipFileException();
        }

        List<FileProperties> files = new ArrayList<>();

        try (ZipInputStream zipInputStream = new ZipInputStream(Files.newInputStream(zipFile))) {
            ZipEntry zipEntry = zipInputStream.getNextEntry();

            while (zipEntry != null) {
                // Поля "размер" и "сжатый размер" не известны, пока элемент не будет прочитан
                // Давайте вычитаем его в какой-то выходной поток
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                copyData(zipInputStream, baos);

                FileProperties file = new FileProperties(zipEntry.getName(), zipEntry.getSize(), zipEntry.getCompressedSize(), zipEntry.getMethod());
                files.add(file);
                zipEntry = zipInputStream.getNextEntry();
            }
        }

        return files;
    }
    
    private void copyData(InputStream in, OutputStream out) throws Exception {
        byte[] buffer = new byte[8 * 1024];
        int len;
        while ((len = in.read(buffer)) > 0) {
            out.write(buffer, 0, len);
        }
    }

    /*@Override
    public void run() {
        try{
        List<FileProperties>files = getFilesList();
        for(FileProperties file : files){
            System.out.println(file.toString());
        }
        }catch(Exception e){
            System.out.println(e);
        }
    }*/

    @Override
    public List<FileProperties> call() throws Exception {
        return getFilesList();
    }

    
    
    
    
}
