package src.GraphicalUserInterfaces;

import src.Main;
import src.Produkte.Produkt;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Package 'src.GraphicalUserInterfaces'
 *
 * Zweck: JPanel, das in der Kachel-Ansicht ein Produkt abbilden soll und die Möglichkeit des Bearbeitens oder Entferns bietet.
 * @author: Frederic Oetgen, Hanno Schulz
 * @version: 07.07.2023
 * Historie: 16.06.2023, Erstellung der Klasse
 *           07.07.2023, Überarbeitung der Bilddarstellung
 */
public class ProduktVorlagePanel extends JPanel {

    private JPanel buttonPanel; //Das JPanel, dem die Buttons zugewiesen werden.
    private JLabel produktSeriennummerLabel, bildLabel; //Die JLabels, die diesem Label zugewiesen werden.
    private JButton entfernenButton, bearbeitenButton; //Die benötigten JButtons.

    /**
     * Das JLabel, das das entsprechende Produkt-Bild darstellt und die Möglichkeit bietet, ein Produkt zu bearbeiten oder zu löschen.
     * @param currentProdukt, das Produkt, für das ein ProduktPanel erstellt werden soll.
     */
    public ProduktVorlagePanel(Produkt currentProdukt) {
        //Zu Beginn werden die Attribute des JPanels definiert.
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(400, 350));
        setBorder(new LineBorder(Color.GRAY, 1, false));
        //Die einzelnen JLabels und ihre Inhalte werden initialisiert und angepasst.
        produktSeriennummerLabel = new JLabel(currentProdukt.getSeriennummer()+" | "+currentProdukt.getName());
        bildLabel = new JLabel();
        bildLabel.setIcon(currentProdukt.getBild());
        bildLabel.setBorder(new LineBorder(Color.GRAY, 1, true));
        buttonPanel = new JPanel();
        entfernenButton = new JButton("Entfernen");
        entfernenButton.addActionListener(entfernenButtonActionListener(currentProdukt));
        bearbeitenButton = new JButton("Bearbeiten");
        bearbeitenButton.addActionListener(bearbeitenButtonActionListener(currentProdukt));
        buttonPanel.add(entfernenButton);
        buttonPanel.add(bearbeitenButton);
        //Die erstellten Labels werden zugewiesen.
        add(produktSeriennummerLabel, BorderLayout.NORTH);
        add(bildLabel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    /**
     * Es wird ein neues 'ProduktCreatorFrame' initialisiert, um ein bestehendes Produkt zu bearbeiten.
     * @param currentProdukt, das Produkt, das überarbeitet werden soll.
     * @return Der ActionListener des bearbeitenButtons.
     */
    private ActionListener bearbeitenButtonActionListener(Produkt currentProdukt) {
        return e -> {
            //Ein ProduktCreatorFrame wird mit dem bestehen Produkt initialisiert.
            new ProduktCreatorFrame(currentProdukt);
        };
    }

    /**
     * Es wird ein bestehendes Produkt aus dem Produktkatalog entfernt.
     * @param currentProdukt, das Produkt, das entfernt werden soll.
     * @return Der ActionListener des entfernenButtons.
     */
    private ActionListener entfernenButtonActionListener(Produkt currentProdukt) {
        return e -> {
            //Das Produkt wird entfernt.
            Main.getProduktkatalog().produktEntfernen(currentProdukt);
            //Sämtliche Ansichten werden aktualisiert.
            Main.getMainFrame().kachelAnsichtGenerieren();
            Main.getMainFrame().baumAnsichtGenerieren();
            Main.getMainFrame().tabellenAnsichtGenerieren();
            //Dem Nutzer wird das Entfernen des Produkts bestätigt.
            JOptionPane.showMessageDialog(null,
                    "Das Produkt '"+currentProdukt.getName()+"' mit der Seriennummer: "+currentProdukt.getSeriennummer()+" wurde erfolgreich entfernt!",
                    "Mitteilung", JOptionPane.INFORMATION_MESSAGE);
        };
    }
}
