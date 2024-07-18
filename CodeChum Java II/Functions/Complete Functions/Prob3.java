import java.util.Scanner;

public class Prob3 {
    public static String combineChars(char a, char b){
        return a + "\n" + b;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first character: ");
        char a = scanner.next().charAt(0);
        System.out.print("Enter second character: ");
        char b = scanner.next().charAt(0);
        

        System.out.printf(combineChars(a,b));
    }
}