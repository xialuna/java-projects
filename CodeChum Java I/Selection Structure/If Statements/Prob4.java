import java.util.Scanner;
public class Prob4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a single character: ");
        char letter = scanner.nextLine().charAt(0);
        
        System.out.println(letter);
        letter = Character.toLowerCase(letter);
        if(letter == 'a'|| letter =='e'|| letter =='i' || letter == 'o'|| letter == 'u')
            System.out.println("vowel");
    }
}