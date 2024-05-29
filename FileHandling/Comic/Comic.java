import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Comic extends JFrame {
    JLabel heading,subheading, lblTot, lblMale, lblFemale, lblIndicated, lblGood, lblBad, lblNeutral;
    JTextField txtTot, txtMale, txtFemale, txtIndicated, txtGood, txtBad, txtNeutral;
    JPanel titlePanel, countPanel, charPanel, bodyPanel;

    Comic() {
        setTitle("Comic Database");
        setSize(500,400);
        setLayout(new BorderLayout());

        titlePanel = new JPanel();
        titlePanel.setLayout(new GridLayout(2,1));
        heading = new JLabel("DC Wikia Comic Characters", SwingConstants.CENTER);
        subheading = new JLabel("Summary Report of File", SwingConstants.CENTER);
        titlePanel.add(heading);
        titlePanel.add(subheading);
        add(titlePanel, BorderLayout.NORTH);

        countPanel = new JPanel();
        countPanel.setLayout(new GridLayout(4,2,5,5));

        lblTot = new JLabel("Total number of records read: ");
        txtTot = new JTextField();
        txtTot.setEditable(false);
        countPanel.add(lblTot);
        countPanel.add(txtTot);

        lblMale = new JLabel("Number of male characters: ");
        txtMale = new JTextField();
        txtMale.setEditable(false);
        countPanel.add(lblMale);
        countPanel.add(txtMale);

        lblFemale = new JLabel("Number of female characters: ");
        txtFemale = new JTextField();
        txtFemale.setEditable(false);
        countPanel.add(lblFemale);
        countPanel.add(txtFemale);

        lblIndicated = new JLabel("Not Indicated: ");
        txtIndicated = new JTextField();
        txtIndicated.setEditable(false);
        countPanel.add(lblIndicated);
        countPanel.add(txtIndicated);

        charPanel = new JPanel();
        charPanel.setLayout(new GridLayout(3,2,5,5));

        lblGood= new JLabel("Good characters: ");
        txtGood = new JTextField();
        txtGood.setEditable(false);
        charPanel.add(lblGood);
        charPanel.add(txtGood);

        lblBad= new JLabel("Bad characters: ");
        txtBad = new JTextField();
        txtBad.setEditable(false);
        charPanel.add(lblBad);
        charPanel.add(txtBad);

        lblNeutral= new JLabel("Neutral characters: ");
        txtNeutral = new JTextField();
        txtNeutral.setEditable(false);
        charPanel.add(lblNeutral);
        charPanel.add(txtNeutral);

        bodyPanel = new JPanel();
        bodyPanel.setLayout(new GridLayout(2,1,10,20));
        bodyPanel.add(countPanel);
        bodyPanel.add(charPanel);
        add(bodyPanel);

        int totalRecords = 0;
        int maleCount = 0;
        int femaleCount = 0;
        int notStatedCount = 0;
        int goodCount = 0;
        int badCount = 0;
        int neutralCount = 0;

        try{
            BufferedReader reader = new BufferedReader(new FileReader("test.txt"));
            String line;
            while((line = reader.readLine()) != null){
                totalRecords++;
                String[] word = line.split("\\s+");// Split by whitespace
                int gender = Integer.parseInt(word[5]); //Since gender is  the 6th element in each line
                //count occurences in each gender
                switch(gender){
                    case 1:
                        maleCount++;
                        break;
                    case 2:
                        femaleCount++;
                        break;
                    case 0:
                        notStatedCount++;
                        break;
                }
            
                int align = Integer.parseInt(word[2]); //Since align is the 3rd element on the line
                //count occurences in each align
                switch(align){
                    case 1:
                        goodCount++;
                        break;
                    case 2:
                        badCount++;
                        break;
                    case 3:
                        neutralCount++;
                        break;
                }

            }
        }catch(IOException e){
            e.printStackTrace();
        }

        txtTot.setText(totalRecords+"");
        txtMale.setText(maleCount+"");
        txtFemale.setText(femaleCount+"");
        txtIndicated.setText(notStatedCount+"");
        txtGood.setText(goodCount+"");
        txtBad.setText(badCount+"");
        txtNeutral.setText(neutralCount+"");
    }

    public static void main(String[] args){
        Comic comic = new Comic();
        comic.setDefaultCloseOperation(EXIT_ON_CLOSE);
        comic.setVisible(true);

    }
    
}
