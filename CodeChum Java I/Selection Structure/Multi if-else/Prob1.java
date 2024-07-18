import java.util.Scanner;
public class Prob1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int num = scanner.nextInt();

        if(num == 0)
            System.out.println("Zero");
        else if(num % 2 != 0)
            System.out.println("Odd");
        else
            System.out.println("Even");
    }
}