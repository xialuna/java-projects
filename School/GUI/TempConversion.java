import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TempConversion {
    public static void main(String[] args){
        JFrame frame = new JFrame("Temperature Conversion");
        frame.setSize(670,70);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = frame.getContentPane();
        contentPane.setLayout(null);

        JButton tempCelcius = new JButton("Temp in Celcius: ");
        tempCelcius.setBounds(0,0,150,30);

        JTextField textCelcius = new JTextField("");
        textCelcius.setBounds(151,0,150,30);

        JButton tempFarenheit = new JButton("Temp in Fahrenheit: ");
        tempFarenheit.setBounds(350,0,150,30);

        JTextField textFarenheit  = new JTextField("");
        textFarenheit.setBounds(501,0,150,30);

        contentPane.add(tempCelcius);
        contentPane.add(textCelcius);
        contentPane.add(tempFarenheit);
        contentPane.add(textFarenheit);
        frame.setVisible(true);
    }
}
