package arkanoidtest;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author vvlasov
 */
public class Stand extends Rectangle implements Runnable {

    private double x;
    private int y;
    private double maxx;
    private final int speed;
    private Scene parent;
    private boolean gameOver = false;

    public Stand(int speed) {
        this.speed = speed;

        this.setHeight(20);
        this.setWidth(70);
        this.setFill(Color.BLACK);
        this.setLayoutX(50);
        this.setLayoutY(350);
        this.x = this.getX();

        //this.setLayoutX(100);
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public void setParent(Scene parent) {
        this.parent = parent;
    }

    public void setMaxx(double maxx) {
        this.maxx = maxx;
    }

    public void moveLeft() {
        x -= speed;
        this.setTranslateX(x);
        if (x <= -getLayoutX()) {
            x = -getLayoutX();
            this.setTranslateX(x);

        }
    }

    public void moveRight() {
        x += speed;
        this.setTranslateX(x);
        if (x >= maxx - (getLayoutX() + this.getWidth())) {
            x = maxx - (getLayoutX() + this.getWidth());
            this.setTranslateX(x);
        }
    }

    @Override
    public void run() {
        while (true) {

            parent.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent event) {

                    if (event.getText().equalsIgnoreCase("a") && !gameOver) {
                        moveLeft();
                        //System.out.println(gameOver);
                        //System.out.println("moveLeft");
                    } else if (event.getText().equalsIgnoreCase("d") && !gameOver) {
                        moveRight();
                        //System.out.println(gameOver);
                        //System.out.println("moveRight");
                    }
                }
            });
        }
    }
}
