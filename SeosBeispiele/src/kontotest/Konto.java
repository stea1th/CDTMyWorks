/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontotest;

/**
 *
 * @author vvlasov
 */
public class Konto {

    private int accountNumber;
    private String name;
    private double accountState;
    private static double habenZins = 0;
    private static double sollZins = 0;
    private int dispo = 0;
    private int buchungsZahler = 24;

    public Konto(int accountNumber, String name) {
        this.accountNumber = accountNumber;
        this.name = name;
        display(this.accountNumber, this.name);
    }

    public Konto(int accountNumber, double accountState, String name) {
        this.accountNumber = accountNumber;
        this.accountState = accountState;
        this.name = name;
        display(this.accountNumber, this.name, this.accountState);
    }

    public Konto(int accountNumber, String name, double accountState) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.accountState = accountState;
        display(this.accountNumber, this.name, this.accountState);
    }

    public int getDispo() {
        return dispo;
    }

    public void setDispo(int dispo) {
        this.dispo = dispo;
    }

    public static double getHabenZins() {
        return habenZins;
    }

    public static void setHabenZins(double habenZins) {
        Konto.habenZins = habenZins;
    }

    public double getZinsen() {
        
        if (accountState >= 0) {
            System.out.printf("Zinsen: \t%10.2f\n", accountState * (habenZins / 36000));
            return accountState * (habenZins / 36000);
        } else {
            System.out.printf("Zinsen: \t%10.2f\n", accountState * (sollZins / 36000));
            return accountState * (sollZins / 36000);
        }
    }

    private void getGebuhren() {
        double a = 0.25;
        double b = 0.1;
        if (buchungsZahler > 25) {
            accountState -= a;
            System.out.printf("Gebühren: \t%10.2f\n", -a);
        } else if (buchungsZahler > 10) {
            accountState -= b;
            System.out.printf("Gebühren: \t%10.2f\n", -b);
        }

    }

    public static double getSollZins() {
        return sollZins;
    }

    public static void setSollZins(double sollZins) {
        Konto.sollZins = sollZins;
    }

    public boolean abheben(double money) {
        boolean isTrue = false;
        if (accountState + dispo >= money && money >= 0) {
            buchungsZahler++;
            accountState -= money;
            isTrue = true;
            System.out.printf("Abheben:\t%10.2f %10d\n", -money, buchungsZahler);
            getGebuhren();
            getZinsen();
        }
        display(accountState, isTrue);
        return isTrue;
    }

    public boolean einzahlen(double money) {
        boolean isTrue = false;
        if (money >= 0) {
            buchungsZahler++;
            accountState += money;
            isTrue = true;
            System.out.printf("Einzahlen:\t%10.2f %10d\n", money, buchungsZahler);
            getGebuhren();
            getZinsen();
        }
        display(accountState, isTrue);
        return isTrue;
    }

    private void display(int number, String name) {
        System.out.printf("Nummer: \t%010d\nKontoinhaber: %12s\n", number, name);
        System.out.println("-------------------------------------");
    }

    private void display(int number, String name, double acc) {
        display(number, name);
        display(acc);
    }

    private void display(double acc, boolean b) {
        System.out.printf("\tKonto wurde %s geändert\n", b ? "" : "nicht");
        //System.out.print("Neuer ");
        display(acc);
    }

    private void display(double acc) {
        System.out.printf("Kontostand: \t%10.2f\n", acc);
    }
}
