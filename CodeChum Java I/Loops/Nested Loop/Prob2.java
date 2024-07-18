import java.util.Scanner;
public class Prob2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = scanner.nextInt();
        
        System.out.print("  ");
        for (int i = 0; i<= n; i++){
            System.out.print(i + " ");
        }
        System.out.println();
        for(int i = 0; i <= n; i++){
            System.out.print(i + " ");
            for(int j = 0; j<= n; j++){
                System.out.print(i * j + " ");
            }
            System.out.println();
        }
    }
}