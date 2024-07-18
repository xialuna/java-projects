import java.util.Scanner;
public class Prob3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int num1 = scanner.nextInt();
        System.out.print("Enter second number: ");
        int num2 = scanner.nextInt();

        int sum = num1 + num2;
        if(sum == 0)
            System.out.println("Zero");
        else if(sum > 0)
            System.out.println("Positive");
        else
            System.out.println("Negative");
    }
}