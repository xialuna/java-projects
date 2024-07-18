import java.util.Scanner;
public class Prob1 {
    public static void ageTeller(int age){
        System.out.println("Your age is "+age);
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        ageTeller(age);
    }
}