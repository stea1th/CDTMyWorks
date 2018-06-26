/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.control.TextField;
import javafx.scene.layout.Border;

import javafx.scene.layout.Pane;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author vvlasov
 */
public class CalculatorFace extends Application {

    private MyTextField tField;

    @Override
    public void start(Stage primaryStage) {
        //Group root = new Group();
        //root.getChildren().add(btn);
        //GridPane root = new GridPane();

        Pane root = new Pane();
        root.setStyle("-fx-background-color: \n"
                + "        linear-gradient(#f2f2f2, #d6d6d6),\n"
                + "        linear-gradient(#fcfcfc 0%, #d9d9d9 20%, #d6d6d6 100%),\n"
                + "        linear-gradient(#dddddd 0%, #f6f6f6 50%);\n"
                + "    -fx-background-radius: 8,7,6;\n"
                + "    -fx-background-insets: 0,1,2;\n"
                + "    -fx-text-fill: black;\n"
                + "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );");

        //root.setBorder(Border.EMPTY);
        tField = new MyTextField();

        MyButton n7 = new MyButton("7", 20, 120, tField);
        MyButton n8 = new MyButton("8", 75, 120, tField);
        MyButton n9 = new MyButton("9", 130, 120, tField);
        MyButton n4 = new MyButton("4", 20, 145, tField);
        MyButton n5 = new MyButton("5", 75, 145, tField);
        MyButton n6 = new MyButton("6", 130, 145, tField);
        MyButton n1 = new MyButton("1", 20, 170, tField);
        MyButton n2 = new MyButton("2", 75, 170, tField);
        MyButton n3 = new MyButton("3", 130, 170, tField);
        MyButton n0 = new MyButton("0", 20, 195, tField);
        n0.setPrefSize(100, USE_PREF_SIZE);
        MyButton x1 = new MyButton(",", 130, 195, tField);
        MyButton x2 = new MyButton("√", 185, 90, tField);
        MyButton x3 = new MyButton("%", 240, 90, tField);

        MyExtraButton mxb1 = new MyExtraButton("/", 185, 120, tField);
        MyExtraButton mxb2 = new MyExtraButton("*", 185, 145, tField);
        MyExtraButton mxb3 = new MyExtraButton("-", 185, 170, tField);
        MyExtraButton mxb4 = new MyExtraButton("+", 185, 195, tField);
        MyExtraButton mxb5 = new MyExtraButton("=", 240, 120, tField);
        mxb5.setPrefSize(50, 100);
        MyClearAllButton mcab = new MyClearAllButton("Clear", 20, 90, tField);
        mcab.getButtonSize();
        MyClearAllButton mcab1 = new MyClearAllButton("<-", 130, 90, tField);

        Label label = new Label("made by stea1th");
        label.setLayoutX(210);
        label.setLayoutY(240);
        label.setOpacity(0.5);
        label.setTextFill(Color.RED);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("MyCalculator");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

        root.getChildren().addAll(tField, n1, n2, n3, n4, n5, n6, n7, n8, n9, n0, x1, mxb1, mxb2, mxb3, mxb4, mxb5);
        root.getChildren().addAll(mcab, mcab1, label, x2, x3);

        Thread thread = new Thread(new Welcome(tField));
        thread.setDaemon(true);
        thread.start();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);

    }

}
