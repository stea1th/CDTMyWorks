/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archiver.command;

import archiver.ConsoleHelper;
import archiver.ZipFileManager;
import archiver.exception.PathIsNotFoundException;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipExtractCommand extends ZipFileManager implements Runnable {
    
    
    private Path destinationPath;

    public ZipExtractCommand(Path zipFile) {
        super(zipFile);
    }
    
    public ZipExtractCommand(Path zipFile, Path destinationPath) {
        super(zipFile);
        this.destinationPath = destinationPath;
    }
    
    @Override
    public void run() {
        try{
            super.extractAll(destinationPath);
        }catch(Exception e){
            
        }
    }
}
