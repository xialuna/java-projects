import java.util.Scanner;
public class Prob3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first number: ");
        float num1 = scanner.nextFloat();
        System.out.print("Enter second number: ");
        float num2 = scanner.nextFloat();
        System.out.print("Enter operation (+, -, *, or /): ");
        char operation = scanner.next().charAt(0);

        switch(operation){
            case '+':
                System.out.println(String.format("Result: %.2f",num1 + num2));
                break;
            case '-':
                System.out.println(String.format("Result: %.2f",num1 - num2));
                break;
            case '*':
                System.out.println(String.format("Result: %.2f",num1 * num2));
                break;
            case '/':
                System.out.println(String.format("Result: %.2f",num1 / num2));
                break;
            default:
                System.out.println("Result: -999.99");
                break;
        }

    }
}