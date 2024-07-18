import java.util.Scanner;

public class Prob4 {
    public static int isDivisibleBy(int num1, int num2){
        return (num1 % num2 == 0)? 1 : 0;

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int a = scanner.nextInt();
        System.out.print("Enter second number: ");
        int b = scanner.nextInt();
        
        System.out.println((isDivisibleBy(a,b) == 1)?"yes": "no");
    }
}