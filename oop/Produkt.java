package oop;

public class Produkt {
    private int seriennummer;
    private int jahrgang;
    private double preis;
    private String name;
    private int mengenbestand;

    // Konstruktor
    public Produkt(int seriennummer, int jahrgang, double preis, String name, int mengenbestand) {
        this.seriennummer = seriennummer;
        this.jahrgang = jahrgang;
        this.preis = preis;
        this.name = name;
        this.mengenbestand = mengenbestand;
    }

    // Getter und Setter für Seriennummer
    public int getSeriennummer() {
        return seriennummer;
    }

    public void setSeriennummer(int seriennummer) {
        this.seriennummer = seriennummer;
    }

    // Getter und Setter für Jahrgang
    public int getJahrgang() {
        return jahrgang;
    }

    public void setJahrgang(int jahrgang) {
        this.jahrgang = jahrgang;
    }

    // Getter und Setter für Preis
    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    // Getter und Setter für Name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter und Setter für Mengenbestand
    public int getMengenbestand() {
        return mengenbestand;
    }

    public void setMengenbestand(int mengenbestand) {
        this.mengenbestand = mengenbestand;
    }
}
