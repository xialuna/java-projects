import java.util.Scanner;
public class Prob4{
    public static void main(String[] args) {
        int total = 10;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int num = scanner.nextInt();
        
        if(num == 0)
            System.out.println("Nothing happened");
        else{
            if(num < 0){
                System.out.print("Enter another integer: ");
                int exponent = scanner.nextInt();
                total += Math.pow(num,exponent);
            }else{
                if(num % 2 == 0)
                    total += Math.pow(num, 2);
                else
                    total += Math.pow(num, 3);
            }
            System.out.println(total);
        }       
    }
}