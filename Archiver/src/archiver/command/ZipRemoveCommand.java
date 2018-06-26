/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archiver.command;

import archiver.ConsoleHelper;
import archiver.ZipFileManager;
import java.io.File;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ZipRemoveCommand extends ZipFileManager implements Runnable {
    
    private List<Path> destinationPathList;

    public ZipRemoveCommand(Path zipFile) {
        super(zipFile);
    }
    
    public ZipRemoveCommand(Path zipFile, List<Path> destinationPathList) {
        super(zipFile);
        this.destinationPathList = destinationPathList;
    }


    @Override
    public void run() {
        try{
            super.removeFiles(destinationPathList);
        }catch(Exception e){
            
        }
    }
}
