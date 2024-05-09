import javax.swing.*;
import java.awt.*;

public class TicTacToe {
    JFrame frame = new JFrame("Tic Tac Toe Game");
    JLabel textLabel = new JLabel("Tic Tac Toe"); // Label to display game status
    JPanel textPanel = new JPanel(); // Panel to hold the textLabel
    JPanel boardPanel = new JPanel(); // Panel to hold the game board
    JPanel btnPanel = new JPanel(); // Panel to hold the restart button

    JButton[][] board = new JButton[3][3]; // Buttons representing the game board
    JButton restartBtn = new JButton("RESTART");

    // Strings representing player marks
    String playerX = "X";
    String playerO = "O";
    String currentPlayer = playerX;

    public TicTacToe() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(530, 600);
        frame.setResizable(false); // prevent resizing of frame
        frame.setLocationRelativeTo(null); // open frame on the middle of screen
        frame.setLayout(new BorderLayout());

        ImageIcon image = new ImageIcon("D:\\Java Projects\\GUI\\TicTacToe\\logo.png");
        frame.setIconImage(image.getImage());

        textLabel.setForeground(new Color(0x50206C));// set color of text label
        textLabel.setFont(new Font("Tahoma", Font.BOLD, 34)); // change text properties
        textLabel.setHorizontalAlignment(JLabel.CENTER); // center text

        textPanel.setBackground(new Color(0xF9F3FC));
        textPanel.setLayout(new BorderLayout());
        textPanel.setBorder(BorderFactory.createEmptyBorder(41, 0, 30, 0));
        textPanel.add(textLabel); // add text label to text panel
        frame.add(textPanel, BorderLayout.NORTH); // add text panel to frame and put it at the top

        boardPanel.setLayout(new GridLayout(3, 3, 10, 10)); // Set layout with 10px spacing between cells
        boardPanel.setBackground(new Color(0xF9F3FC));
        boardPanel.setBorder(BorderFactory.createEmptyBorder(0, 80, 0, 80)); // 80px space on left and right
        frame.add(boardPanel);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton box = new JButton();
                board[i][j] = box;
                box.setBackground(Color.white);
                box.setBorderPainted(false); // Remove border
                box.setFocusable(false);
                box.setText(currentPlayer);
                boardPanel.add(box);
                
            }
        }

        restartBtn.setPreferredSize(new Dimension(338, 50));
        restartBtn.setBackground(new Color(0x50206C));
        restartBtn.setForeground(Color.WHITE); // Set text color
        restartBtn.setFont(new Font("Tahoma", Font.BOLD, 16));
        restartBtn.setFocusPainted(false); // Remove focus border
        restartBtn.setBorderPainted(false); //Revove border

        btnPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // Center align button
        btnPanel.setBackground(new Color(0xF9F3FC));
        btnPanel.add(restartBtn);
        btnPanel.setBorder(BorderFactory.createEmptyBorder(31, 0, 45, 0)); // Set empty border
        frame.add(btnPanel, BorderLayout.SOUTH); // Add button panel to frame

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe();
    }
}
