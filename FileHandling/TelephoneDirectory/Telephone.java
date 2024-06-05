import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class Telephone extends JFrame implements ActionListener{
    private JLabel lblHeading, lblFirstName, lblLastName, lblMiddleIN, lblAddress, lblTelephone, lblSearch;
    private TextField txtFirstName, txtLastName, txtMiddleIN, txtAddress, txtTelephone,txtSearch;
    private JButton btnInsert, btnUpdate, btnDelete, btnClear, btnSearch;
    private JPanel panelName, panelAddress, panelTelephone, panelButtons, panelSearch, panelSearchWhole, panelInput, panelCRUD, panelTable;
    private File dataFile = new File("directory.txt");
    DefaultTableModel tableModel;
    JTable table;


    Telephone(){
        setTitle("Telephone Directory CRUD Application");
        setLayout(new FlowLayout());
        setSize(1212,700);
        setResizable(false);
        setLocationRelativeTo(null);

        panelCRUD = new JPanel();
        panelInput = new JPanel();
        panelTable = new JPanel();
        panelName = new JPanel();
        panelAddress = new JPanel();
        panelTelephone = new JPanel();
        panelButtons = new JPanel();
        panelSearch = new JPanel();
        panelSearchWhole = new JPanel();

        panelCRUD.setLayout(new BorderLayout());
        panelInput.setLayout(new GridLayout(4,1,10,30));
        panelTable.setLayout(new BorderLayout());
        panelName.setLayout(new GridLayout(2,3,10,10));
        panelAddress.setLayout(new GridLayout(2,1,5,5));
        panelTelephone.setLayout(new GridLayout(2,1,5,5));
        panelButtons.setLayout(new GridLayout(1,4,10,10));
        panelSearchWhole.setLayout(new GridLayout(2,1));
        panelSearch.setLayout(new FlowLayout(FlowLayout.LEFT, 10,5));

        lblHeading = new JLabel("Telephone Directory");
        lblHeading.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 30));

        Font inputFont = new Font ("Microsoft JhengHei UI", Font.PLAIN, 18);
        Font textFont  = new Font ("Microsoft JhengHei UI", Font.PLAIN, 16);
        Font btnFont  = new Font ("Microsoft JhengHei UI", Font.PLAIN, 14);

        lblFirstName = new JLabel("First Name: ");
        txtFirstName = new TextField("", 10);
        lblFirstName.setFont(textFont);
        txtFirstName.setFont(inputFont);

        lblLastName = new JLabel("Last Name: ");
        txtLastName = new TextField("", 10);
        lblLastName.setFont(textFont);
        txtLastName.setFont(inputFont);

        lblMiddleIN = new JLabel("MI: ");
        txtMiddleIN = new TextField("", 10);
        lblMiddleIN.setFont(textFont);
        txtMiddleIN.setFont(inputFont);
        
        panelName.add(lblFirstName);
        panelName.add(lblLastName);
        panelName.add(lblMiddleIN);
        panelName.add(txtFirstName);
        panelName.add(txtLastName);
        panelName.add(txtMiddleIN);

        lblAddress = new JLabel("Address: ");
        txtAddress = new TextField("", 20);
        lblAddress.setFont(textFont);
        txtAddress.setFont(inputFont);
        panelAddress.add(lblAddress);
        panelAddress.add(txtAddress);

        lblTelephone = new JLabel("Telephone Number: ");
        txtTelephone = new TextField("", 20);
        lblTelephone.setFont(textFont);
        txtTelephone.setFont(inputFont);
        panelTelephone.add(lblTelephone);
        panelTelephone.add(txtTelephone);

        panelInput.add(lblHeading);
        panelInput.add(panelName);
        panelInput.add(panelAddress);
        panelInput.add(panelTelephone);

        btnInsert = new JButton("Insert");
        btnUpdate = new JButton("Update");
        btnDelete= new JButton("Delete");
        btnClear = new JButton("Clear");
        btnSearch = new JButton("Search");

        JButton[] buttons = {btnInsert, btnUpdate, btnDelete, btnClear, btnSearch};
        // Set the same font for all buttons 
        for (JButton button : buttons) {
            button.setFont(btnFont);
            // button.setPreferredSize(new Dimension(115, 44));
            button.setFocusable(false);
            panelButtons.add(button);
        }

        btnInsert.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnDelete.addActionListener(this);
        btnClear.addActionListener(this);
        btnSearch.addActionListener(this);

        panelCRUD.add(panelInput, BorderLayout.NORTH);
        panelCRUD.add(panelButtons, BorderLayout.SOUTH);

        lblSearch = new JLabel("Search By Telephone: ");
        txtSearch = new TextField("", 30);
        lblSearch.setFont(textFont);
        txtSearch.setFont(inputFont);

        panelSearch.add(txtSearch);
        panelSearch.add(btnSearch);
        panelSearchWhole.add(lblSearch);
        panelSearchWhole.add(panelSearch);

        ////////////////////
       

        // Create a table model
        tableModel = new DefaultTableModel(new Object[]{"Name", "Address", "Telephone"}, 0);

        // Create a JTable with the model
        table = new JTable(tableModel) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make cells non-editable
            }
        };
        table.getTableHeader().setReorderingAllowed(false); // Disable column reordering
        table.getTableHeader().setBackground(new Color(0xC8D8E9));

        readRecords(); // Load records at startup

         // Add selection listener to the table
         table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                tableSelected();
            }
        });
        

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setViewportBorder(BorderFactory.createEmptyBorder());
        scrollPane.getViewport().setBackground(Color.WHITE);

        // padding for the whole panel
        panelButtons.setBorder(new EmptyBorder(60, 0,0,0));
        panelSearch.setBorder(new EmptyBorder(0, 0,20,0));
        panelCRUD.setBorder(new EmptyBorder(20, 20, 0, 20));
        panelTable.setBorder(new EmptyBorder(20, 20, 0, 20));
        panelTable.add(panelSearchWhole, BorderLayout.NORTH);
        panelTable.add(scrollPane, BorderLayout.SOUTH);

        add(panelCRUD);
        add(panelTable);
    }

    public void actionPerformed (ActionEvent e){
        if (e.getSource() == btnInsert){
            String name = txtLastName.getText() + ", " + txtFirstName.getText() + " " + txtMiddleIN.getText();
            String address = txtAddress.getText();
            String telephone = txtTelephone.getText();
             // adds a new row to the tableModel using the values retrieved 
            tableModel.addRow(new Object[]{name, address, telephone}); 
            sortTable();
            writeRecords();
            clearTxtFields();
        }

        // UPDATE
        if (e.getSource() == btnUpdate) {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                String fullName = txtLastName.getText() + ", " + txtFirstName.getText() + " " + txtMiddleIN.getText();
                tableModel.setValueAt(fullName, selectedRow, 0);
                tableModel.setValueAt(txtAddress.getText(), selectedRow, 1);
                tableModel.setValueAt(txtTelephone.getText(), selectedRow, 2);
                sortTable();
                writeRecords();
                clearTxtFields();
            }else{
                JOptionPane.showMessageDialog(this, "Please select the row in the table that you want to update");
            }
        }

        // DELETE BUTTON
        if (e.getSource() == btnDelete){
            int selectedRow = table.getSelectedRow(); //get index of selected row

            //if a specific row is selected
            if (selectedRow != -1) {
                tableModel.removeRow(selectedRow);// removes the row at the specified index from the table model
                writeRecords();// save the updated data to txtFile
                clearTxtFields();
            }else{
                JOptionPane.showMessageDialog(this, "Please select the row in the table that you want to delete");
            }
        }
    }

    private void writeRecords(){
        try(PrintWriter writer = new PrintWriter(new FileWriter(dataFile))){
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

    private void readRecords(){
        try{
            BufferedReader br = new BufferedReader(new FileReader(dataFile));
            String line;
            while((line = br.readLine()) != null){
                String[] data = line.split("\\|");
                // Add row to the table model
                tableModel.addRow(data);
            }br.close();
        }catch(IOException e){
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

        rows.sort(Comparator.comparing(row -> row[0].toString()));

        tableModel.setRowCount(0);
        for (Object[] row : rows) {
            tableModel.addRow(row);
        }
    }

    private void tableSelected() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            String fullName = tableModel.getValueAt(selectedRow, 0).toString();
            String[] nameParts = fullName.split(", ");
    
            String lastName = "";
            String firstName = "";
            String middleInitial = "";
    
            // Check if nameParts array has at least one element (last name)
            if (nameParts.length > 0) {
                lastName = nameParts[0];
            }
    
            // Check if nameParts array has at least two elements (first name and middle initial)
            if (nameParts.length > 1) {
                String[] firstAndMiddle = nameParts[1].split(" ");
                if (firstAndMiddle.length > 0) {
                    firstName = firstAndMiddle[0];
                }
                // Check if firstAndMiddle array has at least two elements (middle initial)
                if (firstAndMiddle.length > 1) {
                    middleInitial = firstAndMiddle[1];
                }
            }
            // Set the extracted values to the corresponding text fields
            txtFirstName.setText(firstName);
            txtLastName.setText(lastName);
            txtMiddleIN.setText(middleInitial);
            txtAddress.setText(tableModel.getValueAt(selectedRow, 1).toString());
            txtTelephone.setText(tableModel.getValueAt(selectedRow, 2).toString());
        }
    }

    private void clearTxtFields(){
        txtFirstName.setText("");
        txtLastName.setText("");
        txtMiddleIN.setText("");
        txtAddress.setText("");
        txtTelephone.setText("");
    }

    public static void main(String[] args){
        Telephone app = new Telephone();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);

    }
}
