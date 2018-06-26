/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aggregation;

import benutzerdefdatentyp.Zeit;

/**
 *
 * @author vvlasov
 */
public class Marathon {
    private int startNr;
    private String name = "";
    private Zeit zeit = new Zeit();

    public Marathon(int startNr, String name, Zeit zeit) {
        this.startNr = startNr;
        this.name = name;
        this.zeit = new Zeit(zeit);
    }

    public Marathon() {
    }
    
    public Marathon(Marathon m){
        this(m.startNr, m.name, m.zeit);
    }
    
    public Marathon(int nr, String nam, int std, int min, int sec){
        this(nr, nam, new Zeit(std, min, sec));
    }
    
    public Marathon(int nr, String nam){
        startNr = nr;
        name = nam;
        zeit = new Zeit();
    }
    
    

    public int getStartNr() {
        return startNr;
    }

    public void setStartNr(int startNr) {
        this.startNr = startNr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Zeit getZeit() {
        return new Zeit(zeit);
    }

    public void setZeit(Zeit zeit) {
        this.zeit.setHour(zeit.getHour());
        this.zeit.setMinute(zeit.getMinute());
        this.zeit.setSecond(zeit.getSecond());
    }
    
    public void setZeit(int std, int min, int sec){
        zeit.setHour(std);
        zeit.setMinute(min);
        zeit.setSecond(sec);
    }
    
    public String toString(){
        return String.format("%6d %-20s %s", startNr, name, zeit);
    }
    
    public int compareTo(Marathon m){
        return zeit.compareTo(m.zeit);
    }
}
