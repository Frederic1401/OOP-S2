package src.GraphicalUserInterfaces;

import src.InvalidProductAttributeException;
import src.Main;
import src.Produkte.Produkt;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * Package 'src.GraphicalUserInterfaces'
 *
 * Zweck: JFrame, das als GUI für die Erstellung eines neuen oder bestehenden Produktes dienen soll.
 * @author: Frederic Oetgen, Hanno Schulz
 * @version: 16.06.2023
 * Historie: 16.06.2023, Erstellung der Klasse
 */
public class ProduktCreatorFrame extends JFrame {

    private JPanel mainContentPanel, mainEingabePanel, mainBildPanel, eingabePanel, beschreibungPanel, buttonPanel; //Die benötigten JPanels
    private JLabel bildLabel,
            kategorieLabel, nameLabel, seriennummerLabel, empfehlungLabel, //Die JLabels, die dem 'eingabePanel' zugewiesen werden.
            angebotLabel, mengenbestandLabel, lieferzeitLabel, preisLabel, jahrgangLabel, //Die JLabels, die dem 'eingabePanel' zugewiesen werden.
            beschreibungLabel; //Das JLabel, das dem 'beschreibungPanel' zugewiesen wird.
    private JComboBox kategorieComboBox, jahrgangComboBox, empfehlungComboBox; //Die JComboBoxen, die dem 'eingabePanel' zugewiesen werden.
    private JTextField nameTextField, seriennummerTextField; //Die JTextFields, die dem 'eingabePanel' zugewiesen werden.
    private JSpinner mengenbestandSpinner, lieferzeitSpinner, preisSpinner; //Die JSpinner, die dem 'eingabePanel' zugewiesen werden.
    private JTextArea beschreibungTextArea; //Die JTextArea, die dem 'beschreibungPanel' zugewiesen werden.
    private JButton bildHochladenButton, speichernButton, resetButton; //Die JButtons, die dem 'mainBildPanel' und dem 'buttonPanel' zugewiesen werden.
    private JCheckBox angebotCheckBox; //Die JCheckBox, die dem 'eingabePanel' zugewiesen werden.

    /**
     * Der reguläre Constructor, um ein neues Produkt zu erstellen.
     */
    public ProduktCreatorFrame(){
        super("Produkt-Erstellen");
        //Es werden die einzelnen JLabels, JPanels etc. über die Methode initialisiert.
        //Da hier ein 'ProductCreatorFrame' dazu genutzt wird, ein neues Produkt zu erstellen, beträgt das übergebene Produkt null.
        erstelleJFrameInhalte(null);
        //Die JComboBoxen werden mit Inhalten ausgestattet.
        erstelleComboBoxInhalte();
    }

    /**
     * Der Constructor, um ein bestehendes Produkt zu überarbeiten.
     * @param produkt, das Produkt, das in einem 'ProduktCreatorFrame' bearbeitet werden soll.
     */
    public ProduktCreatorFrame(Produkt produkt){
        super("Produkt-Erstellen");
        //Es werden die einzelnen JLabels, JPanels etc. über die Methode initialisiert.
        erstelleJFrameInhalte(produkt);
        //Die JComboBoxen werden mit Inhalten ausgestattet.
        erstelleComboBoxInhalte();
        //Die einzelnen Attribut-Eingabefelder erhalten Werte entsprechend dem übergebenen Produkt.
        bildLabel.setIcon(produkt.getBild());
        kategorieComboBox.setSelectedIndex(umwandelnVonKategorieZuID(produkt.getKategorie()));
        nameTextField.setText(produkt.getName());
        seriennummerTextField.setText(produkt.getSeriennummer());
        beschreibungTextArea.setText(produkt.getBeschreibung());
        //Es wird einmal der gesamte Produktkatalog durchlaufen, um die Position eines Produktes herauszufinden.
        int index = 0;
        for(int i=0; i<Main.getProduktkatalog().getListe().size(); i++){
            //Es wird überprüft, ob das übertragene Produkt mit dem Produkt an der Stelle 'i' übereinstimmt.
            if (Main.getProduktkatalog().getListe().get(i) == produkt.getKaufempfehlung()){
                index = i;
            }
        }
        //Die restlichen Attribut-Eingabefelder werden angepasst.
        empfehlungComboBox.setSelectedIndex(index);
        mengenbestandSpinner.setValue(produkt.getMengenbestand());
        lieferzeitSpinner.setValue(produkt.getLieferzeit());
        preisSpinner.setValue(produkt.getPreis());
        jahrgangComboBox.setSelectedItem(""+produkt.getJahrgang());
        angebotCheckBox.setSelected(produkt.isImAngebot());
    }

    /**
     * Es werden die einzelnen Inhalte des JFrames initialisiert und angepasst.
     * @param currentProdukt, das Produkt das beim speichernButton übergben wird, um ggf. das alte Produkt zu entfernen.
     */
    private void erstelleJFrameInhalte(Produkt currentProdukt){
        //Zu Beginn werden die Attribute des JFrames definiert.
        setSize(700, 800);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        //Die einzelnen Components des 'mainBildPanel's werden initialisiert.
        bildLabel = new JLabel();
        bildLabel.setBorder(new LineBorder(Color.BLACK, 1));
        bildHochladenButton = new JButton("Bild hochladen");
        bildHochladenButton.setSize(100, 50);
        bildHochladenButton.addActionListener(bildHochladenButtonActionListener());
        //Die einzelnen Components des 'eingabePanels' werden initialisiert.
        kategorieLabel = new JLabel("Kategorie:");
        nameLabel = new JLabel("Produktname:");
        seriennummerLabel = new JLabel("Seriennummer:");
        mengenbestandLabel = new JLabel("Mengenbestand:");
        lieferzeitLabel = new JLabel("Lieferzeit:");
        preisLabel = new JLabel("Preis:");
        jahrgangLabel = new JLabel("Jahrgang:");
        angebotLabel = new JLabel("Im Angebot");
        empfehlungLabel = new JLabel("Kaufempfehlung: ");
        kategorieComboBox = new JComboBox<>();
        kategorieComboBox.addActionListener(kategorieComboBoxActionListener());
        jahrgangComboBox = new JComboBox<>();
        nameTextField = new JTextField();
        seriennummerTextField = new JTextField();
        seriennummerTextField.setEditable(false);
        mengenbestandSpinner = new JSpinner();
        lieferzeitSpinner = new JSpinner();
        preisSpinner = new JSpinner();
        angebotCheckBox = new JCheckBox();
        empfehlungComboBox = new JComboBox<>();
        //Die JTextArea des 'beschreibungPanel's wird erstellt.
        beschreibungLabel = new JLabel("Technische Daten:");
        beschreibungTextArea = new JTextArea();
        //Der 'Speichern' und 'Reset' JButton werden initialisiert und ihnen werden ActionListener zugewiesen.
        speichernButton = new JButton("Speichern");
        speichernButton.setSize(100, 50);
        speichernButton.addActionListener(speichernButtonActionListener(currentProdukt));
        resetButton = new JButton("Reset");
        resetButton.setSize(100, 50);
        resetButton.addActionListener(resetButtonActionListener());
        //Das 'mainBildPanel' wird initialisiert und die entsprechenden Components werden ihm zugewiesen.
        mainBildPanel = new JPanel(new BorderLayout());
        mainBildPanel.add(bildLabel, BorderLayout.CENTER);
        mainBildPanel.add(bildHochladenButton, BorderLayout.SOUTH);
        //Das 'eingabePanel' wird initialisiert und die entsprechenden Components werden ihm zugewiesen.
        eingabePanel = new JPanel(new GridLayout(9, 2));
        eingabePanel.add(kategorieLabel);
        eingabePanel.add(kategorieComboBox);
        eingabePanel.add(nameLabel);
        eingabePanel.add(nameTextField);
        eingabePanel.add(seriennummerLabel);
        eingabePanel.add(seriennummerTextField);
        eingabePanel.add(empfehlungLabel);
        eingabePanel.add(empfehlungComboBox);
        eingabePanel.add(mengenbestandLabel);
        eingabePanel.add(lieferzeitLabel);
        eingabePanel.add(mengenbestandSpinner);
        eingabePanel.add(lieferzeitSpinner);
        eingabePanel.add(preisLabel);
        eingabePanel.add(jahrgangLabel);
        eingabePanel.add(preisSpinner);
        eingabePanel.add(jahrgangComboBox);
        eingabePanel.add(angebotLabel);
        eingabePanel.add(angebotCheckBox);
        //Das 'beschreibungPanel' wird initialisiert und die entsprechenden Components werden ihm zugewiesen.
        beschreibungPanel = new JPanel(new BorderLayout());
        beschreibungPanel.add(beschreibungLabel, BorderLayout.NORTH);
        beschreibungPanel.add(beschreibungTextArea, BorderLayout.CENTER);
        //Das 'buttonPanel' wird initialisiert und die entsprechenden Components werden ihm zugewiesen.
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 40, 20));
        buttonPanel.add(speichernButton);
        buttonPanel.add(resetButton);
        //Das 'mainEingabePanel' wird initialisiert und die entsprechenden Components werden ihm zugewiesen.
        mainEingabePanel = new JPanel(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.insets = new Insets(10, 10,10,10);
        gridBagConstraints.weightx = 1;
        gridBagConstraints.weighty = 1;
        mainEingabePanel.add(mainBildPanel, gridBagConstraints);
        gridBagConstraints.gridx = 1;
        mainEingabePanel.add(eingabePanel, gridBagConstraints);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 1;
        gridBagConstraints.weightx = 2;
        gridBagConstraints.weighty = 2;
        mainEingabePanel.add(beschreibungPanel, gridBagConstraints);
        //Das Haupt JPanel des JFrames wird initialisiert und ihm werden die zuvor generierten JPanels zugewiesen.
        mainContentPanel = new JPanel(new BorderLayout());
        mainContentPanel.add(mainEingabePanel, BorderLayout.CENTER);
        mainContentPanel.add(buttonPanel, BorderLayout.SOUTH);
        setContentPane(mainContentPanel);
    }

    /**
     * Die einzelnen JComboBoxen, die in diesem JFrame benutzt werden, werden ihre entsprechenden Inhalte zugewiesen.
     */
    private void erstelleComboBoxInhalte() {
        //Die Inhalte der 'kategorieComboBox' werden erstellt in der Reihenfolge der Indexe der Kategorie.
        kategorieComboBox.addItem("-bitte Angeben-");
        kategorieComboBox.addItem("Elektronik");
        kategorieComboBox.addItem("Küche");
        kategorieComboBox.addItem("Badezimmer");
        kategorieComboBox.addItem("Schlafzimmer");
        kategorieComboBox.addItem("Wohnzimmer");
        kategorieComboBox.addItem("Sonstiges");
        //Die Inhalte der 'jahrgangComboBox' werden erstellt in absteigender Reihenfolge beginnend mit dem jüngsten Jahr.
        int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        jahrgangComboBox.addItem("-bitte Angeben-");
        for (int year = currentYear; year >= 1900; year--) {jahrgangComboBox.addItem(year+"");}
        //Die Inhalte der 'empfehlungComboBox' werden erstellt in der Reihenfolge des Produktkataloges.
        empfehlungComboBox.addItem("-bitte Angeben-");
        for(Produkt produkte : Main.getProduktkatalog().getListe()) {
            empfehlungComboBox.addItem(produkte.getSeriennummer()+" | "+produkte.getName());}
    }

    /**
     * Diese Methode dient dazu, für zu bearbeitende Produkte, den zu selektierenden Index zu ermitteln.
     * @param kategorie Die Kategorie, dessen Index ermittelt werden soll.
     * @return Zwischen 1 und 6: Der Index der übermittelten Kategorie von den existierenden Kategorien.
     * <p> 0: Die übermittelte Kategorie existiert nicht.
     */
    private int umwandelnVonKategorieZuID(String kategorie){
        //Mittels Abfragen wird der Index der übermittelten Kategorie bestimmt.
        if(kategorie.equals("Elektronik")){return Main.getElektronikListe().getIndex();
        }else if (kategorie.equals("Küche")){return Main.getKuecheListe().getIndex();
        }else if (kategorie.equals("Badezimmer")){return Main.getBadezimmerListe().getIndex();
        }else if (kategorie.equals("Schlafzimmer")){return Main.getSchlafzimmerListe().getIndex();
        }else if (kategorie.equals("Wohnzimmer")){return Main.getWohnzimmerListe().getIndex();
        }else if (kategorie.equals("Sonstiges")){return Main.getSonstigesListe().getIndex();
        }
        //Falls die übermittelte Kategorie nicht den bereits existierenden Kategorien entspricht, wird 0 zurückgegeben.
        return 0;
    }

    /**
     * Beim Auswählen einer Kategorie soll die künftige Seriennummer im entsprechenden JTextField angezeigt werden.
     * @return Der ActionListener der kategorieComboBox.
     */
    private ActionListener kategorieComboBoxActionListener(){
        return e -> {
            //Es wird zunächst überprüft, dass die ausgewählte Kategorie nicht "-bitte Angeben-" beträgt.
            if(kategorieComboBox.getSelectedIndex() != 0){
                //Nun werden die entsprechenden Seriennummern ermittelt, falls ein Produkt in der jeweiligen Kategorie eingeordnet wird.
                int index = 0; //Der Index der Kategorie.
                int anzahl = 0; //Die Anzahl der bereits existierenden Produkten in dieser Kategorie.
                if(kategorieComboBox.getSelectedIndex() == 1){
                    index = Main.getElektronikListe().getIndex();
                    anzahl = Main.getElektronikListe().getListe().size()+1;
                }else if(kategorieComboBox.getSelectedIndex() == 2){
                    index = Main.getKuecheListe().getIndex();
                    anzahl = Main.getKuecheListe().getListe().size()+1;
                }else if(kategorieComboBox.getSelectedIndex() == 3){
                    index = Main.getBadezimmerListe().getIndex();
                    anzahl = Main.getBadezimmerListe().getListe().size()+1;
                }else if(kategorieComboBox.getSelectedIndex() == 4){
                    index = Main.getSchlafzimmerListe().getIndex();
                    anzahl = Main.getSchlafzimmerListe().getListe().size()+1;
                }else if(kategorieComboBox.getSelectedIndex() == 5){
                    index = Main.getWohnzimmerListe().getIndex();
                    anzahl = Main.getWohnzimmerListe().getListe().size()+1;
                }else if(kategorieComboBox.getSelectedIndex() == 6){
                    index = Main.getSonstigesListe().getIndex();
                    anzahl = Main.getSonstigesListe().getListe().size()+1;
                }
                seriennummerTextField.setText(String.format("%02d", index)+String.format("%03d", anzahl));
            }else{
                seriennummerTextField.setText("0000");
            }
        };
    }

    /**
     * Es wird ein Bild einem Produkt zugewiesen und das JLabel im 'ProduktCreatorFrame' zeigt dieses an.
     * @return Der ActionListener für den 'bildHochladenButton'.
     */
    private ActionListener bildHochladenButtonActionListener(){
        return e -> {
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(null);
            //Nutzer kann Datei auswählen
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                //Es wird versucht ein Bild auszuwählen.
                try {
                    //Dateipfad wird bestimmt
                    Image backgroundImage = ImageIO.read(selectedFile);
                    ImageIcon icon = new ImageIcon(backgroundImage);
                    //Das Bild wird auf die Größe des JLabels skaliert.
                    Image scaledImage = icon.getImage().getScaledInstance(bildLabel.getWidth(), bildLabel.getHeight(), Image.SCALE_SMOOTH);
                    icon = new ImageIcon(scaledImage);
                    bildLabel.setIcon(icon);
                //Falls ein Fehler beim Auslesen der ausgewählten Datei entsteht, wird eine Exception ausgelöst.
                } catch (IOException ex) {
                    //Der Nutzer wird auf einen Fehler bei der Eingabe hingewiesen.
                    JOptionPane.showMessageDialog(null, "Fehler beim Laden des Bildes.", "Fehler", JOptionPane.ERROR_MESSAGE);
                }
            }
        };
    }

    /**
     * Es wird ein neues Produkt erstellt und gespeichert. Sofern ein Produkt bearbeitet wird, wird das ursprüngliche entfernt und das neue Produkt gespeichert.
     * @param altesProdukt, sofern kein Produkt überarbeitet wird, soll dieser Parameter null betragen.
     * @return Der ActionListener für den 'speichernButton'.
     */
    private ActionListener speichernButtonActionListener(Produkt altesProdukt){
        return e -> {
            //Es wird überprüft, ob die Eingabefelder nicht zu Problemen im Erschaffungsprozess des Produktes führen.
            if(jahrgangComboBox.getSelectedIndex() == 0){JOptionPane.showMessageDialog(null, "Fehler: Ungültiger Jahrgang", "Fehler", JOptionPane.ERROR_MESSAGE); return;}
            if(kategorieComboBox.getSelectedIndex() != 0){
                //Attribute des neuen Produkts werden hergeleitet.
                String  kategorie = kategorieComboBox.getSelectedItem().toString(),
                        name = nameTextField.getText(),
                        technischeDaten = beschreibungTextArea.getText();
                Produkt kaufempfehlung = Main.getProduktkatalog().sucheProduktNachSeriennummer(empfehlungComboBox.getSelectedItem().toString().split(" | ")[0]);
                int     jahrgang = Integer.valueOf((String) jahrgangComboBox.getSelectedItem()),
                        lieferzeit = Integer.parseInt(lieferzeitSpinner.getValue().toString()),
                        mengenbestand = Integer.parseInt(mengenbestandSpinner.getValue().toString());
                double preis = Double.parseDouble(preisSpinner.getValue().toString());
                boolean imAngebot = angebotCheckBox.isSelected();
                //Es wird ein Produkt der entsprechenden Kategorie versucht zu erstellen.
                try {
                    Produkt produkt = null;
                    String altSeriennummer = "",
                            altKategorie = "";
                    //Sofern ein Produkt überarbeitet wird, wird das alte Produkt entfernt und die alte Seriennummer beibehalten.
                    if(altesProdukt != null){
                        altSeriennummer = altesProdukt.getSeriennummer();
                        altKategorie = altesProdukt.getKategorie();
                        Main.getProduktkatalog().produktEntfernen(altesProdukt);
                    }
                    //Entsprechend der Kategorie
                    if(kategorie.equalsIgnoreCase("Elektronik")){
                        produkt = Main.getElektronikListe().produktErzeugen(name, technischeDaten, kaufempfehlung, jahrgang, lieferzeit, mengenbestand, preis, imAngebot);
                    } else if (kategorie.equalsIgnoreCase("Küche")) {
                        produkt = Main.getKuecheListe().produktErzeugen(name, technischeDaten, kaufempfehlung, jahrgang, lieferzeit, mengenbestand, preis, imAngebot);
                    } else if (kategorie.equalsIgnoreCase("Badezimmer")) {
                        produkt = Main.getBadezimmerListe().produktErzeugen(name, technischeDaten, kaufempfehlung, jahrgang, lieferzeit, mengenbestand, preis, imAngebot);
                    }else if (kategorie.equalsIgnoreCase("Schlafzimmer")) {
                        produkt = Main.getSchlafzimmerListe().produktErzeugen(name, technischeDaten, kaufempfehlung, jahrgang, lieferzeit, mengenbestand, preis, imAngebot);
                    }else if(kategorie.equalsIgnoreCase("Wohnzimmer")){
                        produkt = Main.getWohnzimmerListe().produktErzeugen(name, technischeDaten, kaufempfehlung, jahrgang, lieferzeit, mengenbestand, preis, imAngebot);
                    }else if(kategorie.equalsIgnoreCase("Sonstiges")){
                        produkt = Main.getSonstigesListe().produktErzeugen(name, technischeDaten, kaufempfehlung, jahrgang, lieferzeit, mengenbestand, preis, imAngebot);
                    }
                    //Falls die Kategorie beim überarbeiteten Produkt gleich bleibt wird die alte Seriennummer beibehalten
                    if(altesProdukt != null && kategorie.equalsIgnoreCase(altKategorie)){produkt.setSeriennummer(altSeriennummer);}
                    //Das angegebene Bild wird dem Produkt zugeordnet.
                    produkt.setBild((ImageIcon) bildLabel.getIcon());
                    //Sämtliche Ansichten werden aktualisiert.
                    Main.getMainFrame().kachelAnsichtGenerieren();
                    Main.getMainFrame().baumAnsichtGenerieren();
                    Main.getMainFrame().tabellenAnsichtGenerieren();
                    //Abschließend wird das Fenster geschlossen.
                    dispose();
                //Falls eine der Eingabefelder zu Problemen im Erschaffungsprozess des Produktes führen würde, wird eine Exception ausgelöst.
                } catch (InvalidProductAttributeException ex) {
                    //Der Nutzer wird auf einen Fehler bei der Eingabe hingewiesen.
                    JOptionPane.showMessageDialog(null, "Fehler: "+ex.getMessage(), "Fehler", JOptionPane.ERROR_MESSAGE);
                    //Bei negativen Zahleneingaben werden diese auf 0 gesetzt.
                    if(lieferzeit < 0) lieferzeitSpinner.setValue(0);
                    if(mengenbestand < 0) mengenbestandSpinner.setValue(0);
                    if(preis < 0) preisSpinner.setValue(0);
                }
            }else{
                //Der Nutzer wird auf einen Fehler bei der Eingabe hingewiesen.
                JOptionPane.showMessageDialog(null, "Fehler: Ungültige Kategorie", "Fehler", JOptionPane.ERROR_MESSAGE);
            }
        };
    }

    /**
     * Die Werte der einzelnen Attribut-Eingabefelder werden auf standardmäßigen zurückgesetzt.
     * @return Der ActionListener für den 'resetButton'.
     */
    private ActionListener resetButtonActionListener(){
        return e -> {
            //Die Werte der einzelnen Attribut-Eingabefelder werden auf standardmäßigen zurückgesetzt.
            kategorieComboBox.setSelectedIndex(0);
            nameTextField.setText(null);
            beschreibungTextArea.setText(null);
            empfehlungComboBox.setSelectedItem(0);
            jahrgangComboBox.setSelectedIndex(0);
            lieferzeitSpinner.setValue(0);
            mengenbestandSpinner.setValue(0);
            seriennummerTextField.setText(null);
            preisSpinner.setValue(0);
            angebotCheckBox.setSelected(false);
        };
    }
}
