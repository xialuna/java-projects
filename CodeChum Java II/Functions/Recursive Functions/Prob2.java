import java.util.Scanner;
public class Prob2 {
    public static void printRecursively(int current, int n) {
        if(current <= n) {
            System.out.print(current + " ");
            printRecursively(current + 1, n);
        }
    }
    
    public static void main(String[] args) {
        int n;
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter n: ");
        n = scanner.nextInt();
        
        printRecursively(1, n);
    }
}
