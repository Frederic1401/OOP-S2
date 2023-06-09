package oop.code.GraphicalUserInterfaces;

import code.Main;
import code.Products.Produkt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.HashMap;

public class MainFrame extends JFrame {
    private JButton produktErstellenButton;
    private JPanel mainPanel,
                   mainContentPanel,
                   contentPanel;

    private JMenuBar menuBar;
    private JMenu menuDatei, menuAnsicht, menuOptionen;

    private JMenuItem menuDatei_NeuesProdukt, menuDatei_Speichern,
                      menuAnsicht_ListenAnsicht, menuAnsicht_KachelAnsicht,
                      menuOptionen_Einstellungen;



    public MainFrame() {
        contentPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        setSize(960, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Produkt-Katalog");
        setVisible(true);

        produktErstellenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ProductCreatorFrame();
            }
        });

        mainContentPanel.add(new JScrollPane(contentPanel));

        setContentPane(mainPanel);
        loadMenuBar();
    }

    public void updateContents(){
        contentPanel.removeAll();
        HashMap<Integer, Produkt> produktListe = Main.getProduktManager().getProduktListe();
        for(Produkt produkte : produktListe.values()){
            ProductTemplatePane productTemplatePane = new ProductTemplatePane();
            productTemplatePane.getProductNummer().setText(String.valueOf(produkte.getSeriennummer()));
            productTemplatePane.getMainPanel().setName(produkte.getName());
            productTemplatePane.getMainPanel().setPreferredSize(new Dimension(350, 350));
            contentPanel.add(productTemplatePane.getMainPanel());
        }
        revalidate();
        repaint();
    }

    private void loadMenuBar(){
        menuBar = new JMenuBar();

        menuDatei = new JMenu("Datei");
        menuAnsicht = new JMenu("Ansicht");
        menuOptionen = new JMenu("Optionen");

        menuDatei_NeuesProdukt = new JMenuItem("Neues Produkt");
        menuDatei_Speichern = new JMenuItem("Speichern");
        menuAnsicht_ListenAnsicht = new JMenuItem("Listen-Ansicht");
        menuAnsicht_KachelAnsicht = new JMenuItem("Kachel-Ansicht");
        menuOptionen_Einstellungen = new JMenuItem("Einstellungen");

        menuDatei_NeuesProdukt.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        menuDatei_NeuesProdukt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ProductCreatorFrame();
            }
        });

        menuDatei.add(menuDatei_NeuesProdukt);
        menuDatei.add(menuDatei_Speichern);
        menuAnsicht.add(menuAnsicht_ListenAnsicht);
        menuAnsicht.add(menuAnsicht_KachelAnsicht);
        menuOptionen.add(menuOptionen_Einstellungen);

        menuBar.add(menuDatei);
        menuBar.add(menuAnsicht);
        menuBar.add(menuOptionen);

        setJMenuBar(menuBar);
    }
}
