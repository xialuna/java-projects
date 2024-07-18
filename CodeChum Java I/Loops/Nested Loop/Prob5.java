import java.util.Scanner;
public class Prob5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of weeks: ");
        int week_num = scanner.nextInt();

        for(int i = 1; i <= week_num; i++){
            System.out.println("Week #"+i);
            for(int j = 1; j<= 7; j++){
                System.out.print("  Day "+j);
                System.out.println();
            }
            System.out.println();
    }
    }   
}