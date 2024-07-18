import java.util.Scanner;
public class Prob6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        do {
            System.out.print("Enter value: ");
            n = scanner.nextInt();
        } while(n % 3 != 0 || n % 5 != 0);
    }
}