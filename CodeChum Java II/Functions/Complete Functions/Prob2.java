import java.util.Scanner;

public class Prob2 {
    public static int max(int a, int b, int c){
        int max = (a > b && a > c)? a : (b > c)? b : c;
        return max;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int a = scanner.nextInt();
        System.out.print("Enter second number: ");
        int b = scanner.nextInt();
        System.out.print("Enter third number: ");
        int c = scanner.nextInt();

        int maxVal = max(a,b,c);

        System.out.print("Maximum Value: " + maxVal);
    }
}