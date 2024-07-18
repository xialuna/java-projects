import java.util.Scanner;
public class Prob2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter current pocket money: ");
        int money = scanner.nextInt();
        
        if(money >= 0){
            System.out.println(money);
            if(money % 10 == 7)
                System.out.println("Such lucky money!");
            else
                System.out.println("Just normal money.");
        }else
            System.out.println("Stop lying, tell me what's in your pocket!");
        
            
    }
}