import java.util.Scanner;
public class Prob6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while(true) {
            char letter;
    
            System.out.print("Enter letter: ");
            letter = scanner.next().charAt(0);
            if(letter == 'C' || letter == 'O'|| letter == 'D' || letter == 'E')
                break;
        }
    }
}