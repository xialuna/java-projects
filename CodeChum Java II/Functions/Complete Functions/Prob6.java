import java.util.Scanner;

public class Prob6 {
    public static float min(float a, float b, float c){
        float min = (a < b && a < c)? a : (b < c)? b : c;
        return min;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first value: ");
        float a = scanner.nextFloat();
        System.out.print("Enter second value: ");
        float b = scanner.nextFloat();
        System.out.print("Enter third value: ");
        float c = scanner.nextFloat();

        System.out.printf("Minimum Value: %.3f" , min(a,b,c));
    }
}