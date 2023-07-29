package src.GraphicalUserInterfaces;

import src.InvalidProductAttributeException;
import src.Main;
import src.Produkte.Kategorien.*;
import src.Produkte.Produkt;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class ProduktCreatorFrame extends JFrame {

    private JPanel mainContentPanel, mainEingabePanel, mainBildPanel, eingabePanel, beschreibungPanel, buttonPanel;
    private JLabel bildLabel,
            kategorieLabel, nameLabel, seriennummerLabel,
            mengenbestandLabel, lieferzeitLabel, preisLabel, jahrgangLabel,
            beschreibungLabel,
            empfehlungLabel, angebotLabel;
    private JComboBox kategorieComboBox, jahrgangComboBox, empfhelungComboBox;
    private JTextField nameTextField, seriennummerTextField;
    private JSpinner mengenbestandSpinner, lieferzeitSpinner, preisSpinner;
    private JTextArea beschreibungTextArea;
    private JButton bildHochladenButton, speichernButton, resetButton;
    private JCheckBox angebotCheckBox;

    public ProduktCreatorFrame(){
        super("Produkt-Erstellen");
        erstelleJFrameInhalte(null);
        erstelleComboBoxInhalte();
    }
    public ProduktCreatorFrame(Produkt produkt){
        super("Produkt-Erstellen");
        erstelleJFrameInhalte(produkt);
        erstelleComboBoxInhalte();
        bildLabel.setIcon(Main.getProduktkatalog().getProduktBilderHashMap().get(produkt));
        kategorieComboBox.setSelectedIndex(umwandelnVonKategorieZuID(produkt.getKategorie()));
        nameTextField.setText(produkt.getName());
        seriennummerTextField.setText(produkt.getSeriennummer());
        beschreibungTextArea.setText(produkt.getBeschreibung());
        int index = 0;
        for(int i=0; i<Main.getProduktkatalog().getListe().size(); i++){if (Main.getProduktkatalog().getListe().get(i) == produkt.getKaufempfehlung()){index = i;}}
        empfhelungComboBox.setSelectedIndex(index);
        mengenbestandSpinner.setValue(produkt.getMengenbestand());
        lieferzeitSpinner.setValue(produkt.getLieferzeit());
        preisSpinner.setValue(produkt.getPreis());
        jahrgangComboBox.setSelectedItem(""+produkt.getJahrgang());
        angebotCheckBox.setSelected(produkt.isImAngebot());
    }

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
        empfhelungComboBox = new JComboBox<>();
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
        eingabePanel.add(empfhelungComboBox);
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

    private void erstelleComboBoxInhalte() {
        kategorieComboBox.addItem("-bitte Angeben-");
        kategorieComboBox.addItem("Elektronik");
        kategorieComboBox.addItem("Küche");
        kategorieComboBox.addItem("Badezimmer");
        kategorieComboBox.addItem("Schlafzimmer");
        kategorieComboBox.addItem("Wohnzimmer");
        kategorieComboBox.addItem("Sonstiges");

        int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        jahrgangComboBox.addItem("-bitte Angeben-");
        for (int year = currentYear; year >= 1900; year--) {jahrgangComboBox.addItem(year+"");}
        empfhelungComboBox.addItem("-bitte Angeben-");
        for(Produkt produkte : Main.getProduktkatalog().getListe()) {empfhelungComboBox.addItem(produkte.getSeriennummer()+" | "+produkte.getName());}
    }

    private int umwandelnVonKategorieZuID(String kategorie){
        if(kategorie.equals("Elektronik")){
            return 1;
        }else if (kategorie.equals("Küche")){
            return 2;
        } else if (kategorie.equals("Badezimmer")){
            return 3;
        }else if (kategorie.equals("Schlafzimmer")){
            return 4;
        }else if (kategorie.equals("Wohnzimmer")){
            return 5;
        }else if (kategorie.equals("Sonstiges")){
            return 6;
        }
        return 0;
    }

    private ActionListener kategorieComboBoxActionListener(){
        return e -> {
            if(kategorieComboBox.getSelectedIndex() != 0){
                int index = 0;
                int anzahl = 0;
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

    private ActionListener bildHochladenButtonActionListener(){
        return e -> {
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(null);
            // Nutzer kann Datei auswählen
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                try {
                    // Dateipfad wird bestimmt
                    Image backgroundImage = ImageIO.read(selectedFile);
                    ImageIcon icon = new ImageIcon(backgroundImage);
                    // Skaliere das Bild auf die Größe des JLabels
                    Image scaledImage = icon.getImage().getScaledInstance(bildLabel.getWidth(), bildLabel.getHeight(), Image.SCALE_SMOOTH);
                    icon = new ImageIcon(scaledImage);
                    bildLabel.setIcon(icon);
                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Fehler beim Laden des Bildes.", "Fehler", JOptionPane.ERROR_MESSAGE);
                }
            }
        };
    }

    private ActionListener speichernButtonActionListener(Produkt altesProdukt){
        return e -> {
            if(jahrgangComboBox.getSelectedIndex() == 0){JOptionPane.showMessageDialog(null, "Fehler: Ungültiger Jahrgang", "Fehler", JOptionPane.ERROR_MESSAGE); return;}
            if(kategorieComboBox.getSelectedIndex() != 0){

                //Attribute des neuen Produkts werden hergeleitet
                String  kategorie = kategorieComboBox.getSelectedItem().toString(),
                        name = nameTextField.getText(),
                        technischeDaten = beschreibungTextArea.getText();
                Produkt kaufempfehlung = Main.getProduktkatalog().sucheProduktNachSeriennummer(empfhelungComboBox.getSelectedItem().toString().split(" | ")[0]);
                int     jahrgang = Integer.valueOf((String) jahrgangComboBox.getSelectedItem()),
                        lieferzeit = Integer.parseInt(lieferzeitSpinner.getValue().toString()),
                        mengenbestand = Integer.parseInt(mengenbestandSpinner.getValue().toString());
                double preis = Double.parseDouble(preisSpinner.getValue().toString());
                boolean imAngebot = angebotCheckBox.isSelected();
                try {
                    Produkt produkt = null;
                    if(kategorie.equalsIgnoreCase("Elektronik")){
                        if(altesProdukt!=null){Main.getElektronikListe().removeProdukt((ElektronikProdukt) altesProdukt);}
                        produkt = Main.getElektronikListe().produktErzeugen(name, technischeDaten, kaufempfehlung, jahrgang, lieferzeit, mengenbestand, preis, imAngebot);
                    } else if (kategorie.equalsIgnoreCase("Küche")) {
                        if(altesProdukt!=null){Main.getKuecheListe().removeProdukt((KuecheProdukt) altesProdukt);}
                        produkt = Main.getKuecheListe().produktErzeugen(name, technischeDaten, kaufempfehlung, jahrgang, lieferzeit, mengenbestand, preis, imAngebot);
                    } else if (kategorie.equalsIgnoreCase("Badezimmer")) {
                        if(altesProdukt!=null){Main.getBadezimmerListe().removeProdukt((BadezimmerProdukt) altesProdukt);}
                        produkt = Main.getBadezimmerListe().produktErzeugen(name, technischeDaten, kaufempfehlung, jahrgang, lieferzeit, mengenbestand, preis, imAngebot);
                    }else if (kategorie.equalsIgnoreCase("Schlafzimmer")) {
                        if(altesProdukt!=null){Main.getSchlafzimmerListe().removeProdukt((SchlafzimmerProdukt) altesProdukt);}
                        produkt = Main.getSchlafzimmerListe().produktErzeugen(name, technischeDaten, kaufempfehlung, jahrgang, lieferzeit, mengenbestand, preis, imAngebot);
                    }else if(kategorie.equalsIgnoreCase("Wohnzimmer")){
                        if(altesProdukt!=null){Main.getWohnzimmerListe().removeProdukt((WohnzimmerProdukt) altesProdukt);}
                        produkt = Main.getWohnzimmerListe().produktErzeugen(name, technischeDaten, kaufempfehlung, jahrgang, lieferzeit, mengenbestand, preis, imAngebot);
                    }else if(kategorie.equalsIgnoreCase("Sonstiges")){
                        if(altesProdukt!=null){Main.getSonstigesListe().removeProdukt((SonstigesProdukt) altesProdukt);}
                        produkt = Main.getSonstigesListe().produktErzeugen(name, technischeDaten, kaufempfehlung, jahrgang, lieferzeit, mengenbestand, preis, imAngebot);
                    }
                    if(altesProdukt!=null){Main.getProduktkatalog().removeProdukt(altesProdukt);}
                    Main.getProduktkatalog().getProduktBilderHashMap().put(produkt, (ImageIcon) bildLabel.getIcon());

                    Main.getMainFrame().kachelAnsichtGenerieren();
                    Main.getMainFrame().baumAnsichtGenerieren();
                    Main.getMainFrame().tabellenAnsichtGenerieren();
                    dispose();
                } catch (InvalidProductAttributeException ex) {
                    JOptionPane.showMessageDialog(null, "Fehler: "+ex.getMessage(), "Fehler", JOptionPane.ERROR_MESSAGE);
                    if(lieferzeit <= 0) lieferzeitSpinner.setValue(0);
                    if(mengenbestand <= 0) mengenbestandSpinner.setValue(0);
                    if(preis <= 0) preisSpinner.setValue(0);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Fehler: Ungültige Kategorie", "Fehler", JOptionPane.ERROR_MESSAGE);
            }
        };
    }

    private ActionListener resetButtonActionListener(){
        return e -> {
            kategorieComboBox.setSelectedIndex(0);
            nameTextField.setText(null);
            beschreibungTextArea.setText(null);
            empfhelungComboBox.setSelectedItem(0);
            jahrgangComboBox.setSelectedIndex(0);
            lieferzeitSpinner.setValue(0);
            mengenbestandSpinner.setValue(0);
            seriennummerTextField.setText(null);
            preisSpinner.setValue(0);
            angebotCheckBox.setSelected(false);
        };
    }
}
