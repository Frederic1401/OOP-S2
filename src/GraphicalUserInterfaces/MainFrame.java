package src.GraphicalUserInterfaces;

import src.Main;
import src.Produkte.Kategorien.*;
import src.Produkte.Produkt;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MainFrame extends JFrame {

    private JPanel mainContentPanel;
    private JPanel tabPanel;
    private JPanel kachelPanel, baumPanel, tabellePanel;
    private JPanel buttonPanel;
    private JTabbedPane mainTabbedPane;
    private JScrollPane kachelScrollPane, baumScrollPane;
    private JButton produktErzeugenButton;
    private JMenuBar menuBar;
    private JMenu menuDatei, menuAnsicht;
    private JMenuItem menuDatei_NeuesProdukt, menuDatei_Speichern, menuDatei_Laden,
            menuAnsicht_KachelAnsicht, menuAnsicht_BaumAnsicht, menuAnsicht_TabellenAnsicht;
    private ObjectInputStream input;
    private ObjectOutputStream output;

    public MainFrame(){
        //Zu Beginn werden die Attribute des JFrames definiert.
        super("Dropsi 3000");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280, 720);
        setLocationRelativeTo(null);
        setVisible(true);
        //Es werden die einzelnen JTabs initialisiert und befüllt.
        kachelPanel = new JPanel(new FlowLayout(FlowLayout.LEADING, 10, 10));
        kachelScrollPane = new JScrollPane(kachelPanel);
        kachelAnsichtGenerieren();
        baumPanel = new JPanel();
        baumScrollPane = new JScrollPane(baumPanel);
        baumScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        baumAnsichtGenerieren();
        tabellePanel = new JPanel();
        tabellenAnsichtGenerieren();
        //Das JTabbedPane wird initialisiert und mit entsprechend JTabs ausgestattet.
        mainTabbedPane = new JTabbedPane();
        mainTabbedPane.add("Kachel-Ansicht", kachelScrollPane);
        mainTabbedPane.add("Baum-Ansicht", baumScrollPane);
        mainTabbedPane.add("Tabelle-Ansicht", tabellePanel);
        //Der 'Produkt erzeugen' wird initialisiert und ihm wird ein ActionListener zugewiesen.
        produktErzeugenButton = new JButton("Produkt erzeugen");
        produktErzeugenButton.setSize(100, 50);
        produktErzeugenButton.addActionListener(e -> new ProduktCreatorFrame());
        //Die JPanel für das JTabbedPane und für den Button werden initialisiert und die entsprechenden Inhalte werden ihnen zugewiesen.
        tabPanel = new JPanel(new BorderLayout());
        tabPanel.add(mainTabbedPane, BorderLayout.CENTER);
        buttonPanel = new JPanel();
        buttonPanel.add(produktErzeugenButton);
        //Das Haupt JPanel des JFrames wird initialisiert und ihm werden die zuvor generierten JPanels zugewiesen.
        mainContentPanel = new JPanel(new BorderLayout());
        mainContentPanel.add(tabPanel, BorderLayout.CENTER);
        mainContentPanel.add(buttonPanel, BorderLayout.SOUTH);
        add(mainContentPanel);
        //Die JMenuBar, JMenu und JMenuItems werden initialisiert.
        menuBar = new JMenuBar();
        menuDatei = new JMenu("Datei");
        menuAnsicht = new JMenu("Ansicht");
        menuDatei_NeuesProdukt = new JMenuItem("Neues Produkt");
        menuDatei_Speichern = new JMenuItem("Speichern");
        menuDatei_Laden = new JMenuItem("Katalog laden...");
        menuAnsicht_KachelAnsicht = new JMenuItem("Kachel-Ansicht");
        menuAnsicht_BaumAnsicht = new JMenuItem("Baum-Ansicht");
        menuAnsicht_TabellenAnsicht = new JMenuItem("Tabellen-Ansicht");
        //Den Elementen aus dem Datei-Menu werden Tastenkombinationen und ActionListener zugewiesen.
        menuDatei_NeuesProdukt.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
        menuDatei_NeuesProdukt.addActionListener(e -> new ProduktCreatorFrame());
        menuDatei_Speichern.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
        menuDatei_Speichern.addActionListener(menuSpeicherActionListener());
        menuDatei_Laden.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_MASK));
        menuDatei_Laden.addActionListener(menuLadenActionListener());
        //Den Elementen aus dem Ansicht-Menu werden Tastenkombinationen und ActionListener zugewiesen.
        menuAnsicht_KachelAnsicht.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, InputEvent.CTRL_MASK));
        menuAnsicht_KachelAnsicht.addActionListener(e -> mainTabbedPane.setSelectedIndex(0));
        menuAnsicht_BaumAnsicht.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_MASK));
        menuAnsicht_BaumAnsicht.addActionListener(e -> mainTabbedPane.setSelectedIndex(1));
        menuAnsicht_TabellenAnsicht.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.CTRL_MASK));
        menuAnsicht_TabellenAnsicht.addActionListener(e -> mainTabbedPane.setSelectedIndex(2));
        //Die einzelnen JMenuItems und JMenus werden der JMenuBar zugewiesen und diese wiederrum dem JFrame.
        menuDatei.add(menuDatei_NeuesProdukt);
        menuDatei.add(menuDatei_Speichern);
        menuDatei.add(menuDatei_Laden);
        menuAnsicht.add(menuAnsicht_KachelAnsicht);
        menuAnsicht.add(menuAnsicht_BaumAnsicht);
        menuAnsicht.add(menuAnsicht_TabellenAnsicht);
        menuBar.add(menuDatei);
        menuBar.add(menuAnsicht);
        setJMenuBar(menuBar);

        revalidate();
    }

    /**
     * Erzeugt JPanels im 'Kachel-Ansicht'-Tab für jedes Produkt.
     */
    public void kachelAnsichtGenerieren() {
        //Der 'Kachel-Ansicht'-Tab wird zunächst geleert und die Gesamtübersicht der Produkte wird aufgerufen.
        kachelPanel.removeAll();
        //Es wird für jedes Produkt ein JPanel basierend auf ProductTemplatePane mit Seriennummer und Name erstellt.
        for(Produkt produkte : Main.getProduktkatalog().getListe()){
            kachelPanel.add(new ProduktVorlagePanel(produkte));
        }
        revalidate();
        repaint();
    }

    /**
     * Erzeugt einen JTree im 'Baum-Ansicht'-Tab, wobei jedes Produkt ein Ast darstellt, dem wiederrum die einzelne Produktinformation als Unterast zugewiesen sind
     */
    public void baumAnsichtGenerieren(){
        //Der 'Baum-Ansicht'-Tab wird zunächst geleert und die Grundstruktur des JTrees wird erzeugt.
        baumPanel.removeAll();
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Produkte");
        DefaultMutableTreeNode elektronikKategorie = new DefaultMutableTreeNode("Elektronik");
        DefaultMutableTreeNode kuecheKategorie = new DefaultMutableTreeNode("Küche");
        DefaultMutableTreeNode badezimmerKategorie = new DefaultMutableTreeNode("Badezimmer");
        DefaultMutableTreeNode schlafzimmerKategorie = new DefaultMutableTreeNode("Schlafzimmer");
        DefaultMutableTreeNode wohnzimmerKategorie = new DefaultMutableTreeNode("Wohnzimmer");
        DefaultMutableTreeNode sonstigesKategorie = new DefaultMutableTreeNode("Sonstiges");
        root.add(elektronikKategorie);
        root.add(kuecheKategorie);
        root.add(badezimmerKategorie);
        root.add(schlafzimmerKategorie);
        root.add(wohnzimmerKategorie);
        root.add(sonstigesKategorie);
        //Die Gesamtübersicht der Produkte wird aufgerufen und jedes Produkt wird zunächst dem richtigen Kategorie-Ast zugewiesen.
        //Anschließend wird ein Ast für jedes Produkt und die entsprechenden Unteräste erstellt.
        List<Produkt> produktList = Main.getProduktkatalog().getListe();
        for(int i=0; i<produktList.size(); i++){
            Produkt currentProdukt = produktList.get(i);
            if(currentProdukt.getKategorie().equalsIgnoreCase("Elektronik")){
                erzeugeProduktAst(currentProdukt, elektronikKategorie);
            }else if(currentProdukt.getKategorie().equalsIgnoreCase("Küche")){
                erzeugeProduktAst(currentProdukt, kuecheKategorie);
            }else if(currentProdukt.getKategorie().equalsIgnoreCase("Badezimmer")){
                erzeugeProduktAst(currentProdukt, badezimmerKategorie);
            }else if(currentProdukt.getKategorie().equalsIgnoreCase("Schlafzimmer")){
                erzeugeProduktAst(currentProdukt, schlafzimmerKategorie);
            }else if(currentProdukt.getKategorie().equalsIgnoreCase("Wohnzimmer")){
                erzeugeProduktAst(currentProdukt, wohnzimmerKategorie);
            }else if(currentProdukt.getKategorie().equalsIgnoreCase("Sonstiges")){
                erzeugeProduktAst(currentProdukt, sonstigesKategorie);
            }
        }
        //Abschließend wird das DefaultTreeModel initialisiert und die Größe des JTrees wird zur Größe des JFrames.
        DefaultTreeModel treeModel = new DefaultTreeModel(root);
        JTree tree = new JTree(treeModel);
        tree.setPreferredSize(getSize());
        baumPanel.add(tree);
        revalidate();
        repaint();
    }

    /**
     * Erzeugt eine tabellarische Darstellung über die Produktinformationen sämtlicher Produkte.
     */
    public void tabellenAnsichtGenerieren() {
        //Der 'Tabellen-Ansicht'-Tab wird zunächst geleert, die Gesamtübersicht der Produkte wird aufgerufen und die Struktur der Tabelle wird erzeugt.
        tabellePanel.removeAll();
        List<Produkt> produktliste = Main.getProduktkatalog().getListe();
        Object[] spalten = {"Seriennummer", "Kategorie", "Name", "Beschreibung", "Kaufempfehlung", "Jahrgang", "Lieferzeit", "Mengenbestand", "Preis", "Im Angebot?"};
        Object[][] produktDaten = new Object[produktliste.size()][spalten.length];
        //Für jedes Produkt (Zeile bzw. i) werden entsprechende Werte (Spalten bzw. j) notiert.
        for (int i = 0; i<produktliste.size(); i++) {
            Produkt produkt = produktliste.get(i);
            for (int j = 0; j < spalten.length; j++) {
                switch (j) {
                    case 0:
                        produktDaten[i][j] = produkt.getSeriennummer();
                        break;
                    case 1:
                        produktDaten[i][j] = produkt.getKategorie();
                        break;
                    case 2:
                        produktDaten[i][j] = produkt.getName();
                        break;
                    case 3:
                        produktDaten[i][j] = produkt.getBeschreibung();
                        break;
                    case 4:
                        produktDaten[i][j] = produkt.getKaufempfehlung() == null ? 0 : produkt.getKaufempfehlung().getSeriennummer();
                        break;
                    case 5:
                        produktDaten[i][j] = produkt.getJahrgang();
                        break;
                    case 6:
                        produktDaten[i][j] = produkt.getLieferzeit();
                        break;
                    case 7:
                        produktDaten[i][j] = produkt.getMengenbestand();
                        break;
                    case 8:
                        produktDaten[i][j] = produkt.getPreis();
                        break;
                    case 9:
                        produktDaten[i][j] = produkt.isImAngebot() ? "Ja" : "Nein";
                        break;
                }
            }
        }
        //Abschließend wird ein DefaultTableModel initialisiert, um das Editieren der Tabelle zu deaktivieren, umso Fehlern vorzubeugen.
        //Des Weiteren wird die Größe der Tabelle angepasst.
        DefaultTableModel tabelleModel = new DefaultTableModel(produktDaten, spalten){
            public boolean isCellEditable(int row, int column) {return false;}};
        JTable tabelle = new JTable(tabelleModel);
        JScrollPane tabelleScrollPane = new JScrollPane(tabelle);
        tabelleScrollPane.setPreferredSize(getSize());
        tabellePanel.add(tabelleScrollPane, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    /**
     * @param currentProdukt Das Produkt, für das ein Ast und jeweilige Unteräste erstellt werden sollen.
     * @param kategorie Der Kategorie-Ast, dem das Produkt zuzuweisen ist.
     */
    private void erzeugeProduktAst(Produkt currentProdukt, DefaultMutableTreeNode kategorie){
        DefaultMutableTreeNode currentProduktNode = new DefaultMutableTreeNode(currentProdukt.getSeriennummer());
        currentProduktNode.add(new DefaultMutableTreeNode("Name: "+currentProdukt.getName()));
        currentProduktNode.add(new DefaultMutableTreeNode("Beschreibung: "+currentProdukt.getName()));
        currentProduktNode.add(new DefaultMutableTreeNode("Kaufempfehlung: "+(currentProdukt.getKaufempfehlung()==null ? "-" : currentProdukt.getKaufempfehlung().getSeriennummer())));
        currentProduktNode.add(new DefaultMutableTreeNode("Mengenbestand: "+currentProdukt.getMengenbestand()));
        currentProduktNode.add(new DefaultMutableTreeNode("Lieferzeit: "+currentProdukt.getLieferzeit()));
        currentProduktNode.add(new DefaultMutableTreeNode("Preis: "+currentProdukt.getPreis()));
        currentProduktNode.add(new DefaultMutableTreeNode("Jahrgang: "+currentProdukt.getJahrgang()));
        currentProduktNode.add(new DefaultMutableTreeNode("Im Angebot?: "+(currentProdukt.isImAngebot() ? "Ja" : "Nein")));
        kategorie.add(currentProduktNode);
    }

    /**
     * @return Ein ActionListener, der dafür sorgt, dass der gesamte Produktkatalog als "katalog.dat" abgespeichert wird.
     */
    private ActionListener menuSpeicherActionListener(){
        return e -> {
            try {
                output = new ObjectOutputStream(new FileOutputStream("katalog.dat"));
                //Produktkatalog wird zum Array, um wiederrum durch einen ObjectOutputStream gespeichert werden zu können.
                Produkt produkte[] = Main.getProduktkatalog().getListe().toArray(new Produkt[0]);
                output.writeObject(produkte);
                JOptionPane.showMessageDialog(null, "Das Speichern war erfolgreich!", "Mitteilung", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        };
    }

    /**
     * @return Ein ActionListener, der eine zuvor gespeicherte "katalog.dat"-Datei einlesen und die Inhalte in sämtliche Produkt-Listen einfügen kann.
     */
    private ActionListener menuLadenActionListener(){
        return e -> {
            try {
                //Es werden neue Listen erzeugt, die die aktuellen Produkt-Listen ersetzen sollen.
                input = new ObjectInputStream(new FileInputStream("katalog.dat"));
                List<Produkt> produkt = new ArrayList<>();
                List<ElektronikProdukt> elektronik = new ArrayList<>();
                List<KuecheProdukt> kueche = new ArrayList<>();
                List<BadezimmerProdukt> badezimmer = new ArrayList<>();
                List<SchlafzimmerProdukt> schlafzimmer = new ArrayList<>();
                List<WohnzimmerProdukt> wohnzimmer = new ArrayList<>();
                List<SonstigesProdukt> sonstiges = new ArrayList<>();
                //Es wird überprüft welcher Kategorie die Produkte angehören und werden dementsprechend eingeordnet.
                for(Produkt produkte : (Produkt[]) input.readObject()){
                    if(produkte.getKategorie().equalsIgnoreCase("Elektronik")){
                        elektronik.add((ElektronikProdukt) produkte);
                    }else if(produkte.getKategorie().equalsIgnoreCase("Küche")){
                        kueche.add((KuecheProdukt) produkte);
                    }else if(produkte.getKategorie().equalsIgnoreCase("Badezimmer")){
                        badezimmer.add((BadezimmerProdukt) produkte);
                    }else if(produkte.getKategorie().equalsIgnoreCase("Schlafzimmer")){
                        schlafzimmer.add((SchlafzimmerProdukt) produkte);
                    }else if(produkte.getKategorie().equalsIgnoreCase("Wohnzimmer")){
                        wohnzimmer.add((WohnzimmerProdukt) produkte);
                    }else if(produkte.getKategorie().equalsIgnoreCase("Sonstiges")){
                        sonstiges.add((SonstigesProdukt) produkte);
                    }
                    produkt.add(produkte);
                }
                //Die aktuellen Produkt-Listen werden ersetzt.
                Main.getProduktkatalog().setListe(produkt);
                Main.getElektronikListe().setListe(elektronik);
                Main.getKuecheListe().setListe(kueche);
                Main.getBadezimmerListe().setListe(badezimmer);
                Main.getSchlafzimmerListe().setListe(schlafzimmer);
                Main.getWohnzimmerListe().setListe(wohnzimmer);
                Main.getSonstigesListe().setListe(sonstiges);
                //Die einzelnen Übersichten werden aktualisiert.
                Main.getMainFrame().kachelAnsichtGenerieren();
                Main.getMainFrame().baumAnsichtGenerieren();
                Main.getMainFrame().tabellenAnsichtGenerieren();
                JOptionPane.showMessageDialog(null, "Das Laden des Produktkatalogs war erfolgreich!", "Mitteilung", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException | ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        };
    }

}



