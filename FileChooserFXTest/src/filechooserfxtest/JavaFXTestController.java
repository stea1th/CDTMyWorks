/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filechooserfxtest;


import java.io.File;

import java.net.URL;
import java.nio.file.Files;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author vvlasov
 */
public class JavaFXTestController implements Initializable {

    @FXML
    private FlowPane root;
    @FXML
    private TextArea myTextArea;
    @FXML
    private TextField myTextField;
    @FXML
    private Button myCreateButton;
    @FXML
    private Button myAddButton;
    @FXML
    private Button myRemoveButton;
    @FXML
    private Button myExtractButton;
    @FXML
    private Button addZipFile;
    
    private Stage primaryStage;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    public void printIt() throws Exception{
        FileChooser fileChooser  = new FileChooser();
        
        
        myTextArea.clear();
        List<File> list = fileChooser.showOpenMultipleDialog(primaryStage);
        if(list==null || list.isEmpty()){
            return;
        }
        for (File file : list){
            myTextArea.appendText("File "+file.getName().toString()+" "+"\n");
        }
        
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Files must be saved!");
        alert.setHeaderText("ZipDatei nötig");
        alert.setContentText("Bitte finde ein ZipDatei");
        alert.showAndWait();
        
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("TXT Files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(filter);
        File file = fileChooser.showSaveDialog(primaryStage);
        if(file!=null){
            myTextArea.appendText("----------------------------------------------------------\n");
            myTextArea.appendText("Es wurde in "+file.getName()+ " gespeichert\n");
        }else{
            //myTextArea.clear();
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    myTextArea.appendText("----------------------------------------------------------\n");
                    myTextArea.appendText("Prozess wurde abgebrochen");
                    for (int i = 0; i < 5; i++) {
                        try{
                        TimeUnit.SECONDS.sleep(1);
                        myTextArea.appendText(".");
                        }catch(InterruptedException e){
                            
                        }
                
            }
            myTextArea.clear();
                }
            });
            thread.setDaemon(true);
            thread.start();
            
        }
        
    }
}
