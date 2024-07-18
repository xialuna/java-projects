import java.util.Scanner;
public class Prob1 {
    public static int factorial(int num){
        if(num == 0)
            return 1;
        else
            return num * factorial(num - 1);
        
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();

        System.out.print("Factorial of "+num+": "+ factorial(num));

    
    }
}