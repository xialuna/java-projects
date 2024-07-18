import java.util.Scanner;
public class Prob6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        System.out.print("Enter n: ");
        int n = scanner.nextInt();

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n - i; j++){
                System.out.print(" ");
            }for (int percent = 1; percent <= (i * 2) -1; percent++){
                System.out.print("%");
            }System.out.println();
        } 
    }
}