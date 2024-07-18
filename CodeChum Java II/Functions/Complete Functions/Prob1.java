import java.util.Scanner;

public class Prob1{
    public static int getSum(int num1, int num2){
        return num1 + num2;
    }
    public static void main(String[] args) {
        int a, b;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first number: ");
        a = scanner.nextInt();
        System.out.print("Enter second number: ");
        b = scanner.nextInt();

        int sum = getSum(a, b);

        System.out.print("Sum = " + sum);
    }
}