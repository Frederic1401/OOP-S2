package oop;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class ProduktKatalog {
    private List<Produkt> produktKatalog;

    public List<Produkt> getProduktKatalog() {
        return produktKatalog;
    }

    public ProduktKatalog() {
        produktKatalog = new ArrayList<>();
    }

    /**
     *  Erstellt über die Konsoleneingabe ein neues Objekt der Klasse Produkt
     */
    public void neuesProduktErstellen() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Geben Sie die Seriennummer ein:");
        int seriennummer = scanner.nextInt();

        System.out.println("Geben Sie den Jahrgang ein:");
        int jahrgang = scanner.nextInt();

        System.out.println("Geben Sie den Preis in Euro ein:");
        double preis = scanner.nextDouble();

        scanner.nextLine(); // Leere Zeile einlesen

        System.out.println("Geben Sie den Namen ein:");
        String name = scanner.nextLine();

        System.out.println("Geben Sie den Mengenbestand ein:");
        int mengenbestand = scanner.nextInt();

        System.out.println("Geben Sie die Lieferzeit in Tagen ein:");
        int lieferzeit = scanner.nextInt();

        scanner.nextLine(); // Leere Zeile einlesen

        System.out.println("Geben Sie die technischen Daten ein:");
        String technischeDaten = scanner.nextLine();

        System.out.println("Geben Sie die Kategorie ein:");
        String kategorie = scanner.nextLine();

        System.out.println("Geben Sie Produkte ein, die oft mit diesem Produkt gekauft werden (Leer lassen, wenn keine):");
        String wirdOftGekauftMit = scanner.nextLine();

        System.out.println("Geben Sie an, ob diese Produkt im Angebot ist (true/false)");
        boolean imAngebot = scanner.nextBoolean();

        scanner.nextLine(); // Leere Zeile einlesen

        // Neues Produkt wird erstellt und dem Katalog hinzugefügt
        Produkt neuesProdukt = new Produkt(seriennummer, jahrgang, preis, name, mengenbestand,
                lieferzeit, technischeDaten, kategorie, wirdOftGekauftMit, imAngebot);
        produktKatalog.add(neuesProdukt);

        System.out.println("Das Produkt wurde erfolgreich erstellt und dem Katalog hinzugefügt. \n");


    }

    /**
     *  Bearbeitet über die Konsoleneingabe ein bereits vorhandenes Objekt der Klasse Produkt
     */
    public void bestehendesProduktBearbeiten(){
        Scanner scanner = new Scanner(System.in);

        //Listet in der Konsole alle vorhanden Produkte auf
        for (int i = 0; i < produktKatalog.size(); i++) {
            System.out.println((i+1) + ". " + produktKatalog.get(i).getSeriennummer() + " | " + produktKatalog.get(i).getName());
        }
        System.out.println("Bitte Nummer eingeben von 1 bis " + produktKatalog.size() + "!");
        int index = scanner.nextInt();
        scanner.nextLine();

        Produkt aktuellesProdukt = produktKatalog.get(index - 1);

        System.out.println("Welche Eigenschaft soll bearbeitet werden?");
        System.out.println("Eigenschaften: Seriennummer, Jahrgang, Preis, Name, Mengenbestand, Lieferzeit, Technische Daten, Kategorie, Wird oft gekauft mit?, Im Angebot?");
        System.out.println("Eingabe Format: [Eigenschaft], [Neue Eingabe]");
        String eingabe = scanner.nextLine();
        String[] eingabeTeile = eingabe.split(", ");
        String eigenschaft = eingabeTeile[0];
        String neueEingabe = eingabeTeile[1];

        if (eigenschaft.equalsIgnoreCase("Seriennummer")) {
            aktuellesProdukt.setSeriennummer(Integer.parseInt(neueEingabe));
        } else if (eigenschaft.equalsIgnoreCase("Jahrgang")) {
            aktuellesProdukt.setJahrgang(Integer.parseInt(neueEingabe));
        } else if (eigenschaft.equalsIgnoreCase("Preis")) {
            aktuellesProdukt.setPreis(Integer.parseInt(neueEingabe));
        } else if (eigenschaft.equalsIgnoreCase("Name")) {
            aktuellesProdukt.setName(neueEingabe);
        } else if (eigenschaft.equalsIgnoreCase("Mengenbestand")) {
            aktuellesProdukt.setMengenbestand(Integer.parseInt(neueEingabe));
        } else if (eigenschaft.equalsIgnoreCase("Lieferzeit")) {
            aktuellesProdukt.setLieferzeit(Integer.parseInt(neueEingabe));
        } else if (eigenschaft.equalsIgnoreCase("Technische Daten")) {
            aktuellesProdukt.setTechnischeDaten(neueEingabe);
        } else if (eigenschaft.equalsIgnoreCase("Kategorie")) {
            aktuellesProdukt.setKategorie(neueEingabe);
        } else if (eigenschaft.equalsIgnoreCase("Wird oft gekauft mit?")) {
            aktuellesProdukt.setWirdOftGekauftMit(neueEingabe);
        } else if (eigenschaft.equalsIgnoreCase("Im Angebot?")) {
            aktuellesProdukt.setImAngebot(Boolean.parseBoolean(neueEingabe));
        } else {
            System.out.println("Falsche Eingabe! Entweder Eigenschaft oder neue Eingabe fehlerhaft");
        }
        System.out.println("Die Eigenschaft "+eigenschaft+" des Produktes mit der Seriennummer "+aktuellesProdukt.getSeriennummer()+" wurde zu "+neueEingabe+" verändert");
    }

    /**
     *  Listet jede Eigenschaft der Produkte in ProduktListe auf
     *  @throws IllegalStateException Der Produktkatalog ist leer
     */
    public void anzeigenProduktKatalog() {
        if (produktKatalog.isEmpty()) {
            System.out.println("Der Produktkatalog ist leer.");
        } else {
            System.out.println("Produktkatalog:");

            for (Produkt produkt : produktKatalog) {
                System.out.println("------------------------------");
                System.out.println("Seriennummer: " + produkt.getSeriennummer());
                System.out.println("Jahrgang: " + produkt.getJahrgang());
                System.out.println("Preis: " + produkt.getPreis());
                System.out.println("Name: " + produkt.getName());
                System.out.println("Mengenbestand: " + produkt.getMengenbestand());
                System.out.println("Lieferzeit: " + produkt.getLieferzeit());
                System.out.println("Technische Daten: " + produkt.getTechnischeDaten());
                System.out.println("Kategorie: " + produkt.getKategorie());
                System.out.println("Wird oft gekauft mit: " + (produkt.getWirdOftGekauftMit().isEmpty() ? "-" : produkt.getWirdOftGekauftMit()));
                System.out.println("Im Angebot: " + (produkt.isImAngebot() ? "Ja" : "Nein"));

            }
            System.out.println("------------------------------\n");
        }
    }
}




