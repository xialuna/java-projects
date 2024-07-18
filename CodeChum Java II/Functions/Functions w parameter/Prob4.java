import java.util.Scanner;
public class Prob4 {
    public static void printProduct(int a, int b) {
        int product = a * b;
        System.out.println("Product = " + product);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter x: ");
        int x = scanner.nextInt();
        System.out.print("Enter y: ");
        int y = scanner.nextInt();
        printProduct(x, y);
    }
}