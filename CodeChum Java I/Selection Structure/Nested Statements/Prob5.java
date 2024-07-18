import java.util.Scanner;
public class Prob5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Choose the programming language you like best: ");
        int choice = scanner.nextInt();
        
        switch(choice){
            case 1:
                System.out.println("You like C best");
                break;
            case 2:
                System.out.println("You like C++ best");
                break;
            case 3:
                System.out.println("You like Java best");
                break;
            case 4:
                System.out.println("You like C# best");
                break;
            case 5:{
                System.out.println("You like Python best");
                System.out.print("Enter type of development: ");
                char devType = scanner.next().charAt(0);
                if(devType == 'C'){
                    System.out.println("Backend");
                    System.out.print("Do you know any frameworks? ");
                    char f_choice = scanner.next().charAt(0);
                    if (f_choice == 'y'|| f_choice == 'Y'){
                        System.out.println("Wow, you're good!");
                    }
                    break;
                }
                System.out.println((devType == 'A')?"Web" : "Data Analytics");
                break;
            }
        }
            
    }
}