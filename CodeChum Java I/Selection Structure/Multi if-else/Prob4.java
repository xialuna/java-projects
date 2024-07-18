import java.util.Scanner;
public class Prob4{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter decimal value 1: ");
        float year1 = scanner.nextFloat();
        System.out.print("Enter decimal value 2: ");
        float year2 = scanner.nextFloat();
        System.out.print("Enter decimal value 3: ");
        float year3 = scanner.nextFloat();

        float total = year1 + year2 + year3;
        
        if(total < 200000)
            System.out.println("average");
        else if(total < 400000)
            System.out.println("rich");
        else if(total < 600000)
            System.out.println("super rich");
        else
            System.out.println("crazy rich");
    }
}