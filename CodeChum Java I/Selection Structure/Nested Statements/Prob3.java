import java.util.Scanner;
public class Prob3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        char endName = name.charAt((name.length() - 1));

        if (endName == 'a'||endName == 'e'||endName == 'i'||endName == 'o'||endName == 'u'){
            System.out.print("Enter age: ");
            int age= scanner.nextInt();

            if(age % 2 == 0)
                System.out.print("Wow, you're special!");
            else{
                System.out.print("Enter birth year: ");
                int year = scanner.nextInt();
                if(year % 2 == 0)
                    System.out.print("Oh, you're still special!");
                else
                    System.out.print("You will be special next year.");
            }
            
        }else{
            System.out.print("You're awesome!");
        }
            
    }
}