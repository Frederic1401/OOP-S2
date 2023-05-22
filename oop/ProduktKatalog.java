package oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProduktKatalog {
    private List<Produkt> produkte;

    public ProduktKatalog() {
        produkte = new ArrayList<>();
    }

    public void neuesProduktErstellen() {
        Scanner scanner = new Scanner(System.in);
        String weiteresProdukt = "Ja";
        while (weiteresProdukt.equalsIgnoreCase("Ja")) {

        System.out.println("Geben Sie die Seriennummer ein:");
        String seriennummer = scanner.nextLine();

        System.out.println("Geben Sie den Jahrgang ein:");
        int jahrgang = scanner.nextInt();

        System.out.println("Geben Sie den Preis ein:");
        double preis = scanner.nextDouble();

        System.out.println("Geben Sie den Namen ein:");
        String name = scanner.nextLine();

        System.out.println("Geben Sie den Mengenbestand ein:");
        int mengenbestand = scanner.nextInt();

        System.out.println("Geben Sie die Lieferzeit ein:");
        int lieferzeit = scanner.nextInt();

        System.out.println("Geben Sie die technischen Daten ein:");
        String technischeDaten = scanner.nextLine();

        System.out.println("Geben Sie die Kategorie ein:");
        String kategorie = scanner.nextLine();

        System.out.println("Geben Sie Produkte ein, die oft mit diesem Produkt gekauft werden (Leer lassen, wenn keine):");
        String wirdOftGekauftMit = scanner.nextLine();

        // Neues Produkt wird erstellt und dem Katalog hinzugefügt
        Produkt neuesProdukt = new Produkt();
        neuesProdukt.setSeriennummer(Integer.parseInt(seriennummer));
        neuesProdukt.setJahrgang(jahrgang);
        neuesProdukt.setPreis(preis);
        neuesProdukt.setName(name);
        neuesProdukt.setMengenbestand(mengenbestand);
        neuesProdukt.setLieferzeit(lieferzeit);
        neuesProdukt.setTechnischeDaten(technischeDaten);
        neuesProdukt.setKategorie(kategorie);
        neuesProdukt.setWirdOftGekauftMit(wirdOftGekauftMit);

        produkte.add(neuesProdukt);

        System.out.println("Das Produkt wurde erfolgreich erstellt und dem Katalog hinzugefügt.");

        System.out.println("Möchten Sie ein weiteres Produkt erstellen? (Ja/Nein)");
        weiteresProdukt = scanner.nextLine();
    } while (weiteresProdukt.equalsIgnoreCase("Ja"));

        scanner.close();

    }

    public void anzeigenProduktKatalog() {
        if (produkte.isEmpty()) {
            System.out.println("Der Produktkatalog ist leer.");
        } else {
            System.out.println("Produktkatalog:");
            for (Produkt produkt : produkte) {
                System.out.println("------------------------------");
                System.out.println("Seriennummer: " + produkt.getSeriennummer());
                System.out.println("Jahrgang: " + produkt.getJahrgang());
                System.out.println("Preis: " + produkt.getPreis());
                System.out.println("Name: " + produkt.getName());
                System.out.println("Mengenbestand: " + produkt.getMengenbestand());
                System.out.println("Lieferzeit: " + produkt.getLieferzeit());
                System.out.println("Technische Daten: " + produkt.getTechnischeDaten());
                System.out.println("Kategorie: " + produkt.getKategorie());
                System.out.println("Wird oft gekauft mit: " + produkt.getWirdOftGekauftMit());
            }
            System.out.println("------------------------------");
        }
    }
}



