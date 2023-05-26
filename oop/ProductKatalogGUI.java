package oop;

import javax.swing.*;
import java.awt.*;

public class ProductKatalogGUI extends JFrame {
    private JList<String> productList;
    private DefaultListModel<String> productListModel;

    public ProductKatalogGUI() {
        setTitle("Produktkatalog");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        productListModel = new DefaultListModel<>();
        productList = new JList<>(productListModel);
        JScrollPane scrollPane = new JScrollPane(productList);
        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        JButton prodhinzuButton = new JButton("Neues Produkt anlegen");
        prodhinzuButton.addActionListener(e -> addProduct());
        buttonPanel.add(prodhinzuButton);

        JButton prodbearbButton = new JButton("Bestehendes Produkt bearbeiten");
        //prodbearbButton.addActionListener(e -> editProduct());
        buttonPanel.add(prodbearbButton);

        JButton prodzeigButton = new JButton("Bestehende Produkte anzeigen");
        //prodbearbButton.addActionListener(e -> showProducts());
        buttonPanel.add(prodzeigButton);

        JButton prodloschButton = new JButton("Produkte löschen");
        //prodbearbButton.addActionListener(e -> showProducts());
        buttonPanel.add(prodloschButton);



        add(buttonPanel, BorderLayout.WEST);
    }

    private void addProduct() {
      
          //Seriennummer eingeben 
          String seriennummer = JOptionPane.showInputDialog(this, "Seriennummer eingeben:");
          if (seriennummer != null && !seriennummer.isEmpty()) {
              productListModel.addElement("Seriennummer: " + seriennummer);
          }
          if (seriennummer == null){
            productListModel.addElement("-");
          }
          //Produktnamen eingeben
          String produktname = JOptionPane.showInputDialog(this, "Produktnamen eingeben:");
          if (produktname != null && !produktname.isEmpty()) {
              productListModel.addElement("Produktname: " + produktname);
          }
          if (produktname.isEmpty()){
            productListModel.addElement("Produktname: -");
          }
          //Preis eingeben
          String produktpreis = JOptionPane.showInputDialog(this, "Produktpreis in Euro eingeben:");
          if (produktpreis != null && !produktpreis.isEmpty()) {
              productListModel.addElement("Preis: " + produktpreis + "€");
          }
          if (produktpreis.isEmpty()){
            productListModel.addElement("Preis: -");
          }
          //Kategorie
          String produktkategorie = JOptionPane.showInputDialog(this, "Produktkategorie eingeben:");
          if (produktkategorie != null && !produktkategorie.isEmpty()) {
              productListModel.addElement("Kategorie: " + produktkategorie);
          }
          if (produktkategorie.isEmpty()){
            productListModel.addElement("Kategorie: -");
          }
         //Lieferzeit in Tagen eingeben
      String produktlieferzeit = JOptionPane.showInputDialog(this, "Lieferzeit in Tagen eingeben:");
      if (produktlieferzeit != null && !produktlieferzeit.isEmpty()) {
          productListModel.addElement("Lieferzeit: " + produktlieferzeit + " Tage");
      }
      if (produktlieferzeit.isEmpty()){
        productListModel.addElement("Lieferzeit: -");
      }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ProductKatalogGUI catalogGUI = new ProductKatalogGUI();
            catalogGUI.setVisible(true);
        });
    }
}
