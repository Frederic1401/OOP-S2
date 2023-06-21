package src.GraphicalUserInterfaces;

import src.Exceptions.InvalidProductAttributeException;
import src.Main;
import src.Products.Produkt;
import src.Products.Verwaltungsliste;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

public class ProductCreatorFrame extends JFrame{
    private JPanel mainPanel;
    private JLabel kategorieLabel;
    private JComboBox kategorieComboBox;
    private JLabel nameLabel;
    private JTextField nameTextField;
    private JLabel seriennummerLabel;
    private JTextField seriennummerTextField;
    private JButton speichernButton;
    private JLabel lieferzeitLabel;
    private JLabel mengenbestandLabel;
    private JLabel preisLabel;
    private JLabel jahrgangLabel;
    private JSpinner preisSpinner;
    private JComboBox jahrgangComboBox;
    private JLabel technischeDatenLabel;
    private JTextArea technischeDatenTextArea;
    private JButton bildHochladenButton;
    private JLabel kaufempfehlungLabel;
    private JComboBox kaufempfehlungComboBox;
    private JSpinner mengenbestandSpinner;
    private JSpinner lieferzeitSpinner;
    private JButton resetButton;
    private JCheckBox imAngebotCheckBox;
    private JPanel bildPanel;
    private JLabel bildLabel;

    public ProductCreatorFrame() {
        //Attribute des JFrames werden erstellt
        setContentPane(mainPanel);
        setSize(550, 600);
        setLocationRelativeTo(null);
        setTitle("Produkt anlegen");
        setVisible(true);

        loadCustomContents();

        speichernButton.addActionListener(saveButtonActionListener());
        resetButton.addActionListener(resetButtonActionListener());
        bildHochladenButton.addActionListener(imageButtonActionListener());
        kategorieComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Verwaltungsliste currentKategorie = Main.getKategorieNachNamen(kategorieComboBox.getSelectedItem().toString());
                seriennummerTextField.setText(currentKategorie.getIndex()+"00"+currentKategorie.getListe().size()+1);
            }
        });
    }


    /**
     * Dieser Konstruktor wird verwendet, um ein JFrame zu erstellen, welches dazu dient ein bestehendes Objekt der Klasse
     * Produkt zu bearbeiten
     * @param kategorieIndex
     * @param name
     * @param technischeDaten
     * @param kaufempfehlung
     * @param jahrgang
     * @param lieferzeit
     * @param mengenbestand
     * @param seriennummer
     * @param preis
     * @param imAngebot
     */
    public ProductCreatorFrame(int kategorieIndex, String name, String technischeDaten, Produkt kaufempfehlung,
                               int jahrgang, int lieferzeit, int mengenbestand, String seriennummer, double preis, boolean imAngebot){
        this.kategorieComboBox.setSelectedIndex(kategorieIndex);
        this.nameTextField.setText(name);
        this.technischeDatenTextArea.setText(technischeDaten);
        this.kaufempfehlungComboBox.setSelectedItem(kaufempfehlung != null ? kaufempfehlung.getName() : "-bitte Angeben-");
        this.jahrgangComboBox.setSelectedItem(jahrgang);
        this.lieferzeitSpinner.setValue(lieferzeit);
        this.mengenbestandSpinner.setValue(mengenbestand);
        this.seriennummerTextField.setText(String.valueOf(seriennummer));
        this.preisSpinner.setValue(preis);
        this.imAngebotCheckBox.setSelected(imAngebot);

        loadCustomContents();

        setContentPane(mainPanel);
        setSize(550, 600);
        setLocationRelativeTo(null);
        setTitle(name+" | Bearbeiten");
        setVisible(true);

        speichernButton.addActionListener(saveButtonActionListener());
        resetButton.addActionListener(resetButtonActionListener());
        bildHochladenButton.addActionListener(imageButtonActionListener());
    }

    private void loadCustomContents(){
        seriennummerTextField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9') ||
                        (c == KeyEvent.VK_BACK_SPACE) ||
                        (c == KeyEvent.VK_DELETE))) {
                    getToolkit().beep();
                    e.consume();
                }
            }
        });

        int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        jahrgangComboBox.addItem("-bitte Angeben-");
        for (int year = currentYear; year >= 1900; year--) {
            jahrgangComboBox.addItem(year);
        }

        kaufempfehlungComboBox.addItem("-bitte Angeben-");
        for(Produkt produkte : Main.getProduktkatalog().getListe()) {
            kaufempfehlungComboBox.addItem(produkte.getName());
        }
    }

    private ActionListener saveButtonActionListener(){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(jahrgangComboBox.getSelectedIndex() == 0){JOptionPane.showMessageDialog(null, "Fehler: Ungültiger Jahrgang", "Fehler", JOptionPane.ERROR_MESSAGE); return;}
                if(kategorieComboBox.getSelectedIndex() != 0){

                    //Attribute des neuen Produkts werden hergeleitet
                    String  kategorie = kategorieComboBox.getSelectedItem().toString(),
                            name = nameTextField.getText(),
                            technischeDaten = technischeDatenTextArea.getText();
                    Produkt kaufempfehlung = Main.getProduktkatalog().sucheProduktNachNamen(kaufempfehlungComboBox.getSelectedItem().toString());
                    System.out.println(jahrgangComboBox.getSelectedItem().toString());
                    int     jahrgang = (int) jahrgangComboBox.getSelectedItem(),
                            lieferzeit = Integer.parseInt(lieferzeitSpinner.getValue().toString()),
                            mengenbestand = Integer.parseInt(mengenbestandSpinner.getValue().toString()),
                            seriennummer = Integer.parseInt(seriennummerTextField.getText());
                    double preis = Double.parseDouble(preisSpinner.getValue().toString());
                    boolean imAngebot = imAngebotCheckBox.isSelected();
                    try {
                        if(kategorie.equalsIgnoreCase("Elektronik")){
                            Main.getElektronikListe().produktErzeugen(name, technischeDaten, kaufempfehlung, jahrgang, lieferzeit, mengenbestand, preis, imAngebot);
                        } else if (kategorie.equalsIgnoreCase("Küche")) {
                            Main.getKuecheListe().produktErzeugen(name, technischeDaten, kaufempfehlung, jahrgang, lieferzeit, mengenbestand, preis, imAngebot);
                        } else if (kategorie.equalsIgnoreCase("Badezimmer")) {
                            Main.getBadezimmerListe().produktErzeugen(name, technischeDaten, kaufempfehlung, jahrgang, lieferzeit, mengenbestand, preis, imAngebot);
                        }else if (kategorie.equalsIgnoreCase("Schlafzimmer")) {
                            Main.getSchlafzimmerListe().produktErzeugen(name, technischeDaten, kaufempfehlung, jahrgang, lieferzeit, mengenbestand, preis, imAngebot);
                        }else if(kategorie.equalsIgnoreCase("Wohnzimmer")){
                            Main.getWohnzimmerListe().produktErzeugen(name, technischeDaten, kaufempfehlung, jahrgang, lieferzeit, mengenbestand, preis, imAngebot);
                        }else if(kategorie.equalsIgnoreCase("Sonstiges")){
                            Main.getSonstigesListe().produktErzeugen(name, technischeDaten, kaufempfehlung, jahrgang, lieferzeit, mengenbestand, preis, imAngebot);
                        }
                        Main.getMainFrame().updateContents();
                        setVisible(false);
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
            }
        };
    }

    private ActionListener resetButtonActionListener(){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                kategorieComboBox.setSelectedIndex(0);
                nameTextField.setText(null);
                technischeDatenTextArea.setText(null);
                kaufempfehlungComboBox.setSelectedItem(0);
                jahrgangComboBox.setSelectedIndex(0);
                lieferzeitSpinner.setValue(0);
                mengenbestandSpinner.setValue(0);
                seriennummerTextField.setText(null);
                preisSpinner.setValue(0);
                imAngebotCheckBox.setSelected(false);
            }
        };
    }

    //erlaubt dem Nutzer, ein Bild von seinem lokalen Speicher auszuwählen, welches dann angezeigt wird
    private static String filePath;
    private ActionListener imageButtonActionListener(){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Nutzer kann Datei auswählen
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION){
                    // Dateipfad wird bestimmt
                    File selectedFile = fileChooser.getSelectedFile();
                    filePath = selectedFile.getAbsolutePath();

                    // ausgewähltes Bild ersetzt bildLabel
                    ImageIcon productImage = new ImageIcon(filePath);
                    bildLabel.setIcon(productImage);
                }

            }
        };
    }

    public static String getFilePath(){
        return filePath;
    }
}
