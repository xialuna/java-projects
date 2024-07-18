import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class TicTacToe extends JFrame {
    JLabel textLabel;
    JPanel textPanel, boardPanel, btnPanel, symbolPanel;
    JButton[][] board; // Buttons representing the game board
    JButton restartBtn;
    JButton symbolX, symbolO;

    // Set icons for X's and O's in the board
    ImageIcon playerX = new ImageIcon("D:\\TicTacToe\\x-icon.png");
    ImageIcon playerO = new ImageIcon("D:\\TicTacToe\\o-icon.png");
    ImageIcon currentPlayer = playerX;

    // Game status
    boolean endGame = false;
    int turns = 0;

    public TicTacToe() {
        // Frame setup
        setTitle("Tic Tac Toe Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(530, 670);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Set icon for the window
        ImageIcon logo = new ImageIcon("D:\\TicTacToe\\logo.png");
        setIconImage(logo.getImage());

        // Text label setup
        textLabel = new JLabel("Choose a symbol to start!");
        textLabel.setForeground(new Color(0x50206C));
        textLabel.setFont(new Font("Tahoma", Font.BOLD, 34));
        textLabel.setHorizontalAlignment(JLabel.CENTER);

        // Panels setup (text, symbol, board, button)
        textPanel = new JPanel();
        textPanel.setBackground(new Color(0xF9F3FC));
        textPanel.setLayout(new BorderLayout());
        textPanel.setBorder(BorderFactory.createEmptyBorder(41, 0, 10, 0));
        textPanel.add(textLabel, BorderLayout.NORTH);
        add(textPanel, BorderLayout.NORTH);

        symbolPanel = new JPanel();//x's and o's buttons pannel
        symbolPanel.setBackground(new Color(0xF9F3FC));
        symbolPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        textPanel.add(symbolPanel, BorderLayout.CENTER);

        boardPanel = new JPanel(); //main game board panel
        boardPanel.setLayout(new GridLayout(3, 3, 10, 10));
        boardPanel.setBackground(new Color(0xF9F3FC));
        boardPanel.setBorder(BorderFactory.createEmptyBorder(0, 80, 0, 80));
        add(boardPanel);

        btnPanel = new JPanel(); //restart button panel
        btnPanel.setBackground(new Color(0xF9F3FC));
        btnPanel.setBorder(BorderFactory.createEmptyBorder(15, 0, 40, 0));
        add(btnPanel, BorderLayout.SOUTH);

        // Text label and symbol selection buttons setup
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        symbolX = createSymbolBtn("PICK X", new Color(0xF77181));
        symbolO = createSymbolBtn("PICK O", new Color(0x6195DD));

        symbolX.addActionListener(e -> {
            startGame(playerX, "Player X's Turn"); // Call start game function
        });

        symbolO.addActionListener(e -> {
            startGame(playerO, "Player O's Turn"); 
        });

        symbolPanel.add(symbolX);
        symbolPanel.add(symbolO);

        // Game board setup
        setupBoard();

        // Set up Restart Button
        restartBtn = new JButton("RESTART");
        restartBtn.setPreferredSize(new Dimension(338, 50));
        restartBtn.setBackground(new Color(0x50206C));
        restartBtn.setForeground(Color.WHITE);
        restartBtn.setFont(new Font("Tahoma", Font.BOLD, 16));
        restartBtn.setFocusPainted(false);
        restartBtn.setBorderPainted(false);

        //Restart the game
        restartBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                turns = 0;
                endGame = false;
                currentPlayer = playerX;
                textLabel.setText("Choose a symbol to start!");
        
                // Reset buttons and board
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        board[i][j].setIcon(null);
                        board[i][j].setBackground(Color.white);
                    }
                }
        
                // Enable symbol selection buttons
                symbolX.setEnabled(true);
                symbolO.setEnabled(true);
                symbolX.setBackground(new Color(0xF77181));
                symbolO.setBackground(new Color(0x6195DD));
                disableBoard();
            }
        });

        btnPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        btnPanel.add(restartBtn);
    }

    // Utility method to create symbol buttons
    private JButton createSymbolBtn(String text, Color bgColor) {
        JButton symbol = new JButton(text);
        symbol.setPreferredSize(new Dimension(137, 39));
        symbol.setBackground(bgColor);
        symbol.setForeground(Color.white);
        symbol.setFont(new Font("Tahoma", Font.BOLD, 16));
        symbol.setFocusPainted(false);
        symbol.setBorderPainted(false);
        return symbol;
    }

    // Start the game with selected symbol
    private void startGame(ImageIcon symbol, String labelText) {
        currentPlayer = symbol;
        textLabel.setText(labelText);
        symbolX.setEnabled(false);
        symbolO.setEnabled(false);
        symbolX.setBackground(new Color(0xDDD7E1));
        symbolO.setBackground(new Color(0xDDD7E1));
        enableBoard();
    }

    // Game board setup
    private void setupBoard() {
        board = new JButton[3][3];
        //create buttons for each cell of the game board
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton box = new JButton();
                board[i][j] = box;

                // Set button properties
                box.setBackground(Color.white);
                box.setBorderPainted(false);
                box.setFocusable(false);
                
                box.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (endGame) // Check if the game has ended
                            return;

                        if (box.getIcon() == null) { // Check if the clicked box is empty
                            turns++;
                            box.setIcon(currentPlayer); 
                            checkEndGame();

                            // If the game has not ended, switch to the next player's turn
                            if (!endGame) {
                                currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
                                textLabel.setText("Player " + ((currentPlayer == playerX) ? "X" : "O") + "'s Turn");
                            }
                        }
                    }
                });
                box.setEnabled(false); // Disable the boxes initially until a symbol is chosen
                boardPanel.add(box);
            }
        }
    }

    // Check if the game is over
    private void checkEndGame() {
        // Check if boxes matches horizontally
        for (int i = 0; i < 3; i++) {
            if (checkLine(board[i][0], board[i][1], board[i][2])) {
                endGame = true;
                return;
            }
        }

        // Check if boxes matches vertically
        for (int j = 0; j < 3; j++) {
            if (checkLine(board[0][j], board[1][j], board[2][j])) {
                endGame = true;
                return;
            }
        }

        // Check if boxes matches diagonally
        if (checkLine(board[0][0], board[1][1], board[2][2]) ||
            checkLine(board[0][2], board[1][1], board[2][0])) {
            endGame = true;
            return;
        }

        // If there is no winner (tie)
        if (turns == 9) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    changeState(board[i][j], false);
                }endGame = true;
            }
        }
    }

    // Check if all three buttons have the same icon and change the state(color of boxes)
    private boolean checkLine(JButton b1, JButton b2, JButton b3) {
        if (b1.getIcon() != null && b1.getIcon() == b2.getIcon() && b2.getIcon() == b3.getIcon()) {
            changeState(b1, true);
            changeState(b2, true);
            changeState(b3, true);
            return true;
        }
        return false;
    }

    // Change the state of the boxes (winning or draw)
    private void changeState(JButton box, boolean winner) {
    textLabel.setText(winner ? "Player " + (currentPlayer == playerX ? "X" : "O") + " Wins!" : "It's A Draw");
    box.setBackground(winner ? new Color(0xC3FFAE) : new Color(0xFFE386));
}


    // Enable the game board
    private void enableBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j].setEnabled(true);
            }
        }
    }

    // Disable the game board
    private void disableBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j].setEnabled(false);
            }
        }
    }

    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.setVisible(true);
    }
}
