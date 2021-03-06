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
import java.util.ArrayList;
import java.util.List;

public class ZipAddCommand extends ZipFileManager implements Runnable {

    private List<File>fileList;
    
    public ZipAddCommand(Path zipFile) {
        super(zipFile);
    }
    
    public ZipAddCommand(Path zipFile, List<File>fileList) {
        super(zipFile);
        this.fileList= fileList;
        
    }
    
    public List<Path> getPathList() throws Exception {
        
        List<Path>pathList = new ArrayList<>();
        
            if(!fileList.isEmpty()){
                for(File file : fileList){
                    pathList.add(Paths.get(file.getPath()));
                }
            }
        return pathList;
            
    }
    
    @Override
    public void run() {
        try{
            super.addFiles(getPathList());
        }catch(Exception e){
            
        }
    }
}

