import java.util.Scanner;
public class Prob3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char letter = 'a';

        while(letter != 'x' && letter != 'X'){
            System.out.print("Enter a character: ");
            letter = scanner.next().charAt(0);
            
            if(Character.isDigit(letter)){
                continue;
            }
            System.out.println(letter + " " + letter + " " + letter);    
        
        }
    }
}