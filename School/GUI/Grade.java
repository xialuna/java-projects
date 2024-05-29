import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Grade extends JFrame{
    JLabel lblTitle, lblPrelims, lblMidterm, lblFinals, lblRating, lblStatus;
    JTextField txtPrelims, txtMidterm, txtFinals, txtRating, txtStatus;
    JButton btnCompute, btnClear;
       
    Grade(){
        setSize(600,600);
        setLayout(new FlowLayout());

        lblTitle = new JLabel("Computation of Grades");
        add(lblTitle);

        lblPrelims = new JLabel("Prelims: ");
        txtPrelims = new JTextField("", 12);
        add(lblPrelims);
        add(txtPrelims);

        lblMidterm = new JLabel("Mid Term: ");
        txtMidterm = new JTextField("", 12);
        add(lblMidterm);
        add(txtMidterm);

        lblFinals = new JLabel("Finals: ");
        txtFinals= new JTextField("", 12);
        add(lblFinals );
        add(txtFinals);

        lblRating = new JLabel("Final Rating: ");
        txtRating = new JTextField("", 12);
        add(lblRating);
        add(txtRating);

        lblStatus = new JLabel("Final Rating: ");
        txtStatus = new JTextField("", 12);
        add(lblStatus);
        add(txtStatus);

        btnCompute = new JButton("Compute");
        btnClear = new JButton("Clear");
        add(btnCompute);
        add(btnClear);


    }
    public static void main(String[] args){
        Grade app = new Grade();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
    }
}
