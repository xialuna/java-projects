import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Grade extends JFrame implements ActionListener{
    JLabel lblPrelims, lblMidterm, lblFinals, lblRating, lblStatus;
    JTextField txtPrelims, txtMidterm, txtFinals, txtRating, txtStatus;
    JButton btnCompute, btnClear;
       
    Grade(){// Constructor for Grade class
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

        // Add action listeners to the buttons
        btnCompute.addActionListener(this);
        btnClear.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        boolean validPrelims = false;
        boolean validMidterm = false;
        boolean validFinals = false;

        try{// For exception handling (ex: if user inputs a non-number)
            if(e.getSource() == btnCompute){ // If Compute button is clicked
                //Parse and validate prelims, midterm, final values
                double prelims = Double.parseDouble(txtPrelims.getText()); //assign inputted textField and convert to double
                validPrelims = (prelims >= 1 && prelims <= 100)? true : false;
    
                double midterm = Double.parseDouble(txtMidterm.getText()); 
                validMidterm = (midterm >= 1 && midterm <= 100)? true : false;
    
                double finals = Double.parseDouble(txtFinals.getText()); 
                validFinals = (finals >= 1 && finals <= 100)? true : false;
    
                // If all inputs are valid, calculate final rating and status
                if (validPrelims == true && validMidterm == true && validFinals == true){
                    double finalRating = (prelims * 0.30) + (midterm * 0.30) + (finals * 0.40);
                    txtRating.setText(finalRating + "");//turn finalRating into string
    
                    // Set status based on final rating
                    if (finalRating >= 75){
                        txtStatus.setText("PASSED");
                    }else{
                        txtStatus.setText("FAILED");
                    }
                }else{
                    // Show error message if inputs are invalid
                    JOptionPane.showMessageDialog(null, "Please enter a valid number (1 to 100)!","Invalid Input", JOptionPane.ERROR_MESSAGE);
                }
                
            }
    
            // If Clear button is clicked, clear all text fields
            if (e.getSource() == btnClear){
                txtPrelims.setText("");
                txtMidterm.setText("");
                txtFinals.setText("");
                txtRating.setText("");
                txtStatus.setText("");
            }
        }catch(NumberFormatException er){
             // Show error message if input is not a number
            JOptionPane.showMessageDialog(null, "Please enter a valid number!","Invalid Input", JOptionPane.ERROR_MESSAGE);
            // Clear all text fields
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
