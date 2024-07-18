/*
Ask the user if they want to buy an ice cream by asking them
to input a character.

If they input the character Y (capital or small letter), print
"Here's your ice cream" on the next line, otherwise print
"Okay, maybe some other time".
 */
import java.util.Scanner;
public class Prob5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a character: ");
        char letter = scanner.next().charAt(0);

        if(letter == 'y'||letter == 'Y')
            System.out.println("Here's your ice cream");
        else
            System.out.println("Okay, maybe some other time");
    }
}