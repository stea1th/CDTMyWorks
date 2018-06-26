/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archiver;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author vvlasov
 */
public class Archiver extends Application {
    
    private ArchiverFaceController controller;
    
    @Override
    public void start(Stage primaryStage) {
        try{
            FXMLLoader loader = new FXMLLoader();
            Parent root = loader.load(getClass().getResource("ArchiverFace.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add(this.getClass().getResource("DarkTheme.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setTitle("MyArchiver");
            primaryStage.setResizable(false);
            primaryStage.show();
            
            controller = loader.getController();
            controller.setPrimaryStage(primaryStage);
        }catch(Exception e){
            
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
    }
    
}
