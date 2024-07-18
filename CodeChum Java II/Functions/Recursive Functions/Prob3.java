import java.util.Scanner;
public class Prob3 {
    public static int fib(int n) {
        if (n <= 1) {
            return n;
        }
    
        return fib(n-1) + fib(n -2);
    }
     
    public static void main(String[] args) {
        int n;
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter which nth term: ");
        n = scanner.nextInt();
        
        System.out.print("Nth term = " + fib(n));
    }
}