import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class WordCounter extends JFrame {
    JTextArea textArea; // Text area for user input
    JPanel countPanel; // Panel to display word, character, sentence, and paragraph counts
    JLabel titleLabel, wordCountLabel, charCountLabel, sentenceCountLabel, paragraphCountLabel; // Labels for the counts
    JScrollPane scrollPane;// Scroll pane for the text area

    public WordCounter() {
        setTitle("Word Counter App");
        setSize(800, 530);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the application icon
        ImageIcon logo = new ImageIcon("D:\\WordCounter\\logo.png");
        setIconImage(logo.getImage());

        // Create and configure the design of the title label
        titleLabel = new JLabel("Word Counter: Type anything you want!");
        titleLabel.setForeground(new Color(0x253A5B));
        titleLabel.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 16)); // change text properties
        titleLabel.setBorder(BorderFactory.createEmptyBorder(17,17,17,17)); //Add padding
        
        // Create the text area and make it scrollable
        textArea = new JTextArea();
        scrollPane = new JScrollPane(textArea);//make textArea scrollable
        scrollPane.setBorder(BorderFactory.createEmptyBorder(0, 17, 0, 17)); // Add padding
        
        // Create labels for word, character, sentence, and paragraph counts
        wordCountLabel = new JLabel("Words: 0");
        charCountLabel = new JLabel("Characters: 0");
        sentenceCountLabel = new JLabel("Sentences: 0");
        paragraphCountLabel = new JLabel("Paragraphs: 0");

        // Add a document listener to update counts when text is changed
        textArea.getDocument().addDocumentListener(new DocumentListener() {
     
            public void insertUpdate(DocumentEvent e) {
                updateCounts();
            }

            public void removeUpdate(DocumentEvent e) {
                updateCounts();
            }

            public void changedUpdate(DocumentEvent e) {
                updateCounts();
            }
        });

        // Add components to the JFrame
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.add(titleLabel, BorderLayout.NORTH);
        container.add(scrollPane, BorderLayout.CENTER);

        // Create a panel for the counts and add labels to it
        countPanel = new JPanel(new GridLayout(1, 4, 10, 0));
        countPanel.setBorder(BorderFactory.createEmptyBorder(18,18,20,18));
        countPanel.add(wordCountLabel);
        countPanel.add(charCountLabel);
        countPanel.add(sentenceCountLabel);
        countPanel.add(paragraphCountLabel);
        container.add(countPanel, BorderLayout.SOUTH);
    }

    // Method to update the word, character, sentence, and paragraph counts
    void updateCounts() {
        String text = textArea.getText();
        int wordCount = text.isEmpty() ? 0 : text.trim().split("\\s+").length; // Count words
        int charCount = text.length(); // Count characters
        int sentenceCount = text.isEmpty() ? 0 : text.split("[.!?]+").length; // Count sentences
        int paragraphCount = text.isEmpty() ? 0 : text.split("\\n+").length; // Count paragraphs

        //Update the displayed text
        wordCountLabel.setText("Words: " + wordCount);
        charCountLabel.setText("Characters: " + charCount);
        sentenceCountLabel.setText("Sentences: " + sentenceCount);
        paragraphCountLabel.setText("Paragraphs: " + paragraphCount);
    }

    public static void main(String[] args) {
        WordCounter wordCounter = new WordCounter();
        wordCounter.setVisible(true);
    }
}
