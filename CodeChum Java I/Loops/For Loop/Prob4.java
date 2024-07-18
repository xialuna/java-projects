import java.util.Scanner;
public class Prob4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int n = scanner.nextInt();

        for(int i = 0, j = 1; i < n; i++, j++){
            System.out.print(j + " ");
            j += i;
        }
    }
}