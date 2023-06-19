package src.GraphicalUserInterfaces;

import src.Main;
import src.Products.Produkt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductTemplatePane extends Component {
    private JButton bearbeitenButton;
    private JButton entfernenButton;
    private JLabel produktLabel;
    private JButton weitereInformationenButton;
    private JPanel bildPanel;
    private JPanel mainPanel;

    public ProductTemplatePane() {
        entfernenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Produkt currentProdukt = Main.getProduktkatalog().sucheProduktNachSeriennummer(produktLabel.getText().split("; ")[0]);
                Main.getProduktkatalog().removeProdukt(currentProdukt);
                Main.getMainFrame().updateContents();
                JOptionPane.showMessageDialog(null,
                        "Das Produkt '"+currentProdukt.getName()+"' mit der Seriennummer: "+currentProdukt.getSeriennummer()+" wurde erfolgreich entfernt!",
                        "Mitteilung", JOptionPane.INFORMATION_MESSAGE);
            }
        });


        bearbeitenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Produkt currentProdukt = Main.getProduktkatalog().sucheProduktNachSeriennummer(produktLabel.getText().split("; ")[0]);
                new ProductCreatorFrame(Main.getProduktkatalog().transformKategorieIntoInteger(currentProdukt.getKategorie()),
                        currentProdukt.getName(), currentProdukt.getBeschreibung(), currentProdukt.getKaufempfehlung(),
                        currentProdukt.getJahrgang(), currentProdukt.getLieferzeit(), currentProdukt.getMengenbestand(),
                        currentProdukt.getSeriennummer(),
                        currentProdukt.getPreis(), currentProdukt.isImAngebot());
            }
        });
    }

    public JPanel getMainPanel(){ return mainPanel;}
    public JLabel getProduktLabel() {return produktLabel;}
}
