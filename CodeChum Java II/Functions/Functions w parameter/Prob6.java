import java.util.Scanner;
public class Prob6 {
    public static void reverseInt(int num){
        while(num > 0){
            System.out.print(num%10);
            num/=10;
        }
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int num = scanner.nextInt();
        reverseInt(num);
    }
}