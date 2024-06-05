import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CRUDExample extends JFrame implements ActionListener{
    private JTextField idField, nameField, gradeField, commentsField;
    private DefaultTableModel tableModel;
    private JTable table;
    private JButton addButton, updateButton, deleteButton, loadButton;
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

        addButton.addActionListener(this);
        updateButton.addActionListener(this);
        deleteButton.addActionListener(this);
        loadButton.addActionListener(this);

        /* creates a new DefaultTableModel instance to manage the data for the table
        (parameters: columnNames, number of rows)*/
        tableModel = new DefaultTableModel(new Object[]{"ID", "Name", "Grade", "Comments"}, 0);
        
        //(tableModel) -> table will display the data managed by this table model
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

        inputPanel.setBorder(new EmptyBorder(20,0,40,0));

        add(new JScrollPane(table), BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);

    }

    private void readRecords() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Read each line from the file
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("|"); // Split the line into columns
                tableModel.addRow(data);  // Add row to the table model
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeRecords(){
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            for (int i = 0; i < tableModel.getRowCount(); i++) { //loop rows
                for (int j = 0; j < tableModel.getColumnCount(); j++) { //loop columns
                    // Write cell value at (row, col) to the file
                    writer.print(tableModel.getValueAt(i, j)); 
                    // If this is not the last column, print the delimiter
                    if (j < tableModel.getColumnCount() - 1) writer.print("|");
                }
                writer.println(); // Move to the next line after finishing the current row
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    
    public void actionPerformed(ActionEvent e) {
        // ADD BUTTON
        if(e.getSource() == addButton){
            //retrieve the text entered by the user 
            String id = idField.getText();
            String name = nameField.getText();
            String grade = gradeField.getText();
            String comments = commentsField.getText();

            // adds a new row to the tableModel using the values retrieved 
            tableModel.addRow(new Object[]{id, name, grade, comments}); 
            writeRecords(); //save the updated data to txtFile
        }
        
        // UPDATE BUTTON
        if(e.getSource() == updateButton){
            //returns the index of the selected row, or -1 if no row is selected.
            int selectedRow = table.getSelectedRow(); 

            if (selectedRow != -1) { // If selectedRow is not -1, it means a row is selected.

            //update the values in the selected row with the values entered in the input field
                tableModel.setValueAt(idField.getText(), selectedRow, 0);
                tableModel.setValueAt(nameField.getText(), selectedRow, 1);
                tableModel.setValueAt(gradeField.getText(), selectedRow, 2);
                tableModel.setValueAt(commentsField.getText(), selectedRow, 3);

                writeRecords();// save the updated data to txtFile
            }
        }

        // DELETE BUTTON
        if (e.getSource() == deleteButton){
            int selectedRow = table.getSelectedRow(); //get index of selected row

            //if a specific row is selected
            if (selectedRow != -1) {
                tableModel.removeRow(selectedRow);// removes the row at the specified index from the table model
                writeRecords();// save the updated data to txtFile
            }
        }

        // LOAD BUTTON
        if (e.getSource() == loadButton){
            tableModel.setRowCount(0); // Clear existing data in table
            readRecords(); //load records from the file into the table model
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CRUDExample example = new CRUDExample();
            example.setVisible(true);
        });
    }
}
