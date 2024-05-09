import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToe {
    JFrame frame =  new JFrame("Tic Tac Toe Game");;
    JLabel textLabel = new JLabel("Tic Tac Toe");//default text
    JPanel textPanel = new JPanel();

    public TicTacToe(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(530,600);
        frame.setVisible(true);

        frame.setResizable(false); //prevent resizing of frame
        frame.setLocationRelativeTo(null); //open frame on the middle of screen
        frame.setLayout(new BorderLayout());
        
        ImageIcon image = new ImageIcon("D:\\Java Projects\\GUI\\TicTacToe\\logo.png");
        frame.setIconImage(image.getImage());

        textLabel.setForeground(new Color(0x50206C));//set color of text label
        textLabel.setFont(new Font("Tahoma", Font.BOLD, 34)); //change text properties
        textLabel.setHorizontalAlignment(JLabel.CENTER); //center text

        textPanel.setLayout(new BorderLayout());
        textPanel.setBorder(BorderFactory.createEmptyBorder(41,0,41,0));
        textPanel.add(textLabel); //add text label to text panel
        frame.add(textPanel, BorderLayout.NORTH); //add text panel to frame and put it at the top
        frame.validate(); // Validate the frame after adding components
    }
    

    public static void main(String[] args){
        TicTacToe ticTacToe = new TicTacToe();
    }

}
