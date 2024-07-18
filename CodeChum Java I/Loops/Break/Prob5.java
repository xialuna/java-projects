import java.util.Scanner;
public class Prob5 {
    public static void main(String[] args) {
        int n;
        Scanner scanner = new Scanner(System.in);
    
        System.out.print("Enter integer value: ");
        n = scanner.nextInt();
        while(true){
            System.out.println(n%10);
            if ((n%10) % 4 == 0)
                break;
            n /= 10;
        }
    }
}