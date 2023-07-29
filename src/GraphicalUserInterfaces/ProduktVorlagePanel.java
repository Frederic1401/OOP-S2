package src.GraphicalUserInterfaces;

import src.Main;
import src.Produkte.Produkt;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class ProduktVorlagePanel extends JPanel {

    private JPanel mainPanel, buttonPanel;
    private JLabel produktSeriennummerLabel, bildLabel;
    private JButton entfernenButton, bearbeitenButton;

    public ProduktVorlagePanel(Produkt currentProdukt) {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(400, 350));
        setBorder(new LineBorder(Color.GRAY, 1, false));
        //
        produktSeriennummerLabel = new JLabel(currentProdukt.getSeriennummer()+" | "+currentProdukt.getName());
        bildLabel = new JLabel();
        bildLabel.setIcon(Main.getProduktkatalog().getProduktBilderHashMap().get(currentProdukt));
        bildLabel.setBorder(new LineBorder(Color.GRAY, 1, true));
        buttonPanel = new JPanel();
        entfernenButton = new JButton("Entfernen");
        entfernenButton.addActionListener(entfernenButtonActionListener(currentProdukt));
        bearbeitenButton = new JButton("Bearbeiten");
        bearbeitenButton.addActionListener(bearbeitenButtonActionListener(currentProdukt));
        buttonPanel.add(entfernenButton);
        buttonPanel.add(bearbeitenButton);
        //
        add(produktSeriennummerLabel, BorderLayout.NORTH);
        add(bildLabel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private ActionListener bearbeitenButtonActionListener(Produkt currentProdukt) {
        return e -> {
            new ProduktCreatorFrame(currentProdukt);
        };
    }
    private ActionListener entfernenButtonActionListener(Produkt currentProdukt) {
        return e -> {
            Main.getProduktkatalog().removeProdukt(currentProdukt);
            Main.getMainFrame().kachelAnsichtGenerieren();
            Main.getMainFrame().baumAnsichtGenerieren();
            Main.getMainFrame().tabellenAnsichtGenerieren();
            JOptionPane.showMessageDialog(null,
                    "Das Produkt '"+currentProdukt.getName()+"' mit der Seriennummer: "+currentProdukt.getSeriennummer()+" wurde erfolgreich entfernt!",
                    "Mitteilung", JOptionPane.INFORMATION_MESSAGE);
        };
    }
}
