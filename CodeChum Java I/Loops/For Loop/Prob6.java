import java.util.Scanner;
public class Prob6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = scanner.nextInt();

        for (int i = 2; i <= n; i += 2)
        {
            System.out.print(i+" ");
        }
    }
}