import java.util.Scanner;
public class Prob3 {
    public static void main(String[] args) {
        int x;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter x: ");
        x = scanner.nextInt();
    
        for(int i = 1; i <= 1000; i++) {
            System.out.println(i);
            if(i % x == 0)
                break;
        }
    }
}