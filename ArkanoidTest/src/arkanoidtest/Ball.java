/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arkanoidtest;

import javafx.scene.control.TextArea;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author vvlasov
 */
public class Ball {
    private double speed;
    //направление  (в градусах от 0 до 360)
    private double direction;

    //текущее значение вектора движения (dx,dy)
    private double dx;
    private double dy;
    private double x;
    private double y;
    private double width;
    private double height;

    //заморожен ли объект или может двигаться
    

    public Ball(double x, double y, double speed, double direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.speed = speed;
        

        
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDirection() {
        return direction;
    }

    public double getDx() {
        return dx;
    }

    public double getDy() {
        return dy;
    }

    /**
     * Устанавливаем новое направление движения.
     * Тут же вычисляем и новый вектор.
     * Такой подход удобно использовать при отскоках от стен.
     */
    void setDirection(double direction) {
        this.direction = direction;

        double angel = Math.toRadians(direction);
        dx = Math.cos(angel) * speed;
        dy = -Math.sin(angel) * speed;
    }

    
    public void move() {

        x += dx;
        y += dy;

        checkRebound(10, width-10, 30, height/*-10*/);
    }

    /**
     * Проверяем не улетел ли шарик за стенку.
     * Если да - отражаем его.
     */
    void checkRebound(int minx, double maxx, int miny, double maxy) {
        if (x < minx) {
            x = minx + (minx - x);
            dx = -dx;
        }

        if (x > maxx) {
            x = maxx - (x - maxx);
            dx = -dx;
        }

        if (y < miny) {
            y = miny + (miny - y);
            dy = -dy;
        }

        if (y > maxy) {
            y = maxy - (y - maxy);
            dy = -dy;
        }
    }
   

    /**
     * Запускам шарик.
     * isFrozen = false.
     * Пересчитываем вектор движения (dx,dy).
     */
    void start() {
        this.setDirection(direction);
        
        
    }
}
