import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Telephone extends JFrame {
    JLabel lblHeading, lblName, lblAddress, lblTelephone;
    TextField txtName, txtAddress, txtTelephone;
    JPanel panelName, panelAddress, panelTelephone, panelButtons, panelCRUD, panelTable;
    Telephone(){
        setTitle("Telephone Directory");
        setSize(1212,700);
        setResizable(false);
        setLocationRelativeTo(null);

        panelCRUD = new JPanel();
        panelTable = new JPanel();
        panelName = new JPanel();
        panelAddress = new JPanel();
        panelTelephone = new JPanel();
        panelButtons = new JPanel();

        panelCRUD.setLayout(new GridLayout(4,1,10,10));
        panelTable.setLayout(new GridLayout(2,1,10,10));
        panelName.setLayout(new GridLayout(2,1,5,5));;
        panelAddress.setLayout(new GridLayout(2,1,5,5));
        panelTelephone.setLayout(new GridLayout(2,1,5,5));
        panelButtons.setLayout(new GridLayout(1,4,10,10));

        Font fontDefault = new Font ("Microsoft JhengHei UI", Font.PLAIN, 16);
        
        lblName = new JLabel("Full Name: ");
        lblName.setFont(fontDefault);
        txtName = new TextField("", 20);
        panelName.add(lblName);
        panelName.add(txtName);

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
