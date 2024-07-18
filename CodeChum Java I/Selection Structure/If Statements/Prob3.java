import java.util.Scanner;
public class Prob3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first decimal number: ");
        float num1= scanner.nextFloat();
        System.out.print("Enter second decimal number: ");
        float num2= scanner.nextFloat();

        System.out.println(String.format("%.2f %.2f",num1,num2));
        if(num1 > num2)
            System.out.println("The first one is greater than the second one");
    }
}