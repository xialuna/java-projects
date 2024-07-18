import java.util.Scanner;
public class Prob5 {
    public static void max(float num1, float num2){
        System.out.printf("%.2f",num1 > num2?num1:num2);
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first decimal number: ");
        float num1 = scanner.nextFloat();
        System.out.print("Enter second decimal number: ");
        float num2 = scanner.nextFloat();

        max(num1, num2);
    }
}