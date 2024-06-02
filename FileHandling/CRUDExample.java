import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class CRUDExample extends JFrame implements ActionListener {
    private JTextField textField;
    private JTextArea textArea;
    private JButton createButton, updateButton, deleteButton, clearButton, searchButton;

    public CRUDExample() {
        setTitle("CRUD Example");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        textField = new JTextField(20);
        textArea = new JTextArea(10, 20);
        JScrollPane scrollPane = new JScrollPane(textArea);
        createButton = new JButton("Create");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");
        clearButton = new JButton("Clear");
        searchButton = new JButton("Search");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));
        panel.add(textField);
        panel.add(scrollPane);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(createButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(searchButton);

        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.add(panel, BorderLayout.CENTER);
        container.add(buttonPanel, BorderLayout.SOUTH);

        createButton.addActionListener(this);
        updateButton.addActionListener(this);
        deleteButton.addActionListener(this);
        clearButton.addActionListener(this);
        searchButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == createButton) {
            String newData = textField.getText();
            writeToFile(newData);
            textField.setText("");
            readFromFile();
        } else if (e.getSource() == updateButton) {
            String newData = textField.getText();
            updateFile(newData);
            textField.setText("");
            readFromFile();
        } else if (e.getSource() == deleteButton) {
            String dataToDelete = textField.getText();
            deleteFromFile(dataToDelete);
            textField.setText("");
            readFromFile();
        } else if (e.getSource() == clearButton) {
            clearFile();
            readFromFile();
        } else if (e.getSource() == searchButton) {
            String searchData = textField.getText();
            searchInFile(searchData);
        }
    }

    private void writeToFile(String data) {
        try (FileWriter writer = new FileWriter("records.txt", true);
             BufferedWriter bw = new BufferedWriter(writer);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("records.txt"))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            textArea.setText(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateFile(String newData) {
        try {
            File file = new File("records.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            StringBuilder inputBuffer = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                inputBuffer.append(line);
                inputBuffer.append('\n');
            }
            reader.close();
            String inputStr = inputBuffer.toString();

            inputStr = inputStr.replace(textArea.getSelectedText(), newData);

            FileOutputStream fileOut = new FileOutputStream("records.txt");
            fileOut.write(inputStr.getBytes());
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteFromFile(String dataToDelete) {
        try {
            File inputFile = new File("records.txt");
            File tempFile = new File("tempRecords.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String lineToRemove = dataToDelete;
            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                String trimmedLine = currentLine.trim();
                if (trimmedLine.equals(lineToRemove)) continue;
                writer.write(currentLine + System.getProperty("line.separator"));
            }
            writer.close();
            reader.close();
            boolean successful = tempFile.renameTo(inputFile);
            if (!successful) {
                System.out.println("Could not rename file");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void clearFile() {
        try {
            FileWriter fwOb = new FileWriter("records.txt", false);
            PrintWriter pwOb = new PrintWriter(fwOb, false);
            pwOb.flush();
            pwOb.close();
            fwOb.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void searchInFile(String searchData) {
        try (BufferedReader br = new BufferedReader(new FileReader("records.txt"))) {
            String line;
            boolean found = false;
            while ((line = br.readLine()) != null) {
                if (line.contains(searchData)) {
                    JOptionPane.showMessageDialog(this, "Found: " + line);
                    found = true;
                    break;
                }
            }
            if (!found) {
                JOptionPane.showMessageDialog(this, "Not Found");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CRUDExample example = new CRUDExample();
            example.setVisible(true);
            example.readFromFile();
        });
    }
}
