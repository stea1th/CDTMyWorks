/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archiver;

import archiver.command.ZipAddCommand;
import archiver.command.ZipContentCommand;
import archiver.command.ZipCreateCommand;
import archiver.command.ZipExtractCommand;
import archiver.command.ZipRemoveCommand;
import archiver.exception.WrongZipFileException;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author vvlasov
 */
public class ArchiverFaceController implements Initializable {

    @FXML
    private FlowPane root;
    @FXML
    private TextArea myTextArea;
    @FXML
    private TextField textField;
    @FXML
    private Button addZipFile;
    @FXML
    private Button myCreateButton;
    @FXML
    private Button myAddButton;
    @FXML
    private Button myRemoveButton;
    @FXML
    private Button myExtractButton;
    
    private Stage primaryStage;
    
    private File file;
    
    public ArchiverFaceController() {
       //addZipFile.setStyle("");
    }
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        myTextArea.setFocusTraversable(false);
        textField.setFocusTraversable(false);
    }    

    @FXML
    private void createNewZipFile(ActionEvent event) {
        
        FileChooser fileChooser  = new FileChooser();
        myTextArea.clear();
        textField.clear();
        List<File> list = fileChooser.showOpenMultipleDialog(primaryStage);
        if(list==null || list.isEmpty()){
            return;
        }
        for (File file : list){
            myTextArea.appendText("File "+file.getName().toString()+" "+"\n");
        }
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Create new ZipFile");
        alert.setHeaderText("ZipDatei nötig");
        alert.setContentText("Bitte finde eine bestehende ZipDatei oder erstelle sie");
        alert.showAndWait();
        
        fileChooserConfiguration(fileChooser);
        File file = fileChooser.showSaveDialog(primaryStage);
        if(file!=null){
            stringSeparator();
            myTextArea.appendText("Es wurde in "+file.getName()+ " gespeichert\n");
            textField.appendText(file.getPath());
            Thread thread = new Thread(new ZipCreateCommand(Paths.get(file.getPath()), list));
            thread.setDaemon(true);
            thread.start();
        }else if(file==null||!file.exists()){
                //textField.clear();
                commandCanceled();
                //System.out.println("bla");
            }
        
    }
    
    @FXML
    private void addNewFilesInZip(ActionEvent event)throws Exception {
        FileChooser fileChooser  = new FileChooser();
        List<File> list = new ArrayList();
        //myTextArea.clear();
        //textField.clear();
        stringSeparator();
        
        if(!textField.getText().isEmpty()){
            //stringSeparator();
            //getFileProperties();
            list = fileChooser.showOpenMultipleDialog(primaryStage);
                if(list==null || list.isEmpty()){
                    commandCanceled();
                    return;
                }
            Path zipFile = Paths.get(textField.getText());
        }else {
            fileChooserConfiguration(fileChooser);
            file = fileChooser.showOpenDialog(primaryStage);
            if(file!=null){
                Path zipFile = Paths.get(file.getPath());
                textField.setText(zipFile.toString());
                getFileProperties();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Add new Files in ZipFile");
                alert.setHeaderText("Neue Dateien sind nötig");
                alert.setContentText("Bitte finde die nötige Dateien");
                alert.showAndWait();
                
                fileChooser  = new FileChooser();
                
                list = fileChooser.showOpenMultipleDialog(primaryStage);
                if(list==null || list.isEmpty()){
                    //commandCanceled();
                    return;
                }
                
            }else if(file==null||!file.exists()){
                //textField.clear();
                commandCanceled();
                return;
                //System.out.println("bla");
            }
        }
        for (File file : list){
            myTextArea.appendText("File "+file.getName()+" "+"\n");
        }
        
        Thread thread = new Thread(new ZipAddCommand(Paths.get(file.getPath()), list));
        thread.setDaemon(true);
        thread.start();
        stringSeparator();
        myTextArea.appendText("Dateien waren erfolgreich in "+file.getName()+" addiert\n");
        
    }
    
    @FXML
    private void removeFilesFromZip(ActionEvent event)throws Exception {
        List<String> choices = new ArrayList<>();
        FileChooser fileChooser = new FileChooser();
        fileChooserConfiguration(fileChooser);
        List<Path> result = new ArrayList<>();
        
        
        
        if(!textField.getText().isEmpty()){
            //stringSeparator();
            //getFileProperties();
            choices = getListWithFileProperties();
        }else {
            fileChooserConfiguration(fileChooser);
            file = fileChooser.showOpenDialog(primaryStage);
            if(file!=null){
                textField.setText(file.getPath());
                getFileProperties();
                choices = getListWithFileProperties();
            }else if(file==null||!file.exists()){
                //textField.clear();
                commandCanceled();
                return;
                //System.out.println("bla");
            }
        }
        
        ChoiceDialog<String> dialog;
        
        boolean isTrue = true;
        while(isTrue){
            dialog = new ChoiceDialog<>("", choices);
            Optional<String> option = dialog.showAndWait();
            
            if(option.isPresent()){
                myTextArea.appendText("Es wurde entfernt: "+option.get()+"\n");
                choices.remove(option.get());
                result.add(Paths.get(option.get()));
            }
            else
                isTrue = false;
            }
        Thread thread = new Thread(new ZipRemoveCommand(Paths.get(file.getPath()), result));
        thread.setDaemon(true);
        thread.start();
        
        addZipFile.fire();
        
        //stringSeparator();
        //getFileProperties();
        
    }
    
    @FXML
    private void extractFilesFromZip(ActionEvent event)throws Exception {
        FileChooser fileChooser  = new FileChooser();
        /*myTextArea.clear();
        textField.clear();
        fileChooserConfiguration(fileChooser);
        file = fileChooser.showOpenDialog(primaryStage);
        textField.setText(file.getPath());*/
        if(!textField.getText().isEmpty()){
            stringSeparator();
            getFileProperties();
        }else {
            fileChooserConfiguration(fileChooser);
            file = fileChooser.showOpenDialog(primaryStage);
            if(file!=null){
                textField.setText(file.getPath());
                getFileProperties();
            }else if(file==null||!file.exists()){
                //textField.clear();
                commandCanceled();
                return;
                //System.out.println("bla");
            }
        }
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Extract from ZipFile");
        alert.setHeaderText("Ein Ordner ist nötig");
        alert.setContentText("Bitte finde Ordner zum abspeichern");
        alert.showAndWait();
        
        String x = file.getPath().substring(0, file.getPath().indexOf("."));
        System.out.println(x);
        
        File zipDirectory = Paths.get(x).toFile();
        if(!zipDirectory.exists()){
            zipDirectory.mkdir();
        }
        //System.out.println(zipDirectory.toString());
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setInitialDirectory(zipDirectory);
        
        
       
        //directoryChooser.setInitialDirectory(file);
        
        File directory = directoryChooser.showDialog(primaryStage);
        
        if(directory==null){
            zipDirectory.delete();
            commandCanceled();
            return;
        }
        stringSeparator();
        myTextArea.appendText("Es wurde in "+directory.getName()+ " gespeichert\n");
        Thread thread = new Thread(new ZipExtractCommand(Paths.get(file.getPath()), Paths.get(directory.getPath())));
        thread.setDaemon(true);
        thread.start();
    }
    
    @FXML
    private void addNewZipFile(ActionEvent event) throws Exception {
        //textField.setAlignment(Pos.BASELINE_RIGHT);
        
        
        FileChooser fileChooser  = new FileChooser();
        if(!textField.getText().isEmpty()){
            stringSeparator();
            getFileProperties();
            
        }else {
            fileChooserConfiguration(fileChooser);
            file = fileChooser.showOpenDialog(primaryStage);
            if(file!=null){
                textField.setText(file.getPath());
                getFileProperties();
            }else if(file==null||!file.exists()){
                //textField.clear();
                commandCanceled();
                //System.out.println("bla");
            }
        }
            
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
    
    public FileChooser.ExtensionFilter zipFilter(){
         return new FileChooser.ExtensionFilter("Zip Files (*.zip)", "*.zip");
    }
    
    public void fileChooserConfiguration(FileChooser fileChooser){
        fileChooser.getExtensionFilters().add(zipFilter());
    }
    
    public void commandCanceled() {
        
        Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    textField.clear();
                    textField.appendText("Abbrechen");
                    stringSeparator();
                    myTextArea.appendText("Prozess wurde abgebrochen");
                    for (int i = 0; i < 5; i++) {
                        try{
                        TimeUnit.SECONDS.sleep(1);
                        myTextArea.appendText(".");
                        }catch(InterruptedException e){
                            
                        }
                
            }
            myTextArea.clear();
            textField.clear();
                }
            });
            thread.setDaemon(true);
            thread.start();
    }
    
    public void getFileProperties() throws Exception {
        Callable<List<FileProperties>> callable = new ContentTest(Paths.get(textField.getText()));
            List<FileProperties> files = callable.call();
            
            for(FileProperties file : files){
                myTextArea.appendText(file.toString()+"\n");
            }
            stringSeparator();
            myTextArea.appendText("Prozess wurde erfolgreich ausgeführt!\n");
    }
    
    public void stringSeparator(){
        myTextArea.appendText("-------------------------------------------------------------------------\n");
    }
    
    public List<String> getListWithFileProperties()throws Exception{
        List<String>result = new ArrayList<>();
        Callable<List<FileProperties>> callable = new ContentTest(Paths.get(textField.getText()));
            List<FileProperties> files = callable.call();
            for(FileProperties file : files){
                result.add(file.getName());
            }
            return result;
    }
}


/*myTextArea.clear();
        textField.clear();*/
        
        /*Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                stringSeparator();
                
                myTextArea.appendText("Noch nicht fertig");
                
                try{
                    for (int i = 0; i < 4; i++) {
                        myTextArea.appendText(".");
                        TimeUnit.SECONDS.sleep(1);
                    }
                    myTextArea.appendText(" Es tut mir leid");
                    for (int i = 0; i < 4; i++) {
                        myTextArea.appendText(".");
                        TimeUnit.SECONDS.sleep(1);
                    }
                    myTextArea.appendText(" Probier ein anderes Knopf");
                    for (int i = 0; i < 4; i++) {
                        myTextArea.appendText(".");
                        TimeUnit.SECONDS.sleep(1);
                    }
                    myTextArea.appendText(" \nDanke");
                    
                    for (int i = 0; i < 4; i++) {
                        myTextArea.appendText(".");
                        TimeUnit.SECONDS.sleep(1);
                    }
                    
                    }catch(Exception e){
                    
                }
                myTextArea.clear();
                textField.clear();
            }
        });
        thread.setDaemon(true);
        thread.start();*/
    
    
    
    
    

