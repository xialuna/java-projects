import java.util.Scanner;
public class Prob5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int num = scanner.nextInt();
        int sum = ((num % 10) % 3 != 0)? (num % 10 ): 0;
        while(num > 0){
            num/= 10;
            if ((num % 10) % 3 == 0)
                continue;
            sum += num % 10;
            
        }
        System.out.println("Sum of all digits: "+sum);
    }
}