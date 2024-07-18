import java.util.Scanner;
public class Prob5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i;

        System.out.print("Enter i: ");
        i = scanner.nextInt();

        while (i < 100) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
            i++;
        }

        scanner.close();
    }
}