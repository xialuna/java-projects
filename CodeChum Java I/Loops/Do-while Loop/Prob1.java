import java.util.Scanner;
public class Prob1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int digits = scanner.nextInt();

        int num_dig = 0;

        do{
            digits /= 10;
            num_dig++;
        }while(digits!= 0);

        System.out.print("Number of digits: "+num_dig);
    }
}