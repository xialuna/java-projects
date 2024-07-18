import java.util.Scanner;
public class Prob2 {
    public static void sumOfIntegers(int a, int b, int c){
        System.out.println(a + b + c);
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first integer: ");
        int a = scanner.nextInt();
        System.out.print("Enter second integer: ");
        int b = scanner.nextInt();
        System.out.print("Enter third integer: ");
        int c = scanner.nextInt();
        sumOfIntegers(a,b,c);
    }
}
