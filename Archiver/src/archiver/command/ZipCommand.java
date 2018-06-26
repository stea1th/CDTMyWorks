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

public abstract class ZipCommand implements Command {
    
    private File file;

    public ZipCommand(File file) {
        this.file = file;
    }
    
    

    public ZipFileManager getZipFileManager() throws Exception{
        //ConsoleHelper.writeMessage("Введите полный путь файла архива:");
        Path zipPath = Paths.get(file.getAbsolutePath());
        return new ZipFileManager(zipPath);
    }
}
