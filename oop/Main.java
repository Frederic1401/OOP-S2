package oop;
// test
public class Main {
    public static void main(String[] args){
        Produkt produkt1 = new Produkt();

       // System.out.println("Seriennummer: " + produkt1.getSeriennummer());
       // System.out.println("Jahrgang: " + produkt1.getJahrgang());
       // System.out.println("Preis: " + produkt1.getPreis());
       // System.out.println("Name: " + produkt1.getName());
       // System.out.println("Mengenbestand: " + produkt1.getMengenbestand());

        ProduktKatalog produktKatalog = new ProduktKatalog();
        produktKatalog.neuesProduktErstellen();

        produktKatalog.anzeigenProduktKatalog();
    }
}
