import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordCounter {
    public WordCounter(){
        JFrame frame = new JFrame("Word Counter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,550);
        frame.setVisible(true);
    }

    public static void main(String[] args){
        WordCounter wordCounter = new WordCounter();

    }

}
