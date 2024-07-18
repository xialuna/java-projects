import java.util.Scanner;
public class Prob5 {
    public static void printNumbers(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int n = scanner.nextInt();
        
        for (int i = 1; i <= n; i++){
            System.out.print(i);
            if (i != n)
                System.out.print(", ");
        }
    }
    public static void main(String[] args) {
        printNumbers();
    }
}