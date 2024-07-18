import java.util.Scanner;
public class Prob4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while(true) {
            int n;
    
            n = scanner.nextInt();
            System.out.println("You've inputted " + n);
            if(n == 0)
                break;
        }
    }
}