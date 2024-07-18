import java.util.Scanner;
public class Prob1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter element x: ");
        int x = scanner.nextInt();
        System.out.print("Enter element y: ");
        int y = scanner.nextInt();
        
        while(x <= y) {
            System.out.println(x);
            if (x % 11 == 0)
                break;
            x += 1;
        }
    }
}