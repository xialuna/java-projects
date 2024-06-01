import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class TelephoneDirectory extends JFrame {
    private DefaultListModel<DirectoryEntry> directoryModel;
    private JList<DirectoryEntry> directoryList;
    private JTextField tfLastName, tfFirstName, tfMiddleName, tfStreet, tfPhone;
    private File directoryFile;

    public TelephoneDirectory() {
        super("Telephone Directory");
        directoryFile = new File("directory.txt");

        // Initialize GUI components
        directoryModel = new DefaultListModel<>();
        directoryList = new JList<>(directoryModel);
        directoryList.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof DirectoryEntry) {
                    DirectoryEntry entry = (DirectoryEntry) value;
                    setText("<html>" + entry.getLastName() + ", " + entry.getFirstName() + " " + entry.getMiddleName() + "<br>" +
                            entry.getStreet() + "<br>" + entry.getPhone() + "</html>");
                }
                return this;
            }
        });

        JScrollPane scrollPane = new JScrollPane(directoryList);

        tfLastName = new JTextField(10);
        tfFirstName = new JTextField(10);
        tfMiddleName = new JTextField(10);
        tfStreet = new JTextField(10);
        tfPhone = new JTextField(10);

        JButton btnInsert = new JButton("Insert");
        JButton btnDelete = new JButton("Delete");

        // Load initial directory
        loadDirectory();

        // Set up layout
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 2));
        inputPanel.add(new JLabel("Last Name:"));
        inputPanel.add(tfLastName);
        inputPanel.add(new JLabel("First Name:"));
        inputPanel.add(tfFirstName);
        inputPanel.add(new JLabel("Middle Name:"));
        inputPanel.add(tfMiddleName);
        inputPanel.add(new JLabel("Street Address:"));
        inputPanel.add(tfStreet);
        inputPanel.add(new JLabel("Phone Number:"));
        inputPanel.add(tfPhone);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnInsert);
        buttonPanel.add(btnDelete);

        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Add action listeners
        btnInsert.addActionListener(e -> insertEntry());
        btnDelete.addActionListener(e -> deleteEntry());

        // Set up frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setVisible(true);
    }

    private void loadDirectory() {
        directoryModel.clear();
        if (directoryFile.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(directoryFile))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (parts.length == 5) {
                        DirectoryEntry entry = new DirectoryEntry(parts[0], parts[1], parts[2], parts[3], parts[4]);
                        directoryModel.addElement(entry);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        sortDirectory();
    }

    private void saveDirectory() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(directoryFile))) {
            for (int i = 0; i < directoryModel.size(); i++) {
                DirectoryEntry entry = directoryModel.getElementAt(i);
                writer.write(entry.toCSV());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sortDirectory() {
        List<DirectoryEntry> entries = new ArrayList<>();
        for (Enumeration<DirectoryEntry> e = directoryModel.elements(); e.hasMoreElements(); ) {
            entries.add(e.nextElement());
        }
        entries.sort(Comparator.comparing(DirectoryEntry::getLastName));
        directoryModel.clear();
        for (DirectoryEntry entry : entries) {
            directoryModel.addElement(entry);
        }
    }

    private void insertEntry() {
        DirectoryEntry entry = new DirectoryEntry(tfLastName.getText(), tfFirstName.getText(), tfMiddleName.getText(),
                tfStreet.getText(), tfPhone.getText());
        directoryModel.addElement(entry);
        sortDirectory();
        saveDirectory();
    }

    private void deleteEntry() {
        DirectoryEntry entry = new DirectoryEntry(tfLastName.getText(), tfFirstName.getText(), tfMiddleName.getText(),
                tfStreet.getText(), tfPhone.getText());
        Enumeration<DirectoryEntry> elements = directoryModel.elements();
        while (elements.hasMoreElements()) {
            if (elements.nextElement().equals(entry)) {
                directoryModel.removeElement(entry);
                saveDirectory();
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Entry not found!", "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TelephoneDirectory::new);
    }

    static class DirectoryEntry {
        private String lastName;
        private String firstName;
        private String middleName;
        private String street;
        private String phone;

        public DirectoryEntry(String lastName, String firstName, String middleName, String street, String phone) {
            this.lastName = lastName;
            this.firstName = firstName;
            this.middleName = middleName;
            this.street = street;
            this.phone = phone;
        }

        public String getLastName() {
            return lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getMiddleName() {
            return middleName;
        }

        public String getStreet() {
            return street;
        }

        public String getPhone() {
            return phone;
        }

        public String toCSV() {
            return lastName + "," + firstName + "," + middleName + "," + street + "," + phone;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            DirectoryEntry that = (DirectoryEntry) o;
            return lastName.equals(that.lastName) && firstName.equals(that.firstName) && middleName.equals(that.middleName) && street.equals(that.street) && phone.equals(that.phone);
        }

        @Override
        public int hashCode() {
            return Objects.hash(lastName, firstName, middleName, street, phone);
        }

        @Override
        public String toString() {
            return lastName + ", " + firstName + " " + middleName + "\n" + street + "\n" + phone;
        }
    }
}
