import java.util.Scanner;
public class Prob4 {
    public static void main(String[] args) {
        char choice;
        Scanner scanner = new Scanner(System.in);

        do{
            System.out.print("Do you still want to play [Y/N]: ");
            choice = scanner.next().charAt(0);
            choice = Character.toLowerCase(choice);
            if (choice != 'n' && choice != 'y')
                System.out.println("Wrong answer");
            
        }while(choice != 'n');

    }
}