import java.util.Scanner;
public class Prob5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int num = scanner.nextInt();

        if(num % 7 == 0 && num % 3 != 0)
            System.out.println("Code");
        else if(num % 3 == 0 && num % 7 != 0)
            System.out.println("Chum");
        else if(num % 3 == 0 && num % 7 == 0)
            System.out.println("CodeChum");
        else
            System.out.println("None of the above");
    }
}