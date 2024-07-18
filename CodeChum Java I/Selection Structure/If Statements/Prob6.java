import java.util.Scanner;
public class Prob6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first decimal number: ");
        float num1= scanner.nextFloat();
        System.out.print("Enter second decimal number: ");
        float num2= scanner.nextFloat();
        System.out.print("Enter third decimal number: ");
        float num3= scanner.nextFloat();

        System.out.print(String.format("%.2f %.2f",num1,num2));

        if(num3 > (num2 + num1)){
             System.out.print(String.format(" %.2f",num3));
        }
    }
}