import java.util.Scanner;
public class Prob2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter integer x: ");
        int x = scanner.nextInt();
        System.out.print("Enter integer y: ");
        int y = scanner.nextInt();

        int sum = 0;
        for(int i = x; i <= y; i++){
            if(i % 7 != 0){
                sum += i;
            }else
                continue;   
        }
        System.out.println("Sum of all numbers: "+sum);
    }
}