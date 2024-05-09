import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
Steps:
1. Make Frame and add configurations 
2. Set frame to visible
3. Add a container
 */
public class HelloWorld {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hello World"); // Set frame title
        frame.setSize(300, 300);  // Set frame size (width, height in pixels)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Set default close operation(if close button is clicked, it will exit)

        // Add container for the frame and allows us to put diff components to the frame
        Container contentPane = frame.getContentPane();// Get the content pane of the frame
        contentPane.setLayout(null);// Set layout to null to allow manual component placement

        // adds button to container
        JButton button = new JButton("Hello World"); // Create a new button with label "Hello World"
        button.setBounds(75, 75, 150, 50); // sets the location and size of the button
        /*Can also be:
          button.setLocation(75,75);
          button.setSize(150,50);
         */
        contentPane.add(button);// Add the button to the content pane
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Toolkit.getDefaultToolkit().beep();

            }
        }); // Add action listener to the button

        frame.setVisible(true); // shows frame
    }


    //custom ActionListener (if separate class ang event listener)
    // static class MyActionListener implements ActionListener {
    //     // This method will be called when the button is clicked
    //     public void actionPerformed(ActionEvent e) {
    //         Toolkit.getDefaultToolkit().beep();// Play system default beep sound
    //     }
    // }
}
