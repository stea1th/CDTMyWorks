/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package benutzerdefdatentyp;

/**
 *
 * @author vvlasov
 */
public class Zeit {

    private int hour;
    private int minute;
    private int second;

    //Neu: Klassenattribut zur Steuerung der Art der Ausgabe
    private static int format;

    //Neu: Block zur Initialisierung von Klassenattributen
    static {
        System.out.println("Klasse wird geladen...");
        format = 1;  //Ausgabe wie bisher
        //alternativ: 2 Ausgabe in Worten...

    }

    // Neu: Akzessoren für Klassenattribut
    public static int getFormat() {
        return format;
    }

    public static void setFormat(int format) {
        if (format == 1 || format == 2) {
            Zeit.format = format;
        }
    }

    public Zeit(int h, int m, int s) {     //typischer Konstruktor
        /*für zu grosse Werte in min bzw. in sec wird der grösste erlaubte Wert angenommen
        für zu kleine Werte der kleinste erlaubte Wert
        für negative Werte in std wird 0 angenommen*/
        this.hour = h < 0 ? 0 : h;
        this.minute = m < 0 ? 0 : m > 59 ? 59 : m;
        this.second = s < 0 ? 0 : s > 59 ? 59 : s;
    }

    public Zeit() {
        //Standard-Konstruktor
        //ystem.out.println("Konstruktor wird geladen...");

    }

    public Zeit(Zeit z) {   //Copy-Konstruktor
        this.hour = z.hour;
        this.minute = z.minute;
        this.second = z.second;
    }

    public Zeit(int second) {    //fachspezifischer Konstruktor
        if (second <= 0) {
            return;
        }
        this.hour = second / 3600;
        this.minute = second % 3600 / 60;
        this.second = second % 60;
    }

    public void addSec(int sec) {
        if (sec <= 0) {
            return;
        }
        long erg = timeToSec() + sec;
        second = (int) (erg % 60);
        erg /= 60;
        minute = (int) (erg % 60);
        erg /= 60;
        hour = (int) erg;

    }

    public Zeit addiereZeit(Zeit z) {
        second += z.second;
        if (second > 59) {
            second -= 60;
            minute++;
        }
        minute += z.minute;
        if (minute > 59) {
            minute -= 60;
            hour++;
        }
        hour += z.hour;
        return this;
    }

    public long timeToSec() {
        return (long) (second + minute * 60 + hour * 3600);
    }

    public void setHour(int hour) {
        if (hour >= 0) {
            this.hour = hour;
        } else {
            System.out.println("Falsche Eingabe");
        }
    }

    public void setMinute(int minute) {
        if (minute < 0 || minute > 59) {
            System.out.println("Falsche Eingabe");
        } else {
            this.minute = minute;
        }
    }

    public void setSecond(int second) {
        if (second >= 0 && second <= 59) {
            this.second = second;
        }
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    public void print() {
        //System.out.print(this.toString());
        if(format == 1)
            System.out.print(this);
        else
            System.out.println(hour+" Stunden, "+
                    minute+" Minuten und "+
                    second+" Sekunden");
    }

    public void println() {
        this.print();
        System.out.println();
    }

    @Override
    public String toString() {

        return String.format("%d:%02d:%02d", hour, minute, second);
    }

    public boolean equals(Zeit z) {
        //return this.timeToSec()==z.timeToSec();
        return hour == z.hour
                && minute == z.minute
                && second == z.second;
    }

    public int compareTo(Zeit z) {
        return (int) (timeToSec() - z.timeToSec());
    }
}
