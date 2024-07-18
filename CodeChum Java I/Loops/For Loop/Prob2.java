import java.util.Scanner;
public class Prob2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of x: ");
        int x = scanner.nextInt();
        System.out.print("Enter the value of y: ");
        int y = scanner.nextInt();

        for(int i = x; i <= y; i++){
            System.out.print(i);
            if(i % 5 == 0){
                System.out.print(" Divisible by 5 spotted!");
            } 
            System.out.println();
        }
    }
}