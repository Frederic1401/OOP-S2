package oop.code.GraphicalUserInterfaces;

import code.Main;
import code.Products.Produkt;

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
    private JSpinner jahrgangSpinner;
    private JLabel technischeDatenLabel;
    private JTextArea technischeDatenTextArea;
    private JButton bildHochladenButton;
    private JLabel kaufempfehlungLabel;
    private JTextField kaufempfehlungTextField;
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

        //ActionListener des 'Produkt anlegen' Buttons wird erstellt
        speichernButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Attribute des neuen Produkts werden hergeleitet
                String  kategorie = kategorieComboBox.getSelectedItem().toString(),
                        name = nameTextField.getText(),
                        technischeDaten = technischeDatenTextArea.getText(),
                        kaufempfehlung = kaufempfehlungTextField.getText();
                int     jahrgang = Integer.parseInt(jahrgangSpinner.getValue().toString()),
                        lieferzeit = Integer.parseInt(lieferzeitSpinner.getValue().toString()),
                        menegenbestand = Integer.parseInt(mengenbestandSpinner.getValue().toString()),
                        seriennummer = Integer.parseInt(seriennummerTextField.getText());
                double preis = Double.parseDouble(preisSpinner.getValue().toString());
                boolean imAngebot = imAngebotCheckBox.isSelected();

                //Neues Produkt wird erstellt und der Liste aller Produkte hinzugefügt
                if(kategorieComboBox.getSelectedIndex() == 0 || name.isEmpty() || technischeDaten.isEmpty() || kaufempfehlung.isEmpty() ||
                    jahrgang == 0 || lieferzeit == 0 || menegenbestand == 0 || seriennummer == 0 || preis == 0){
                    JOptionPane.showMessageDialog(null, "Fehler! Eine der angegeben Daten ist fehlerhaft!", "Fehler", JOptionPane.ERROR_MESSAGE);

                    //Nun werden alle Eingabefelder wieder auf ihren Standard resetet
                    kategorieComboBox.setSelectedIndex(0);
                    nameTextField.setText(null);
                    technischeDatenTextArea.setText(null);
                    kaufempfehlungTextField.setText(null);
                    jahrgangSpinner.setValue(Integer.valueOf(0));
                    lieferzeitSpinner.setValue(Integer.valueOf(0));
                    mengenbestandSpinner.setValue(Integer.valueOf(0));
                    seriennummerTextField.setText(null);
                    preisSpinner.setValue(Integer.valueOf(0));
                    imAngebotCheckBox.setSelected(false);
                }else{
                    Produkt neuesProdukt = new Produkt(kategorie, name, technischeDaten, kaufempfehlung, jahrgang,
                            lieferzeit, menegenbestand, seriennummer, preis, imAngebot);
                    Main.getProduktManager().getProduktListe().put(seriennummer, neuesProdukt);
                    Main.getMainFrame().updateContents();
                    setVisible(false);
                    dispose();

                }
            }
        });

        //ActionListender des 'Reset' Buttons wird erstellt
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

               kategorieComboBox.setSelectedIndex(0);
               nameTextField.setText(null);
               technischeDatenTextArea.setText(null);
               kaufempfehlungTextField.setText(null);
               jahrgangSpinner.setValue(Integer.valueOf(0));
               lieferzeitSpinner.setValue(Integer.valueOf(0));
               mengenbestandSpinner.setValue(Integer.valueOf(0));
               seriennummerTextField.setText(null);
               preisSpinner.setValue(Integer.valueOf(0));
               imAngebotCheckBox.setSelected(false);
            }
        });
    }

    /**
     * Dieser Konstruktor wird verwendet, um ein JFrame zu erstellen, welches dazu dient ein bestehendes Objekt der Klasse
     * Produkt zu bearbeiten
     * @param kategorie
     * @param name
     * @param technischeDaten
     * @param kaufempfehlung
     * @param jahrgang
     * @param lieferzeit
     * @param mengenbestand
     * @param serialnumber
     * @param preis
     * @param imAngebot
     */
    public ProductCreatorFrame(int kategorie, String name, String technischeDaten, String kaufempfehlung,
                               int jahrgang, int lieferzeit, int mengenbestand, int serialnumber, double preis, boolean imAngebot){
        this.kategorieComboBox.setSelectedIndex(kategorie);
        this.nameTextField.setText(name);
        this.technischeDatenTextArea.setText(technischeDaten);
        this.kaufempfehlungTextField.setText(kaufempfehlung);
        this.jahrgangSpinner.setValue(jahrgang);
        this.lieferzeitSpinner.setValue(lieferzeit);
        this.mengenbestandSpinner.setValue(mengenbestand);
        this.seriennummerTextField.setText(String.valueOf(serialnumber));
        this.preisSpinner.setValue(preis);
        this.imAngebotCheckBox.setSelected(imAngebot);

        loadCustomContents();

        setContentPane(mainPanel);
        setSize(550, 600);
        setLocationRelativeTo(null);
        setTitle(name+" | Bearbeiten");
        setVisible(true);

        //ActionListener des 'Produkt anlegen' Buttons wird erstellt
        speichernButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Attribute des neuen Produkts werden hergeleitet
                String  kategorie = kategorieComboBox.getSelectedItem().toString(),
                        name = nameTextField.getText(),
                        technischeDaten = technischeDatenTextArea.getText(),
                        kaufempfehlung = kaufempfehlungTextField.getText();
                int     jahrgang = Integer.parseInt(jahrgangSpinner.getValue().toString()),
                        lieferzeit = Integer.parseInt(lieferzeitSpinner.getValue().toString()),
                        mengenbestand = Integer.parseInt(mengenbestandSpinner.getValue().toString()),
                        seriennummer = Integer.parseInt(seriennummerTextField.getText());
                double preis = Double.parseDouble(preisSpinner.getValue().toString());
                boolean imAngebot = imAngebotCheckBox.isSelected();

                //Neues Produkt wird erstellt und der Liste aller Produkte hinzugefügt
                if(kategorieComboBox.getSelectedIndex() == 0 || name.isEmpty() || technischeDaten.isEmpty() || kaufempfehlung.isEmpty() ||
                        jahrgang == 0 || lieferzeit == 0 || mengenbestand == 0 || seriennummer == 0 || preis == 0){
                    JOptionPane.showMessageDialog(null, "Fehler! Eine der angegeben Daten ist fehlerhaft!",
                            "Fehler", JOptionPane.ERROR_MESSAGE);

                    //Nun werden alle Eingabefelder wieder auf ihren Standard resetet
                    kategorieComboBox.setSelectedIndex(0);
                    nameTextField.setText(null);
                    technischeDatenTextArea.setText(null);
                    kaufempfehlungTextField.setText(null);
                    jahrgangSpinner.setValue(Integer.valueOf(0));
                    lieferzeitSpinner.setValue(Integer.valueOf(0));
                    mengenbestandSpinner.setValue(Integer.valueOf(0));
                    seriennummerTextField.setText(null);
                    preisSpinner.setValue(Integer.valueOf(0));
                    imAngebotCheckBox.setSelected(false);
                }else{
                    Produkt currentProduct = Main.getProduktManager().getProduktListe().get(serialnumber);
                    currentProduct.setKategorie(kategorie);
                    currentProduct.setName(name);
                    currentProduct.setTechnischeDaten(technischeDaten);
                    currentProduct.setKaufempfehlung(kaufempfehlung);
                    currentProduct.setSeriennummer(seriennummer);
                    currentProduct.setJahrgang(jahrgang);
                    currentProduct.setLieferzeit(lieferzeit);
                    currentProduct.setMengenbestand(mengenbestand);
                    currentProduct.setPreis(preis);
                    currentProduct.setImAngebot(imAngebot);
                    Main.getProduktManager().getProduktListe().remove(serialnumber);
                    Main.getProduktManager().getProduktListe().put(currentProduct.getSeriennummer(), currentProduct);
                    Main.getMainFrame().updateContents();
                    setVisible(false);
                    dispose();
                }
            }
        });

        //ActionListender des 'Reset' Buttons wird erstellt
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                kategorieComboBox.setSelectedIndex(0);
                nameTextField.setText(null);
                technischeDatenTextArea.setText(null);
                kaufempfehlungTextField.setText(null);
                jahrgangSpinner.setValue(Integer.valueOf(0));
                lieferzeitSpinner.setValue(Integer.valueOf(0));
                mengenbestandSpinner.setValue(Integer.valueOf(0));
                seriennummerTextField.setText(null);
                preisSpinner.setValue(Integer.valueOf(0));
                imAngebotCheckBox.setSelected(false);
            }
        });
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
    }
}
