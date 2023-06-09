package src;

import src.GraphicalUserInterfaces.MainFrame;
import src.Products.Produktkatalog;

import javax.swing.*;

public class Main {

    private static Produktkatalog produktkatalog;

    private static MainFrame mainFrame;

    public static void main(String[] args) {
        produktkatalog = new Produktkatalog();

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }
        mainFrame = new MainFrame();
    }

    public static Produktkatalog getProduktkatalog() {return produktkatalog;}
    public static MainFrame getMainFrame() {return mainFrame;}
}