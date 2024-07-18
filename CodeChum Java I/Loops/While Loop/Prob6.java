import java.util.Scanner;
public class Prob6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter start: ");
        float start = scanner.nextFloat();

        while(start < 0){
            System.out.print("\nEnter a decimal number: ");
            float value = scanner.nextFloat();
            start += value;
            System.out.println(String.format("Start current value: %.2f", start));
        }

    }
}