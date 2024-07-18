import java.util.Scanner;

enum Currency {
    PHP,
    USD,
    CAD,
    GBP
}

public class Prob5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter currency: ");
        String userInput = scanner.nextLine();
        
        Currency currency = Currency.valueOf(userInput);

        switch(currency){
            case PHP:
                System.out.println("Philippines");
                break;
            case USD:
                System.out.println("USA");
                break;
            case CAD:
                System.out.println("Canada");
                break;
            case GBP:
                System.out.println("Britain");
                break;
        }
	}
}