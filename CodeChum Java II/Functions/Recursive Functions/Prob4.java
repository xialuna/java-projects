import java.util.Scanner;
public class Prob4 {
    public static int computeSum(int n) {
        if (n != 0) {        
            return n + computeSum(n -1);
        } else {
            return n;
        }
    }
    
    public static void main(String[] args) {
        int n;
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter n: ");
        n = scanner.nextInt();
        
        System.out.print("Sum = " + computeSum(n));
    } 
}