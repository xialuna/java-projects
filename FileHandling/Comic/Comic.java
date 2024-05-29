import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Comic extends JFrame {
    JPanel headingPanel, bodyPanel;
    JLabel title, subTitle, totLabel, maleLabel, femaleLabel, notIndicatedLabel, goodLabel, badLabel, neutralLabel;
    TextField txtTot, txtMale, txtFemale, txtNotIndicated, txtGood, txtBad, txtNeutral;

    Comic() {
        setTitle("DC Wikia Comic Characters");
        headingPanel = new JPanel();
        title = new JLabel("DC Wikia Comic Characters\n");
        subTitle = new JLabel("Summary Report of File");
        headingPanel.add(title);
        headingPanel.add(subTitle);
        add(headingPanel,BorderLayout.NORTH);

        totLabel = new JLabel("Total number of records read: ");
        maleLabel = new JLabel("Number of male characters: ");
        femaleLabel = new JLabel("Number of female characters: ");
        notIndicatedLabel = new JLabel("Not Indicated: ");
        goodLabel = new JLabel("Good Characters: ");
        badLabel = new JLabel("Bad Characters: ");
        neutralLabel = new JLabel("Neutral Characters: ");

        txtTot = new TextField("",12);
        txtTot.setEditable(false);
        txtMale = new TextField("",12);
        txtMale.setEditable(false);
        txtFemale = new TextField("",12);
        txtFemale.setEditable(false);
        txtNotIndicated = new TextField("",12);
        txtNotIndicated.setEditable(false);
        txtGood = new TextField("",12);
        txtGood.setEditable(false);
        txtBad = new TextField("",12);
        txtBad.setEditable(false);
        txtNeutral = new TextField("",12);
        txtNeutral.setEditable(false);

        bodyPanel = new JPanel();
        bodyPanel.setLayout(new GridLayout(7,0,2,2));
        bodyPanel.add(totLabel);
        bodyPanel.add(txtTot);
        bodyPanel.add(maleLabel);
        bodyPanel.add(txtMale);
        bodyPanel.add(femaleLabel );
        bodyPanel.add(txtFemale);
        bodyPanel.add(notIndicatedLabel);
        bodyPanel.add(txtNotIndicated);
        bodyPanel.add(goodLabel);
        bodyPanel.add(txtGood);
        bodyPanel.add(badLabel );
        bodyPanel.add(txtBad);
        bodyPanel.add(neutralLabel);
        bodyPanel.add(txtNeutral);

        add(bodyPanel);


        setSize(600,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args){
        Comic comic = new Comic();
        comic.setVisible(true);

    }
    
}
