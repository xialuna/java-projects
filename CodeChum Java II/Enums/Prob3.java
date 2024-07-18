import java.util.Scanner;

enum Suit {
    CLUB(1),
    DIAMOND(2),
    HEART(3),
    SPADE(4);

    private final int value;

    Suit(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Suit getByValue(int value){
        for(Suit suit : Suit.values()){
            if(suit.value == value){
                return suit;
            }
        }
        throw new IllegalArgumentException("Invalid input");
    }
}


public class Prob3{
    public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++){
            System.out.printf("Enter number %d: ",i+1);
            int userInput = scanner.nextInt();
            try{
                 Suit.getByValue(userInput);
            }catch(IllegalArgumentException e){
                System.out.println("Invalid suit!");
                i--;
                continue;
            }
                
        }


	}
}