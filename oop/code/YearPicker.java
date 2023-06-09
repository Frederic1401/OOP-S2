package oop.code;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class YearPicker extends JFrame {
    private JComboBox<Integer> yearComboBox;

    public YearPicker() {
        setTitle("Year Picker");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Erzeuge eine JComboBox für die Jahre
        yearComboBox = new JComboBox<>();
        int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        for (int year = 1900; year <= currentYear; year++) {
            yearComboBox.addItem(year);
        }

        // Füge einen ActionListener hinzu, um das ausgewählte Jahr zu behandeln
        yearComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedYear = (int) yearComboBox.getSelectedItem();
                JOptionPane.showMessageDialog(null, "Das ausgewählte Jahr ist: " + selectedYear);
            }
        });

        // Füge die JComboBox zum Frame hinzu
        add(yearComboBox);

        // Passe die Größe des Frames an und mache ihn sichtbar
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new YearPicker();
            }
        });
    }
}
