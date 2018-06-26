/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arkanoidtest;

import java.util.Random;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author vvlasov
 */
public class Brick extends Rectangle {
    
    
    private boolean Alive = false;
   

    public Brick(double x, double y) {
        
        this.setLayoutX(x);
        this.setLayoutY(y);
        //this.setFill(Color.AQUA);
        this.setHeight(20);
        this.setWidth(50);
        
        
        
        
    }
    
    public boolean isAlive() {
        return Alive;
    }

    public void setAlive(boolean isAlive) {
        this.Alive = isAlive;
    }
    
    
    
    
    
    
    
}
