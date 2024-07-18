import java.util.Scanner;
public class Prob2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first integer: ");
        int num1= scanner.nextInt();
        System.out.print("Enter second integer: ");
        int num2= scanner.nextInt();

        System.out.println(num1 +" "+num2);
        if(num1 == num2)
            System.out.println("equal");
    }
}