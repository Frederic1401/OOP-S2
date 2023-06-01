package oop.code.Products;

public class Produkt {

    private String kategorie;        // Die Kategorie des Produkts
    private String name;             // Der Name des Produkts
    private String technischeDaten;  // Die technischen Daten des Produkts
    private String kaufempfehlung;   // Die Kaufempfehlung für das Produkt
    private int jahrgang;            // Das Jahr, in dem das Produkt hergestellt wurde
    private int lieferzeit;          // Die Lieferzeit für das Produkt in Tagen
    private int mengenbestand;       // Der aktuelle Bestand des Produkts
    private int seriennummer;        // Die Seriennummer des Produkts
    private double preis;            // Der Preis des Produkts
    private boolean imAngebot;       // Gibt an, ob das Produkt im Angebot ist


    /**
     * Konstruktor zur Initialisierung eines Produktobjekts mit den angegebenen Parametern.
     *
     * @param kategorie        Die Kategorie des Produkts
     * @param name             Der Name des Produkts
     * @param technischeDaten  Die technischen Daten des Produkts
     * @param kaufempfehlung   Die Kaufempfehlung für das Produkt
     * @param jahrgang         Das Jahr, in dem das Produkt hergestellt wurde
     * @param lieferzeit       Die Lieferzeit für das Produkt in Tagen
     * @param mengenbestand    Der aktuelle Bestand des Produkts
     * @param seriennummer     Die Seriennummer des Produkts
     * @param preis            Der Preis des Produkts
     * @param imAngebot        Gibt an, ob das Produkt im Angebot ist
     */
    public Produkt(String kategorie, String name, String technischeDaten, String kaufempfehlung,
                   int jahrgang, int lieferzeit, int mengenbestand, int seriennummer, double preis, boolean imAngebot) {

        this.kategorie = kategorie;
        this.name = name;
        this.technischeDaten = technischeDaten;
        this.kaufempfehlung = kaufempfehlung;
        this.jahrgang = jahrgang;
        this.lieferzeit = lieferzeit;
        this.mengenbestand = mengenbestand;
        this.seriennummer = seriennummer;
        this.preis = preis;
        this.imAngebot = imAngebot;
    }
    public String getKategorie() {return kategorie;}
    public String getName() {return name;}
    public String getTechnischeDaten() {return technischeDaten;}
    public String getKaufempfehlung() {return kaufempfehlung;}
    public int getJahrgang() {return jahrgang;}
    public int getLieferzeit() {return lieferzeit;}
    public int getMengenbestand() {return mengenbestand;}
    public int getSeriennummer() {return seriennummer;}
    public double getPreis() {return preis;}
    public boolean isImAngebot() {return imAngebot;}

    public void setKategorie(String kategorie){
        this.kategorie = kategorie;
    }
    public void setName(String name) {this.name = name;}
    public void setTechnischeDaten(String technischeDaten) {this.technischeDaten = technischeDaten;}
    public void setKaufempfehlung(String kaufempfehlung) {this.kaufempfehlung = kaufempfehlung;}
    public void setJahrgang(int jahrgang) {this.jahrgang = jahrgang;}
    public void setLieferzeit(int lieferzeit) {this.lieferzeit = lieferzeit;}
    public void setMengenbestand(int mengenbestand) {this.mengenbestand = mengenbestand;}
    public void setSeriennummer(int seriennummer) {this.seriennummer = seriennummer;}
    public void setPreis(double preis) {this.preis = preis;}
    public void setImAngebot(boolean imAngebot) {this.imAngebot = imAngebot;}
}
