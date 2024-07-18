import java.util.Scanner;
public class Prob5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a single integer: ");
        int num= scanner.nextInt();

        System.out.println(num);
        if(num % 2 == 0 && num != 0){
            System.out.println("even");
        }
    }
}