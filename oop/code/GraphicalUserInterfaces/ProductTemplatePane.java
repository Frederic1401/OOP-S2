package oop.code.GraphicalUserInterfaces;

import code.Main;
import code.Products.Produkt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductTemplatePane extends Component {
    private JButton bearbeitenButton;
    private JButton entfernenButton;
    private JLabel productNummer;
    private JButton weitereInformationenButton;
    private JPanel bildPanel;
    private JPanel mainPanel;

    public ProductTemplatePane() {
        entfernenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Produkt currentProdukt = Main.getProduktManager().getProduktListe().get(Integer.parseInt(productNummer.getText()));
                JOptionPane.showMessageDialog(null,
                        "Das Produkt '"+currentProdukt.getName()+"' mit der Seriennummer: "+currentProdukt.getSeriennummer()+" wurde erfolgreich entfernt!",
                        "Mitteilung", JOptionPane.INFORMATION_MESSAGE);
                Main.getProduktManager().getProduktListe().remove(currentProdukt.getSeriennummer(), currentProdukt);
                Main.getMainFrame().updateContents();
            }
        });


        bearbeitenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Produkt currentProdukt = Main.getProduktManager().getProduktListe().get(Integer.parseInt(productNummer.getText()));
                new ProductCreatorFrame(Main.getProduktManager().transformKategorieIntoInteger(currentProdukt.getKategorie()),
                        currentProdukt.getName(), currentProdukt.getTechnischeDaten(), currentProdukt.getKaufempfehlung(),
                        currentProdukt.getJahrgang(), currentProdukt.getLieferzeit(), currentProdukt.getMengenbestand(),
                        currentProdukt.getSeriennummer(),
                        currentProdukt.getPreis(), currentProdukt.isImAngebot());
            }
        });
    }

    public JPanel getMainPanel(){ return mainPanel;}
    public JLabel getProductNummer() {return productNummer;}
}
