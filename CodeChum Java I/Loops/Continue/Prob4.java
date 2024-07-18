import java.util.Scanner;
public class Prob4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first integer: ");
        int x = scanner.nextInt();
        System.out.print("Enter second integer: ");
        int y = scanner.nextInt();
        System.out.print("Enter third integer: ");
        int z = scanner.nextInt();

        for(int i = x; i <= y; i++){
            if(i % z == 0)
                continue;
            System.out.println(i);
        }
    }
}