/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filechooserfxtest;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author vvlasov
 */
public class FileChooserFXTest extends Application {
    //private Stage primaryStage;
    private JavaFXTestController controller;
    
    
    @Override
    public void start(Stage primaryStage) {
        try{
            FXMLLoader loader = new FXMLLoader();
            Parent root = loader.load(getClass().getResource("JavaFXTest2.fxml"));
            
            
            primaryStage.setTitle("Java FX TEST");
            primaryStage.setScene(new Scene(root));
            primaryStage.setResizable(false);
            primaryStage.show();
            controller = loader.getController();
            controller.setPrimaryStage(primaryStage);
            //this.primaryStage = primaryStage;
            
            
        }catch(Exception e){
            System.out.println(e.getClass()+" "+e.getMessage());
        }
    }
/**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
