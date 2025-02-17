package fr.tpjava;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GameInventory {
    public JFrame frame;
    public DefaultListModel<String> listModel = new DefaultListModel<>();
    public JList<String> inventory = new JList<>(listModel);

    public GameInventory() {
        frame = new JFrame("Inventory");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new BorderLayout(10, 10));

        JPanel inputPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        JTextField nameField = new JTextField();
        JTextField quantityField = new JTextField();
        inputPanel.add(new JLabel("Nom :"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Quantité :"));
        inputPanel.add(quantityField);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        JButton addButton = new JButton("Ajouter");
        JButton removeButton = new JButton("Supprimer");
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);

        JPanel listPanel = new JPanel(new BorderLayout());
        listPanel.add(new JLabel("Inventaire :"), BorderLayout.NORTH);
        listPanel.add(new JScrollPane(inventory), BorderLayout.CENTER);

        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(listPanel, BorderLayout.SOUTH);

        frame.setVisible(true);

        addButton.addActionListener(addButtonEvent -> {
            if (nameField.getText().isEmpty() || quantityField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Veuillez remplir tous les champs.");
                return;
            }
            try {
                String itemName = nameField.getText();
                int itemQuantity = Integer.parseInt(quantityField.getText());
                Inventory.addItem(itemName, itemQuantity);
                updateDisplay();
                nameField.setText("");
                quantityField.setText("");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(frame, "Quantité invalide !");
            }
        });

        removeButton.addActionListener(removeButtonEvent -> {
            if (nameField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Veuillez entrer un nom d'objet.");
                return;
            }
            String itemName = nameField.getText();
            Inventory.removeItem(itemName);
            updateDisplay();
            nameField.setText("");
        });
    }

    public void updateDisplay() {
        listModel.clear();
        List<String> items = Inventory.displayItems();
        for (String item : items) {
            listModel.addElement(item);
        }
    }
}
