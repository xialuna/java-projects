import java.util.Scanner;
public class Prob4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a value: ");
        int remaining_value = scanner.nextInt();
        int new_remaining_value = remaining_value;

        System.out.println();
        while(new_remaining_value > 0){
            System.out.print("Enter subtrahend: ");
            int subtrahend = scanner.nextInt();
            new_remaining_value -= subtrahend;
            System.out.println(String.format("%d - %d = %d",remaining_value,subtrahend,new_remaining_value));
            remaining_value = new_remaining_value;
        }
    }
}