import java.util.Scanner;

enum DesignFlags {
    BOLD(53),
    ITALICS(73),
    UNDERLINE(15);
    
    private final int value;

    DesignFlags(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static DesignFlags getByValue(int value){
        for(DesignFlags flag : DesignFlags.values()){
            if(flag.value == value){
                return flag;
            }
        }
        throw new IllegalArgumentException("Invalid input");
    }
}

public class Prob2{
    public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        System.out.print("Enter design flag value: ");
        int value = scanner.nextInt();

        try{
            DesignFlags flag = DesignFlags.getByValue(value);
            System.out.println(flag);
        }catch(IllegalArgumentException e){
            System.out.println("Not a valid design flag");
        }
        

	}
}