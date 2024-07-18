import java.util.Scanner;
public class Prob4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your grade: ");
        char choice = scanner.next().charAt(0);

        switch(choice){
            case 'A':
            case 'B':
                System.out.println("Good Job");
                break;
            case 'C':
                System.out.println("You're doing okay");
                break;
            case 'D':
            case 'F':
                System.out.println("You need to study harder");
                break;
            default:
                System.out.println("Stop lying and tell me your actual grade");
                break;
        }
    
    }
}