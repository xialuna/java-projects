import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CRUDExample extends JFrame implements ActionListener {
    private JTextField idField, nameField, gradeField, commentsField;
    private DefaultTableModel tableModel;
    private JTable table;
    private JButton addButton, updateButton, deleteButton, loadButton, searchButton;
    private final String filePath = "record.txt";

    public CRUDExample() {
        setTitle("Student Records CRUD Example");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Initialize components
        idField = new JTextField(5);
        nameField = new JTextField(15);
        gradeField = new JTextField(5);
        commentsField = new JTextField(20);
        
        addButton = new JButton("Add");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");
        loadButton = new JButton("Load");
        searchButton = new JButton("Search");

        addButton.addActionListener(this);
        updateButton.addActionListener(this);
        deleteButton.addActionListener(this);
        loadButton.addActionListener(this);
        searchButton.addActionListener(this);

        tableModel = new DefaultTableModel(new Object[]{"ID", "Name", "Grade", "Comments"}, 0);
        table = new JTable(tableModel);
        readRecords(); // Load records at startup

        // Layout setup
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("ID:"));
        inputPanel.add(idField);
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Grade:"));
        inputPanel.add(gradeField);
        inputPanel.add(new JLabel("Comments:"));
        inputPanel.add(commentsField);
        inputPanel.add(addButton);
        inputPanel.add(updateButton);
        inputPanel.add(deleteButton);
        inputPanel.add(loadButton);
        inputPanel.add(searchButton);

        inputPanel.setBorder(new EmptyBorder(20, 0, 40, 0));

        add(new JScrollPane(table), BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);
    }

    private void readRecords() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\\|"); // Split the line into columns
                tableModel.addRow(data);  // Add row to the table model
            }
            sortTable();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeRecords() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                for (int j = 0; j < tableModel.getColumnCount(); j++) {
                    writer.print(tableModel.getValueAt(i, j));
                    if (j < tableModel.getColumnCount() - 1) writer.print("|");
                }
                writer.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sortTable() {
        List<Object[]> rows = new ArrayList<>();
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            Object[] row = new Object[tableModel.getColumnCount()];
            for (int j = 0; j < tableModel.getColumnCount(); j++) {
                row[j] = tableModel.getValueAt(i, j);
            }
            rows.add(row);
        }

        rows.sort(Comparator.comparing(row -> row[1].toString()));

        tableModel.setRowCount(0);
        for (Object[] row : rows) {
            tableModel.addRow(row);
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String id = idField.getText();
            String name = nameField.getText();
            String grade = gradeField.getText();
            String comments = commentsField.getText();
            tableModel.addRow(new Object[]{id, name, grade, comments});
            sortTable();
            writeRecords();
        }
        
        if (e.getSource() == updateButton) {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                tableModel.setValueAt(idField.getText(), selectedRow, 0);
                tableModel.setValueAt(nameField.getText(), selectedRow, 1);
                tableModel.setValueAt(gradeField.getText(), selectedRow, 2);
                tableModel.setValueAt(commentsField.getText(), selectedRow, 3);
                sortTable();
                writeRecords();
            }
        }

        if (e.getSource() == deleteButton) {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                tableModel.removeRow(selectedRow);
                writeRecords();
            }
        }

        if (e.getSource() == loadButton) {
            tableModel.setRowCount(0);
            readRecords();
        }

        if (e.getSource() == searchButton) {
            String id = idField.getText();
            boolean found = false;
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                if (tableModel.getValueAt(i, 0).equals(id)) {
                    table.setRowSelectionInterval(i, i);
                    found = true;
                    break;
                }
            }
            if (!found) {
                JOptionPane.showMessageDialog(this, "Record not found.");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CRUDExample example = new CRUDExample();
            example.setVisible(true);
        });
    }
}
