import java.util.Scanner;
public class Prob1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = scanner.nextInt();

        while(n % 3 != 0 || n % 5 != 0 ||n % 7 != 0 ){
            n++;
            if (n % 3 == 0 || n % 5 == 0 ||n % 7 == 0){
                break;
            }
        }
        System.out.print("Final value of n: " + n);
    }
}