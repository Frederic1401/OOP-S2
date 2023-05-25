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
        // Implementiere die Logik für das Hinzufügen eines Produkts hier
          //Seriennummer eingeben 
          String seriennummer = JOptionPane.showInputDialog(this, "Seriennummer eingeben:");
          if (seriennummer != null && !seriennummer.isEmpty()) {
              productListModel.addElement(seriennummer);
          }
          //Produktnamen eingeben
          String produktname = JOptionPane.showInputDialog(this, "Produktnamen eingeben:");
          if (produktname != null && !produktname.isEmpty()) {
              productListModel.addElement(produktname);
          }
          //Preis eingeben
          String produktpreis = JOptionPane.showInputDialog(this, "Produktpreis eingeben:");
          if (produktpreis != null && !produktpreis.isEmpty()) {
              productListModel.addElement(produktpreis);
          }
          //Kategorie
          String produktkategorie = JOptionPane.showInputDialog(this, "Produktkategorie eingeben:");
          if (produktkategorie != null && !produktkategorie.isEmpty()) {
              productListModel.addElement(produktkategorie);
          }
         //Lieferzeit in Tagen eingeben
      String produktlieferzeit = JOptionPane.showInputDialog(this, "Lieferzeit eingeben:");
      if (produktlieferzeit != null && !produktlieferzeit.isEmpty()) {
          productListModel.addElement(produktlieferzeit);
      }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ProductKatalogGUI catalogGUI = new ProductKatalogGUI();
            catalogGUI.setVisible(true);
        });
    }
}
