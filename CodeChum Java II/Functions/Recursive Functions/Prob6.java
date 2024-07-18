import java.util.Scanner;
public class Prob6 {
    public static void printCodeChum(int n) {
        if (n != 0) {
            System.out.println("CodeChum");
            printCodeChum(n - 1);
        }
    }
    
    public static void main(String[] args) {
        int n;
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter n: ");
        n = scanner.nextInt();
        
        printCodeChum(n);
    }   
}