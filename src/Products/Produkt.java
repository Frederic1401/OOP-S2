package src.Products;

/**
 * Package 'code.Products'
 *
 * Zweck: Fachklasse eines Produktes
 * @author: benjamin Adam
 * @version: 21.05.2023
 * Historie: 21.05.2023, Erstellung der Fachklasse
 */
public class Produkt implements Comparable<Produkt>{

    private String kategorie;
    private String name;
    private String beschreibung;
    private Produkt kaufempfehlung;
    private int jahrgang;
    private int lieferzeit;
    private int mengenbestand;
    private int seriennummer;
    private double preis;
    private boolean imAngebot;

    /**
     * Konstruktor zur Initialisierung eines Produktobjekts mit den angegebenen Parametern.
     *
     * @param kategorie        Die Kategorie des Produkts
     * @param name             Der Name des Produkts
     * @param beschreibung     Die Beschreibung Daten des Produkts
     * @param kaufempfehlung   Die Kaufempfehlung für das Produkt
     * @param jahrgang         Das Jahr, in dem das Produkt hergestellt wurde
     * @param lieferzeit       Die Lieferzeit für das Produkt in Tagen
     * @param mengenbestand    Der aktuelle Bestand des Produkts
     * @param seriennummer     Die Seriennummer des Produkts
     * @param preis            Der Preis des Produkts
     * @param imAngebot        Gibt an, ob das Produkt im Angebot ist
     */
    public Produkt(String kategorie, String name, String beschreibung, Produkt kaufempfehlung,
                   int jahrgang, int lieferzeit, int mengenbestand, int seriennummer, double preis, boolean imAngebot) {

        this.kategorie = kategorie;
        this.name = name;
        this.beschreibung = beschreibung;
        this.kaufempfehlung = kaufempfehlung;
        this.jahrgang = jahrgang;
        this.lieferzeit = lieferzeit;
        this.mengenbestand = mengenbestand;
        this.seriennummer = seriennummer;
        this.preis = preis;
        this.imAngebot = imAngebot;
    }


    /**
     * Eine Methode zum Erstellen eines Strings, der alle Attribute des Produktes beinhaltet.
     * <p>Falls keine Kaufempfehlung vorhanden ist, wird darauf hingewiesen.
     *
     * @return Ein String, der alle Attribute des Produkts beinhaltet.
     */
    public String toString() {
        return seriennummer+" {" +
                "Kategorie: " + kategorie + "'" +
                ", Name: " + name + "'" +
                ", Beschreibung: '" + beschreibung + "'" +
                ", Jahrgang: " + jahrgang +
                ", Lieferzeit: " + lieferzeit +
                ", Mengenbestand: " + mengenbestand +
                ", Preis: " + preis +
                ", imAngebot: " + imAngebot +
                ", Kaufempfehlung: ["+(kaufempfehlung==null ? "Keine Kaufempfehlung vorhanden" : "Seriennummer: " + kaufempfehlung.getSeriennummer() + "; name: '" +kaufempfehlung.getName()) + "'" +
                "]}";
    }

    /**
     * Eine Methode zum Vergleichen zweier Produkte hinsichtlich ihres Preises.
     *
     * @param anderes das zu vergleichende Produkt.
     * @return 1: wenn der Preis des anderen Produktes niedriger ist;
     * <p>-1, wenn der Preis des anderen Produktes größer ist;
     * <p>0: wenn der Preis des anderen Produktes gleich groß ist.
     */
    public int compareTo(Produkt anderes) {
        if(anderes.getPreis() < this.preis){
            return 1;
        }
        if(anderes.getPreis() > this.preis){
            return -1;
        }
        return 0;
    }

    public String getKategorie() {return kategorie;}
    public String getName() {return name;}
    public String getBeschreibung() {return beschreibung;}
    public Produkt getKaufempfehlung() {return kaufempfehlung;}
    public int getJahrgang() {return jahrgang;}
    public int getLieferzeit() {return lieferzeit;}
    public int getMengenbestand() {return mengenbestand;}
    public int getSeriennummer() {return seriennummer;}
    public double getPreis() {return preis;}
    public boolean isImAngebot() {return imAngebot;}

    public void setKategorie(String kategorie){this.kategorie = kategorie;}
    public void setName(String name) {this.name = name;}
    public void setBeschreibung(String beschreibung) {this.beschreibung = beschreibung;}
    public void setKaufempfehlung(Produkt kaufempfehlung) {this.kaufempfehlung = kaufempfehlung;}
    public void setJahrgang(int jahrgang) {this.jahrgang = jahrgang;}
    public void setLieferzeit(int lieferzeit) {this.lieferzeit = lieferzeit;}
    public void setMengenbestand(int mengenbestand) {this.mengenbestand = mengenbestand;}
    public void setSeriennummer(int seriennummer) {this.seriennummer = seriennummer;}
    public void setPreis(double preis) {this.preis = preis;}
    public void setImAngebot(boolean imAngebot) {this.imAngebot = imAngebot;}
}
