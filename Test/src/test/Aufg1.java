/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;



/**
 *
 * @author vvlasov
 */

public class Aufg1 implements Comparable<Aufg1>{
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Aufg1(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public static void main(String[] args) {
        System.out.println(new Aufg1("Vasia", 12.34f, 6).compareTo(new Aufg1("Petia", 10.2f, 5)));

    }

    

    @Override
    synchronized public int compareTo(Aufg1 o) {
        int x = distance==o.distance? 0 : distance>o.distance? -1 : 1;
        int y = quality-o.quality;
        return x+y;
    }
     
}