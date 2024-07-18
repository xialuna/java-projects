import java.util.Scanner;

enum Week {
    MON(0),    // 0
    TUE(1),    // 1 
    WED(2),    // 2
    THU(3),    // 3
    FRI(4),    // 4
    SAT(5),    // 5
    SUN(6);   // 6

    private final int value;

    Week(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Week getByValue(int value){
        for(Week week : Week.values()){
            if(week.value == value){
                return week;
            }
        }
        throw new IllegalArgumentException("Invalid value");
    }
}


public class Prob1 {
    public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        System.out.print("Enter day number: ");
        int day = scanner.nextInt();

        Week week = Week.getByValue(day);
        
        switch(week){
            case MON:
                System.out.println("Monday");
                break;
            case TUE:
                System.out.println("Tuesday");
                break;
            case WED:
                System.out.println("Wednesday");
                break;
            case THU:
                System.out.println("Thursday");
                break;
            case FRI:
                System.out.println("Friday");
                break;
            case SAT:
                System.out.println("Saturday");
                break;
            case SUN:
                System.out.println("Sunday");
                break;
        }

        

	}
}