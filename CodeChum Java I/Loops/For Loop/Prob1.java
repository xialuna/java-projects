import java.util.Scanner;
public class Prob1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer n: ");
        int n = scanner.nextInt();

        System.out.println("The values that are divisible by 3 from 1 to "+ n +" are:");

        for(int i = 1; i <= n; i++){
            if(i % 3 == 0){
                System.out.println(i);
            }
            
        }
    }
}