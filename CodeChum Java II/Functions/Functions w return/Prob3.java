import java.util.Scanner;
public class Prob3 {
    public static String combineChars() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first character: ");
        String char1 = scanner.next();
        System.out.print("Enter second character: ");
        String char2 = scanner.next();
        return char1 + char2;
      }
    
    public static void main(String[] args) {
        String combine = combineChars();
        System.out.println(combine);
    }
}
// research more 
// concatenate char, having char functions