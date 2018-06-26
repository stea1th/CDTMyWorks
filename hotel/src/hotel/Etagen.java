/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

/**
 *
 * @author vvlasov
 */
public class Etagen {
    private int stockwerk;
    private String bezeichnung;

    public Etagen(int stockwerk, String bezeichnung) {
        this.stockwerk = stockwerk;
        this.bezeichnung = bezeichnung;
    }

    @Override
    public String toString() {
        return String.format("% d        --> %s", stockwerk, bezeichnung);
    }

    public int getStockwerk() {
        return stockwerk;
    }
    
    
}
