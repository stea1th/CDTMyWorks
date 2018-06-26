/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archiver.command;

import archiver.ConsoleHelper;
import archiver.FileProperties;
import archiver.ZipFileManager;
import java.io.File;
import java.util.List;

public class ZipContentCommand extends ZipCommand {
    
    private List<FileProperties> files;

    public ZipContentCommand(File file) {
        super(file);
    }
    @Override
    public void execute() throws Exception {
        
        ConsoleHelper.writeMessage("Просмотр содержимого архива.");
        ConsoleHelper.readString();

        ZipFileManager zipFileManager = getZipFileManager();

        //ConsoleHelper.writeMessage("Содержимое архива:");

        List<FileProperties> files = zipFileManager.getFilesList();
        /*for (FileProperties file : files) {
            ConsoleHelper.writeMessage(file.toString());
        }*/

        //ConsoleHelper.writeMessage("Содержимое архива прочитано.");
    }

    public List<FileProperties> getFiles() {
        return files;
    }
    
    
}
