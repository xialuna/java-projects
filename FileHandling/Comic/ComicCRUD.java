import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ComicCRUD extends JFrame {
    ComicCRUD(){
        setTitle("Comic - CRUD Operation");
        setSize(600,600);
    }
    public static void main(String[] args){
        ComicCRUD comic = new ComicCRUD();
        comic.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        comic.setVisible(true);

    }
}
