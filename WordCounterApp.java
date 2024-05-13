import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class WordCounterApp extends JFrame {

    private JTextArea textArea;
    private JLabel wordCountLabel;
    private JLabel charCountLabel;
    private JLabel sentenceCountLabel;
    private JLabel paragraphCountLabel;

    public WordCounterApp() {
        setTitle("Word Counter");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        wordCountLabel = new JLabel("Word count: 0");
        charCountLabel = new JLabel("Character count: 0");
        sentenceCountLabel = new JLabel("Sentence count: 0");
        paragraphCountLabel = new JLabel("Paragraph count: 0");

        textArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateCounts();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateCounts();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateCounts();
            }
        });

        JPanel countPanel = new JPanel(new GridLayout(4, 1));
        countPanel.add(wordCountLabel);
        countPanel.add(charCountLabel);
        countPanel.add(sentenceCountLabel);
        countPanel.add(paragraphCountLabel);

        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.add(scrollPane, BorderLayout.CENTER);
        container.add(countPanel, BorderLayout.SOUTH);
    }

    private void updateCounts() {
        String text = textArea.getText();
        int wordCount = text.split("\\s+").length;
        int charCount = text.length();
        int sentenceCount = text.split("[.!?]+").length;
        int paragraphCount = text.split("\\n+").length;
        wordCountLabel.setText("Word count: " + wordCount);
        charCountLabel.setText("Character count: " + charCount);
        sentenceCountLabel.setText("Sentence count: " + sentenceCount);
        paragraphCountLabel.setText("Paragraph count: " + paragraphCount);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            WordCounterApp app = new WordCounterApp();
            app.setVisible(true);
        });
    }
}
