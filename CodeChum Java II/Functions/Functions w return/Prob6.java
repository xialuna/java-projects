import java.util.Scanner;
public class Prob6 {
    public static int[] getIntegers() {
        int[] num = new int[3];
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first integer: ");
        num[0] = scanner.nextInt();
        System.out.print("Enter second integer: ");
        num[1] = scanner.nextInt();
        System.out.print("Enter third integer: ");
        num[2] = scanner.nextInt();
        return num;
      }
    
    public static void main(String[] args) {
        int[] num = getIntegers();
        for(int i = 0; i < 3; i++){
            System.out.print(num[i]);
            if(i != 2)
                System.out.print(", ");
        }
    } 
}