package oop.code;

import code.GraphicalUserInterfaces.MainFrame;
import code.Products.ProduktManager;

import javax.swing.*;

public class Main {

    private static ProduktManager produktManager;

    private static MainFrame mainFrame;

    public static void main(String[] args) {
        produktManager = new ProduktManager();

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

    public static ProduktManager getProduktManager() {return produktManager;}
    public static MainFrame getMainFrame() {return mainFrame;}
}