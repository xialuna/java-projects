import java.util.Scanner;
public class Prob6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter integer x: ");
        int num1 = scanner.nextInt();
        System.out.print("Enter integer y: ");
        int num2 = scanner.nextInt();

        if(num1 > num2)
            System.out.println("x is greater than y");
        else if(num1 < num2)
            System.out.println("x is lesser than y");
        else
            System.out.println("x is equal to y");
    }
}