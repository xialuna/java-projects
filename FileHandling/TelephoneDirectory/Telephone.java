import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Telephone extends JFrame {
    JLabel lblHeading, lblFirstName, lblLastName, lblMiddleIN, lblAddress, lblTelephone;
    TextField txtFirstName, txtLastName, txtMiddleIN, txtAddress, txtTelephone;
    JButton btnCreate, btnUpdate, btnDelete;
    JPanel panelName, panelAddress, panelTelephone, panelButtons, panelCRUD, panelTable;
    Telephone(){
        setTitle("Telephone Directory CRUD Application");
        setSize(1212,700);
        setResizable(false);
        setLocationRelativeTo(null);

        panelCRUD = new JPanel();
        panelTable = new JPanel();
        panelName = new JPanel();
        panelAddress = new JPanel();
        panelTelephone = new JPanel();
        panelButtons = new JPanel();

        panelCRUD.setLayout(new GridLayout(5,1,10,10));
        panelTable.setLayout(new GridLayout(2,1,10,10));
        panelName.setLayout(new GridLayout(2,3,5,5));;
        panelAddress.setLayout(new GridLayout(2,1,5,5));
        panelTelephone.setLayout(new GridLayout(2,1,5,5));
        panelButtons.setLayout(new GridLayout(1,4,10,10));

        lblHeading = new JLabel("Telephone Directory");
        lblHeading.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 30));

        Font fontDefault = new Font ("Microsoft JhengHei UI", Font.PLAIN, 16);

        lblFirstName = new JLabel("First Name: ");
        lblFirstName.setFont(fontDefault);
        txtFirstName = new TextField("", 20);
        panelName.add(lblFirstName);
        panelName.add(txtFirstName);

        lblLastName = new JLabel("Last Name: ");
        lblLastName.setFont(fontDefault);
        txtLastName = new TextField("", 20);
        panelName.add(lblLastName);
        panelName.add(txtLastName);

        lblMiddleIN = new JLabel("MI: ");
        lblMiddleIN.setFont(fontDefault);
        txtMiddleIN = new TextField("", 5);
        panelName.add(lblMiddleIN);
        panelName.add(txtMiddleIN);


        lblAddress = new JLabel("Address: ");
        lblAddress.setFont(fontDefault);
        txtAddress = new TextField("", 20);
        panelAddress.add(lblAddress);
        panelAddress.add(txtAddress);

        lblTelephone = new JLabel("Telephone Number: ");
        lblTelephone.setFont(fontDefault);
        txtTelephone = new TextField("", 20);
        panelTelephone.add(lblTelephone);
        panelTelephone.add(txtTelephone);

        panelCRUD.add(lblHeading);
        panelCRUD.add(panelName);
        panelCRUD.add(panelAddress);
        panelCRUD.add(panelTelephone);

        add(panelCRUD);
        // add(panelTable);
    }
    public static void main(String[] args){
        Telephone comic = new Telephone();
        comic.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        comic.setVisible(true);

    }
}
