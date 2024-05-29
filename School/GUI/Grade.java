import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Grade extends JFrame implements ActionListener{
    JLabel lblPrelims, lblMidterm, lblFinals, lblRating, lblStatus;
    JTextField txtPrelims, txtMidterm, txtFinals, txtRating, txtStatus;
    JButton btnCompute, btnClear;
       
    Grade(){
        setTitle("Computation of Grades");
        setSize(400,300);
        setLayout(new GridLayout(6,2, 5, 5));

        lblPrelims = new JLabel("Prelims: ");
        txtPrelims = new JTextField();

        add(lblPrelims);
        add(txtPrelims);

        lblMidterm = new JLabel("Mid Term: ");
        txtMidterm = new JTextField();
        add(lblMidterm);
        add(txtMidterm);

        lblFinals = new JLabel("Finals: ");
        txtFinals= new JTextField();
        add(lblFinals );
        add(txtFinals);

        lblRating = new JLabel("Final Rating: ");
        txtRating = new JTextField();
        txtRating.setEditable(false);
        add(lblRating);
        add(txtRating);

        lblStatus = new JLabel("Status: ");
        txtStatus = new JTextField();
        txtStatus.setEditable(false);
        add(lblStatus);
        add(txtStatus);

        btnCompute = new JButton("Compute");
        btnClear = new JButton("Clear");
        add(btnCompute);
        add(btnClear);

        btnCompute.addActionListener(this);
        btnClear.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        boolean validPrelims = false;
        boolean validMidterm = false;
        boolean validFinals = false;
        if(e.getSource() == btnCompute){
            double prelims = Double.parseDouble(txtPrelims.getText()); //assign inputted textField and convert to double
            validPrelims = (prelims >= 1 && prelims <= 100)? true : false;

            double midterm = Double.parseDouble(txtMidterm.getText()); 
            validMidterm = (midterm >= 1 && midterm <= 100)? true : false;

            double finals = Double.parseDouble(txtFinals.getText()); 
            validFinals = (finals >= 1 && finals <= 100)? true : false;

            if (validPrelims == true && validMidterm == true && validFinals == true){
                double finalRating = (prelims * 0.30) + (midterm * 0.30) + (finals * 0.40);
                txtRating.setText(finalRating + "");//turn finalRating into string

                if (finalRating >= 75){
                    txtStatus.setText("PASSED");
                }else{
                    txtStatus.setText("FAILED");
                }
            }

            
        }

        if (e.getSource() == btnCompute){
            txtPrelims.setText("");
            txtMidterm.setText("");
            txtFinals.setText("");
            txtRating.setText("");
            txtStatus.setText("");
        }
    }
    public static void main(String[] args){
        Grade app = new Grade();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
    }
}
