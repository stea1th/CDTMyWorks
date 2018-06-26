/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arkanoidtest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.OverrunStyle;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Border;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

/**
 *
 * @author vvlasov
 */
public class ArkanoidTest extends Application {

    private Scene scene;
    private volatile boolean gameOver = false;

    @Override
    public void start(Stage primaryStage) {
        //Button btn = new Button();
        //TextArea textArea = new TextArea();
        //textArea.setPrefSize(400, 400);
        Circle circle = new Circle();
        circle.setFill(Color.RED);
        circle.setRadius(10);

        Image ico = new Image(this.getClass().getResource("Wikia.png").toExternalForm());
        primaryStage.getIcons().add(ico);

        Stand stand = new Stand(5);
        //stand.setLayoutX(200);
        AtomicInteger count = new AtomicInteger();
        TextField textField = new TextField();
        textField.setText("Points: " + count.getAndIncrement());
        textField.setFocusTraversable(false);
        textField.setEditable(false);
        textField.setBorder(Border.EMPTY);

        //circle.intersects(brick.getBoundsInLocal());
        //Random random = new Random(50);
        Label label = new Label();
        label.setLayoutX(190);
        label.setLayoutY(150);
        label.setText("Game Over!");
        label.setFont(Font.font(24));
        label.setVisible(gameOver);

        Group root = new Group();

        scene = new Scene(root, 500, 400);

        List<Brick> bricks = new ArrayList<>();
        createBricks(bricks);

        root.getChildren().addAll(circle, stand, textField, label);
        for (Brick brick : bricks) {
            //brick.setSmooth(true);
            root.getChildren().add(brick);
        }

        primaryStage.setTitle("Arkanoid");
        primaryStage.setScene(scene);
        primaryStage.show();
        stand.setMaxx(scene.getWidth());
        stand.setParent(stand.getScene());

        Thread myStand = new Thread(stand);
        myStand.setDaemon(true);
        myStand.start();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                Ball ball = new Ball(200, 345, 11, 60);

                ball.setWidth(scene.getWidth());
                ball.setHeight(scene.getHeight());
                ball.start();
                //gameOver = false;
                while (!gameOver) {
                    ball.move();
                    circle.setTranslateX(ball.getX());
                    circle.setTranslateY(ball.getY());
                    //stand.move(ball.getX()-35);
                    for (Brick brick : bricks) {
                        if (circle.getBoundsInParent().intersects(brick.getBoundsInParent())) {
                            brick.setAlive(false);
                            brick.setVisible(false);
                            brick.setLayoutX(-1);
                            brick.setLayoutY(-1);
                            textField.setText("Points: " + count.getAndIncrement());
                            //System.out.println("Its works");
                            ball.setDirection(Math.random() * 360);
                            /*if(count.intValue()%21==0){
                                createBricks(bricks);
                            }*/
 /*if(!brick.isAlive()){
                                brick.setLayoutX(random.nextInt((int)(scene.getWidth()-brick.getWidth())));
                                brick.setLayoutY(Math.random()*250+30);                                                //(random.nextInt(250)+30);        
                                brick.setVisible(true);
                                brick.setAlive(true);
                            }*/
                        }

                    }

                    if (circle.getBoundsInParent().intersects(stand.getBoundsInParent())) {
                        ball.setDirection(90 + 30 * (Math.random() - 0.5));
                    }
                    if (count.intValue() % (bricks.size() + 1) == 0) {
                        gameOver = true;

                        label.setVisible(gameOver);
                        stand.setGameOver(gameOver);

                    }

                    try {
                        TimeUnit.MILLISECONDS.sleep(50);
                    } catch (InterruptedException e) {
                        System.out.println("Fuck, error!!");
                    }

                }

            }

        });
        thread.setDaemon(true);
        thread.start();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public void createBricks(List<Brick> bricks) {
        //bricks = new ArrayList<>();
        int a = 50;
        int b = 50;
        Color color;
        Random random = new Random();

        //while(b<scene.getHeight()/3){
        for (int i = 0; i < 4; i++) {
            //Integer n = (int)Math.random()*Integer.MAX_VALUE+1;
            color = Color.rgb(random.nextInt(255), random.nextInt(255), random.nextInt(255));
            while (a < scene.getWidth() - 70) {
                //color = Color.rgb(random.nextInt(255),random.nextInt(255), random.nextInt(255));
                Brick brick = new Brick(a, b);
                brick.setFill(color);
                bricks.add(brick);

                a += 60;
            }
            b += 30;
            a = 50;

        }

    }

}
