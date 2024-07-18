import java.util.Scanner;
public class Prob6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num, sum = 0;

        do{
            System.out.print("Enter an integer: ");
            num = scanner.nextInt();
            if (num >= 10 && num <= 99){
                continue;
            }
            sum += num;
        }while (num >= 0);
        System.out.println("Sum of Integers: "+ sum);
    }
}