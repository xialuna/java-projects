import java.util.Scanner;
public class Prob2 {
    public static void main(String[] args) {
        char letter;
        Scanner scanner = new Scanner(System.in);

        do{
            System.out.print("Enter a character: ");
            letter = scanner.next().charAt(0);
            System.out.println(letter);
            letter = Character.toLowerCase(letter);
        }while( (letter != 'a') && (letter != 'e') && (letter != 'i') && (letter != 'o') && (letter != 'u'));

    }

}