import java.util.Scanner;
public class Prob5 {
    public static void main(String[] args) {
        int num, sum = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        
        do{
            num = scanner.nextInt();
            sum += num;
        }while(num != 0);

        System.out.print("Total Sum: "+sum);
    }
}