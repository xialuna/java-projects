import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class Telephone extends JFrame{
    private JLabel lblHeading, lblFirstName, lblLastName, lblMiddleIN, lblAddress, lblTelephone, lblSearch;
    private TextField txtFirstName, txtLastName, txtMiddleIN, txtAddress, txtTelephone,txtSearch;
    private JButton btnCreate, btnUpdate, btnDelete, btnClear, btnSearch;
    private JPanel panelName, panelAddress, panelTelephone, panelButtons, panelSearch, panelSearchWhole, panelInput, panelCRUD, panelTable;
    private File dataFile;
    Telephone(){
        dataFile = new File("directory.txt");
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

        // btnCreate.addActionListener(this);
        // btnUpdate.addActionListener(this);
        // btnDelete.addActionListener(this);
        // btnClear.addActionListener(this);
        // btnSearch.addActionListener(this);

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

        // Column names for the table
        String[] columnNames = {"Name", "Address", "Telephone"};
        // Create a list to hold the data rows
        List<String[]> data = new ArrayList<>();
        
        try{
            BufferedReader br = new BufferedReader(new FileReader(dataFile));
            String line;
            while((line = br.readLine()) != null){
                String[] columns = line.split("\\|");
                if(columns.length == columnNames.length){
                    data.add(columns);
                }
            }br.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        // Convert the list to a 2D array for the table model
        String[][] dataArray = data.toArray(new String[0][]); //creates an empty array
        

        // Create a table model
        DefaultTableModel model = new DefaultTableModel(dataArray, columnNames);

        // Create a JTable with the model
        JTable table = new JTable(model) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Make cells non-editable
            }
        };

        table.setRowSelectionAllowed(false); // Disable row selection
        table.getTableHeader().setReorderingAllowed(false); // Disable column reordering
        table.getTableHeader().setBackground(new Color(0xC8D8E9));

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

    // public void ActionListener (ActionEvent e){
    //     if (e.getSource() == btnUpdate){

    //     }
    // }

    public static void main(String[] args){
        Telephone app = new Telephone();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);

    }
}
