import java.util.Scanner;
public class Prob3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = scanner.nextInt();
        System.out.print("Enter y: ");
        int y = scanner.nextInt();

        for(int i = 1; i <= n; i++){
            for(int j = 1; j<= n; j++){
                if(i != y)
                    System.out.print("*");
            }
            System.out.println();
        }
    }
}