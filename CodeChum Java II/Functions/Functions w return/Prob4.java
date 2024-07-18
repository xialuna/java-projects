import java.util.Scanner;
public class Prob4 {
    public static float computeSumOfNumbers() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first number: ");
        float a = scanner.nextFloat();
        System.out.print("Enter second number: ");
        float b = scanner.nextFloat();
        System.out.print("Enter third number: ");
        float c = scanner.nextFloat();
        return a + b + c;
    }
    
    public static void main(String[] args) {
        System.out.printf("%.2f", computeSumOfNumbers());
    }  
}