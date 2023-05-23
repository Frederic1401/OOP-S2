package oop;

public class Produkt {
    private int seriennummer;
    private int jahrgang;
    private double preis;
    private String name;
    private int mengenbestand;
    private int lieferzeit;
    private String technischeDaten;
    private String kategorie;
    private String wirdOftGekauftMit;
    private boolean imAngebot;


    //Konstruktor zum manuellen Festlegen aller vorhanden Eigenschaften
    public Produkt(int seriennummer, int jahrgang, double preis, String name, int mengenbestand,
                   int lieferzeit, String technischeDaten, String kategorie, String wirdOftGekauftMit, boolean imAngebot){
        this.seriennummer = seriennummer;
        this.jahrgang = jahrgang;
        this.preis = preis;
        this.name = name;
        this.mengenbestand = mengenbestand;
        this.lieferzeit = lieferzeit;
        this.technischeDaten = technischeDaten;
        this.kategorie = kategorie;
        this.wirdOftGekauftMit = wirdOftGekauftMit;
        this.imAngebot = imAngebot;
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

    //Getter und Setter Lieferzeit
    public int getLieferzeit() {
        return lieferzeit;
    }
    public void setLieferzeit(int lieferzeit) {
        this.lieferzeit = lieferzeit;
    }

    //Getter und Setter Techn. Daten
    public String getTechnischeDaten() {
        return technischeDaten;
    }
    public void setTechnischeDaten(String technischeDaten) {
        this.technischeDaten = technischeDaten;
    }

    //Getter und Setter Kategorie
    public String getKategorie() {
        return kategorie;
    }
    public void setKategorie(String kategorie) {
        this.kategorie = kategorie;
    }

    //Getter und Setter "Wird oft gekauft mit..."
    public String getWirdOftGekauftMit() {
        return wirdOftGekauftMit;
    }
    public void setWirdOftGekauftMit(String wirdOftGekauftMit) {
        this.wirdOftGekauftMit = wirdOftGekauftMit;
    }

    //Getter und Setter "Im Angebot?"
    public boolean isImAngebot() {return imAngebot;}
    public void setImAngebot(boolean imAngebot) {this.imAngebot = imAngebot;}
}
