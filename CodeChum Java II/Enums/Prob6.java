import java.util.Scanner;

enum Season {
    SPRING(1),
    SUMMER(2),
    AUTUMN(3),
    WINTER(4);

    private final int value;

    Season(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Season getByValue(int value){
        for(Season season : Season.values()){
            if(season.value == value){
                return season;
            }
        }
        throw new IllegalArgumentException("Invalid input");
    }
}


public class Prob6 {
    public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        do{
            System.out.print("Enter an integer: ");
            int value = scanner.nextInt();
            try{
                System.out.println(Season.getByValue(value));
            }catch(IllegalArgumentException e){
                break;
            }
                
        }while(true);


	}
}