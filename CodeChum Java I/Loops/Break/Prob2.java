import java.util.Scanner;
public class Prob2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true) {

            int a, b;
            char op;
            
            System.out.print("Enter a: ");
            a = scanner.nextInt();
            
            System.out.print("Enter b: ");
            b = scanner.nextInt();
            
            System.out.print("Enter operator: ");
            op  = scanner.next().charAt(0);

            
            if(op == '+') {
                System.out.println(a + " + " + b + " = " + (a + b) + "\n");
            } else if (op == '-') {
                System.out.println(a + " - " + b + " = " + (a - b) + "\n");
            } else if (op == '*') {
                System.out.println(a + " * " + b + " = " + (a * b) + "\n");
            } else if (op == '/') {
                System.out.println(a + " / " + b + " = " + (a / b) + "\n");
            }else{
                break;
            }
        }
    }
}