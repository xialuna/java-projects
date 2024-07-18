import java.util.Scanner;
public class Prob5 {
    public static void printRecursively(int n) {
        // TODO: Implement recursively
        if (n > 1){
            System.out.print(n + ", ");
            printRecursively(n - 1);
        }else
            System.out.print(n); 
    }
    
    public static void main(String[] args) {
        int n;
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter n: ");
        n = scanner.nextInt();
        
        printRecursively(n);
    }
}