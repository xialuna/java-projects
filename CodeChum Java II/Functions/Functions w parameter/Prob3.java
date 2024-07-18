import java.util.Scanner;
public class Prob3 {
    public static void withLowerCase(char letter){
        System.out.println(letter +""+ Character.toLowerCase(letter));
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a character: ");
        char letter = scanner.next().charAt(0);
         withLowerCase(letter);
    }
}