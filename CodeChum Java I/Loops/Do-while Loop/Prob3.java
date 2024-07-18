import java.util.Scanner;
public class Prob3 {
    public static void main(String[] args) {
        int value = 0, sum = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter target value: ");
        int target = scanner.nextInt();

        System.out.println("Enter the values: ");
        do{
            value = scanner.nextInt();
            if (value == -1){
                break;
            }
            sum += value;
        }while(sum < target);

        System.out.print("Sum: "+sum);
    }
}