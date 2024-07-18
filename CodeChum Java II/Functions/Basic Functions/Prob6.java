import java.util.Scanner;
public class Prob6 {
     public static void printHelloWorld() {
        System.out.println("Hello World");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int num = scanner.nextInt();

        for(int i = 1; i <= num;i++){
            printHelloWorld();
        }
    }
}