package src.GraphicalUserInterfaces;

import src.Main;
import src.Products.Produkt;
import src.Products.Verwaltungsliste;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ProductCreatorFrame extends JFrame{

    private JPanel mainPanel;
    private JLabel kategorieLabel;
    private JComboBox kategorieComboBox;
    private JLabel nameLabel;
    private JPanel bildPanel;
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
        for (int year = 1900; year <= currentYear; year++) {
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
                //Attribute des neuen Produkts werden hergeleitet
                String  kategorie = kategorieComboBox.getSelectedItem().toString(),
                        name = nameTextField.getText(),
                        technischeDaten = technischeDatenTextArea.getText();
                Produkt kaufempfehlung = Main.getProduktkatalog().sucheProduktNachNamen(kaufempfehlungComboBox.getSelectedItem().toString());
                System.out.println(jahrgangComboBox.getSelectedItem().toString());
                int     jahrgang,
                        lieferzeit = Integer.parseInt(lieferzeitSpinner.getValue().toString()),
                        menegenbestand = Integer.parseInt(mengenbestandSpinner.getValue().toString()),
                        seriennummer = Integer.parseInt(seriennummerTextField.getText());
                double preis = Double.parseDouble(preisSpinner.getValue().toString());
                boolean imAngebot = imAngebotCheckBox.isSelected();

                //Neues Produkt wird erstellt und der Liste aller Produkte hinzugefügt
                if(kategorieComboBox.getSelectedIndex() == 0 || name.isEmpty() || technischeDaten.isEmpty() || (kaufempfehlungComboBox.getSelectedIndex() == 0
                        && Main.getProduktkatalog().getListe().size() != 0) || jahrgangComboBox.getSelectedIndex() == 0 || lieferzeit == 0 || menegenbestand == 0 || seriennummer == 0 || preis == 0){
                    JOptionPane.showMessageDialog(null, "Fehler! Eine der angegeben Daten ist fehlerhaft!", "Fehler", JOptionPane.ERROR_MESSAGE);

                    //Nun werden alle Eingabefelder wieder auf ihren Standard resetet
                    if(kategorieComboBox.getSelectedIndex() == 0) kategorieComboBox.setSelectedIndex(0);
                    if(name.isEmpty()) nameTextField.setText(null);
                    if(technischeDaten.isEmpty()) technischeDatenTextArea.setText(null);
                    if(kaufempfehlungComboBox.getSelectedIndex() == 0 && Main.getProduktkatalog().getListe().size() != 0) kaufempfehlungComboBox.setSelectedIndex(0);
                    if(jahrgangComboBox.getSelectedIndex() == 0) jahrgangComboBox.setSelectedIndex(0);
                    if(lieferzeit == 0) lieferzeitSpinner.setValue(0);
                    if(menegenbestand == 0) mengenbestandSpinner.setValue(0);
                    if(seriennummer == 0) seriennummerTextField.setText(null);
                    if(preis == 0) preisSpinner.setValue(0);
                }else{
                    jahrgang = (int) jahrgangComboBox.getSelectedItem();

                    if(kategorie.equalsIgnoreCase("Elektronik")){
                        Main.getElektronikListe().produktErzeugen(name, technischeDaten, kaufempfehlung, jahrgang, lieferzeit, menegenbestand, preis, imAngebot);
                    } else if (kategorie.equalsIgnoreCase("Küche")) {
                        Main.getKuecheListe().produktErzeugen(name, technischeDaten, kaufempfehlung, jahrgang, lieferzeit, menegenbestand, preis, imAngebot);
                    } else if (kategorie.equalsIgnoreCase("Badezimmer")) {
                        Main.getBadezimmerListe().produktErzeugen(name, technischeDaten, kaufempfehlung, jahrgang, lieferzeit, menegenbestand, preis, imAngebot);
                    }else if (kategorie.equalsIgnoreCase("Schlafzimmer")) {
                        Main.getSchlafzimmerListe().produktErzeugen(name, technischeDaten, kaufempfehlung, jahrgang, lieferzeit, menegenbestand, preis, imAngebot);
                    }else if(kategorie.equalsIgnoreCase("Wohnzimmer")){
                        Main.getWohnzimmerListe().produktErzeugen(name, technischeDaten, kaufempfehlung, jahrgang, lieferzeit, menegenbestand, preis, imAngebot);
                    }else if(kategorie.equalsIgnoreCase("Sonstiges")){
                        Main.getSonstigesListe().produktErzeugen(name, technischeDaten, kaufempfehlung, jahrgang, lieferzeit, menegenbestand, preis, imAngebot);
                    }
                    Main.getMainFrame().updateContents();
                    setVisible(false);
                    dispose();

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
}
