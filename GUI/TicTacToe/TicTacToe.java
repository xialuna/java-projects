import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe {
    JFrame frame = new JFrame("Tic Tac Toe Game");
    JLabel textLabel = new JLabel("Tic Tac Toe"); // Label to display game status
    JPanel textPanel = new JPanel(); // Panel to hold the textLabel
    JPanel boardPanel = new JPanel(); // Panel to hold the game board
    JPanel btnPanel = new JPanel(); // Panel to hold the restart button

    JButton[][] board = new JButton[3][3]; // Buttons representing the game board
    JButton restartBtn = new JButton("RESTART");

    boolean endGame = false;
    int turns = 0;

    // Strings representing player marks
    ImageIcon playerX= new ImageIcon("D:\\Java Projects\\GUI\\TicTacToe\\x-icon.png");
    ImageIcon playerO = new ImageIcon("D:\\\\Java Projects\\\\GUI\\\\TicTacToe\\\\o-icon.png");
    ImageIcon currentPlayer = playerX;

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
                boardPanel.add(box);

                box.setBackground(Color.white);
                box.setBorderPainted(false); // Remove border
                box.setFocusable(false);
                box.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (endGame)
                            return;

                        if (box.getIcon() == null) { //only applies it to unclicked boxes
                            turns++;
                            box.setIcon(currentPlayer);
                            checkEndGame();

                            if (!endGame){
                                currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
                                textLabel.setText("Player "+((currentPlayer == playerX) ? "X" : "O")+ "'s Turn");
                            }
                            
                        }
                    }
                });
            }
        }

        restartBtn.setPreferredSize(new Dimension(338, 50));
        restartBtn.setBackground(new Color(0x50206C));
        restartBtn.setForeground(Color.WHITE); // Set text color
        restartBtn.setFont(new Font("Tahoma", Font.BOLD, 16));
        restartBtn.setFocusPainted(false); // Remove focus border
        restartBtn.setBorderPainted(false); // Remove border

        btnPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // Center align button
        btnPanel.setBackground(new Color(0xF9F3FC));
        btnPanel.add(restartBtn);
        btnPanel.setBorder(BorderFactory.createEmptyBorder(31, 0, 45, 0)); // Set empty border
        frame.add(btnPanel, BorderLayout.SOUTH); // Add button panel to frame

        restartBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                turns = 0;
                endGame = false;
                currentPlayer = playerX;
                textLabel.setText("Tic Tac Toe");
                for(int i = 0; i < 3; i++){
                    for(int j = 0; j < 3; j++){
                        board[i][j].setIcon(null);
                        board[i][j].setBackground(Color.white);
                }
            }
        }
    });

        frame.setVisible(true);
    }

    void checkEndGame() {
        //horizontal
        for (int i = 0; i < 3; i++) {
            //if box is empty
            if (board[i][0].getIcon() == null) 
                continue;

            //if 3 tiles horizontally are the same
            if (board[i][0].getIcon() == board[i][1].getIcon() &&
                board[i][1].getIcon() == board[i][2].getIcon()) {
                for (int j = 0; j < 3; j++) {
                    changeState(board[i][j], true); //if winner is found
                }
                endGame = true;
                return;
            }
        }

        //vertical
        for (int j = 0; j < 3; j++) {
            if (board[0][j].getIcon() ==  null) 
                continue;
            //if 3 tiles vertically are the same
            if (board[0][j].getIcon() == board[1][j].getIcon() &&
                board[1][j].getIcon() == board[2][j].getIcon()) {
                for (int i = 0; i < 3; i++) {
                    changeState(board[i][j], true);
                }
                endGame = true;
                return;
            }
        }

        //diagonal (right to left)
        if (board[0][0].getIcon() == board[1][1].getIcon() &&
            board[1][1].getIcon() == board[2][2].getIcon() &&
            board[0][0].getIcon() != null) {
            for (int i = 0; i < 3; i++) {
                changeState(board[i][i], true);
            }
            endGame = true;
            return;
        }

        //diagonal (left to right)
        if (board[0][2].getIcon() == board[1][1].getIcon() &&
            board[1][1].getIcon() == board[2][0].getIcon() &&
            board[0][2].getIcon() != null) {
            changeState(board[0][2], true);
            changeState(board[1][1], true);
            changeState(board[2][0], true);
            endGame = true;
            return;
        }

        //if there is no winner
        if (turns == 9) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    changeState(board[i][j], false);
                }
            }
            endGame = true;
        }
    }
    void changeState(JButton box, boolean winner) {
        box.setBackground(new Color((winner)? 0xC3FFAE: 0xFFE386));
        textLabel.setText((winner)?"Player " + (currentPlayer == playerX ? "X" : "O") + " Wins!" : "It's A Draw");
    }

    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe();
    }
}
