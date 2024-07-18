import java.util.Scanner;
public class Prob2 {
    public static void main(String[] args) {
        int total = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter x: ");
        int x = scanner.nextInt();
        System.out.print("Enter y: ");
        int y = scanner.nextInt();


        while(total < x){
            total += y;
            System.out.println("Total: " + total);
        }
    }
}