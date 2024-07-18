import java.util.Scanner;
public class Prob6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter grade level: ");
        int level = scanner.nextInt();

        switch(level){
            case 1:
                System.out.println("Freshies");
                break;
            case 2:
                System.out.println("Sophomores");
                break;
            case 3:
                System.out.println("Juniors");
                break;
            case 4:
                System.out.println("Seniors");
                break;
            default:
                System.out.println("N/A");
                break;
            
        }
    }
}