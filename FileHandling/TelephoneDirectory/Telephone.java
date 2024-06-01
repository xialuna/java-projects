import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;

public class Telephone extends JFrame {
    JLabel lblHeading, lblFirstName, lblLastName, lblMiddleIN, lblAddress, lblTelephone, lblSearch;
    TextField txtFirstName, txtLastName, txtMiddleIN, txtAddress, txtTelephone,txtSearch;
    JButton btnCreate, btnUpdate, btnDelete, btnClear, btnSearch;
    JPanel panelName, panelAddress, panelTelephone, panelButtons, panelSearch, panelSearchWhole, panelInput, panelCRUD, panelTable;
    Telephone(){
        setTitle("Telephone Directory CRUD Application");
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

        btnCreate = new JButton("Create");
        btnUpdate = new JButton("Update");
        btnDelete= new JButton("Delete");
        btnClear = new JButton("Clear");
        btnSearch = new JButton("Search");

        JButton[] buttons = {btnCreate, btnUpdate, btnDelete, btnClear, btnSearch};
        // Set the same font for all buttons 
        for (JButton button : buttons) {
            button.setFont(btnFont);
            // button.setPreferredSize(new Dimension(115, 44));
            button.setFocusable(false);
            panelButtons.add(button);
        }

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
        

         // Sample data for the table
        Object[][] data = {
                {"John Doe", "123 Main St", "09067265123"},
                {"Jane Smith", "456 Elm St", "09067265123"},
                {"Bob Johnson", "789 Oak St", "090672651234"},
                {"Alice Williams", "101 Pine St", "09067265123"},
                // Add more rows as needed
        };

        // Column names for the table
        String[] columnNames = {"Name", "Address", "Telephone"};

        // Create a table model
        DefaultTableModel model = new DefaultTableModel(data, columnNames);

        // Create a JTable with the model
        JTable table = new JTable(model) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make cells non-editable
            }
        };

        // Set up custom cell renderer for alternating row colors
        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                c.setBackground((row % 2 == 0)? Color.WHITE: new Color(0xF2F2F2));
                return c;
            }
        });

        table.setRowSelectionAllowed(false); // Disable row selection
        table.getTableHeader().setReorderingAllowed(false); // Disable column reordering

        JScrollPane scrollPane = new JScrollPane(table);
        // scrollPane.setPreferredSize(new Dimension(545, 469));
        scrollPane.setViewportBorder(BorderFactory.createEmptyBorder());

        panelTable.add(panelSearchWhole, BorderLayout.NORTH);
        panelTable.add(scrollPane, BorderLayout.SOUTH);


        add(panelCRUD, BorderLayout.WEST);
        add(panelTable, BorderLayout.EAST);
    }
    public static void main(String[] args){
        Telephone app = new Telephone();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);

    }
}
