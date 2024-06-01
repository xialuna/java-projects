import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Telephone extends JFrame {
    Telephone(){
        setTitle("Telephone Directory");
        setSize(600,600);
    }
    public static void main(String[] args){
        Telephone comic = new Telephone();
        comic.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        comic.setVisible(true);

    }
}
