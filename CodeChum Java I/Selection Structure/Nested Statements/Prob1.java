import java.util.Scanner;
public class Prob1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter years of work: ");
        int year = scanner.nextInt();
        System.out.print("Enter kind of work: ");
        int kind = scanner.next().charAt(0);

        if(kind == 'B'){
            if(year < 2)
                System.out.print("Salary: 10,000");
            else if(year < 5)
                System.out.print("Salary: 12,000");
            else
                System.out.print("Salary: 15,000");
        }else{
            if(year < 2)
                System.out.print("Salary: 20,000");
            else if(year < 5)
                System.out.print("Salary: 40,000");
            else
                System.out.print("Salary: 75,000");
        }
            
    }
}