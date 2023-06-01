package oop.code;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;

public class Test extends JFrame {
    private JTree productTree;

    public Test() {
        setTitle("Product Tree");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Erstelle die Wurzel des JTrees
        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("Produkte");

        // Füge einige Beispielkategorien hinzu
        DefaultMutableTreeNode category1 = new DefaultMutableTreeNode("Kategorie 1");
        DefaultMutableTreeNode category2 = new DefaultMutableTreeNode("Kategorie 2");

        rootNode.add(category1);
        rootNode.add(category2);

        // Füge einige Beispielprodukte hinzu
        DefaultMutableTreeNode product1 = new DefaultMutableTreeNode("Produkt 1 (Seriennummer: 123)");
        DefaultMutableTreeNode product2 = new DefaultMutableTreeNode("Produkt 2 (Seriennummer: 456)");
        DefaultMutableTreeNode product3 = new DefaultMutableTreeNode("Produkt 3 (Seriennummer: 789)");

        category1.add(product1);
        category1.add(product2);
        category2.add(product3);

        // Erstelle das JTree-Modell und setze es auf den JTree
        DefaultTreeModel treeModel = new DefaultTreeModel(rootNode);
        productTree = new JTree(treeModel);

        // Aktiviere die Mehrfachauswahl im JTree
        productTree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

        // Füge einen TreeSelectionListener hinzu, um auf Klicks zu reagieren
        productTree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                // Hole den ausgewählten Knoten
                DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) productTree.getLastSelectedPathComponent();

                if (selectedNode != null) {
                    // Überprüfe, ob es sich um eine Seriennummer handelt
                    String nodeText = selectedNode.toString();
                    if (nodeText.contains("Seriennummer")) {
                        // Extrahiere die Seriennummer aus dem Knotentext
                        String serialNumber = nodeText.substring(nodeText.lastIndexOf(":") + 1).trim();

                        // Rufe die Methode auf, um weitere Informationen basierend auf der Seriennummer zu erhalten
                        showProductDetails(serialNumber);
                    }
                }
            }
        });

        // Füge den JTree zu einem JScrollPane hinzu und setze ihn als Inhalt des JFrame
        JScrollPane scrollPane = new JScrollPane(productTree);
        getContentPane().add(scrollPane);

        pack();
        setLocationRelativeTo(null); // Zentriere das JFrame
    }

    // Methode zum Anzeigen weiterer Informationen basierend auf der Seriennummer
    private void showProductDetails(String serialNumber) {
        // Hier kannst du den Code einfügen, um die Produktinformationen anzuzeigen.
        // Das könnte z. B. ein Dialogfenster sein, das den Namen, die Eigenschaften usw. des Produkts anzeigt.
        System.out.println("Weitere Informationen für Seriennummer: " + serialNumber);
    }

    public static void main(String[] args) {
        Test example = new Test();
        example.setVisible(true);
    }
}

