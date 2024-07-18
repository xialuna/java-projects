import java.util.Scanner;
public class Prob2 {
    public static int addTen() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int num = scanner.nextInt();
        return num + 10;
      }
    
    public static void main(String[] args) {
        System.out.print(addTen());
    }
}
