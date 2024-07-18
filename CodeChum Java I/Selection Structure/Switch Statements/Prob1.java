import java.util.Scanner;
public class Prob1{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter age category: ");
        char choice = scanner.next().charAt(0);

        switch(choice){
            case 'B':
                System.out.println("Baby = P0.00");
                break;
            case 'T':
                System.out.println("Teenager = P2000.00");
                break;
            case 'A':
                System.out.println("Adult = P15000.00");
                break;
            case 'S':
                System.out.println("Senior Citizen = P4000.00");
                break;
        }
    }
}