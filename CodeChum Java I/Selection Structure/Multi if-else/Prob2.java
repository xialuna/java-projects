import java.util.Scanner;
public class Prob2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a character: ");
        char gender = scanner.next().charAt(0);

        if(gender == 'm' || gender == 'M')
            System.out.println("Male");
        else if(gender == 'f' || gender == 'F')
            System.out.println("Female");
        else
            System.out.println("Prefer not to say");
    }
}