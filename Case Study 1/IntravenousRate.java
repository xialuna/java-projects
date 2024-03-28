import java.util.Scanner;
public class IntravenousRate {
    private static Scanner in = new Scanner(System.in);
    public static int get_problem(){
        System.out.println("\nEnter the number of the problem you wish to solve.");
        System.out.println("\tGIVEN A MEDICAL ORDER IN  \t  CALCULATE RATE IN");
        System.out.println("(1) ml/hr & tubing drop factor\t\t\tdrops / min");
        System.out.println("(2) 1 L for n hr\t\t\t\tml / hr");
        System.out.println("(3) mg/kg/hr & concentration in mg/ml\t\tml / hr");
        System.out.println("(4) units/hr & concentration in units/ml\tml / hr");
        System.out.println("(5) QUIT");
        System.out.print("Problem => ");
        return in.nextInt();
    }
    //Problem 1: gets user input and return function
    public static int get_rate_drop_factor(){
        System.out.print("Enter rate in ml/hr => ");
        float rate = in.nextFloat();
        System.out.print("Enter tubing/'s drop factor (drops/ml) => ");
        float dropFactor = in.nextFloat();
        return fig_drops_min(rate,dropFactor);//idk if pwsede ito since di siya inispecify sa instruc
    }

    //Problem 3
    public static int get_kg_rate_conc(){
        System.out.print("Enter rate in mg/kg/hr => ");
        float rate = in.nextFloat();
        System.out.print("Enter patient weight in kg => ");
        float weight = in.nextFloat();
        System.out.print("Enter concentration in mg/ml => ");
        float concentration = in.nextFloat();

        return by_weight(rate, weight, concentration);
    }

    //Problem 4
    public static int get_units_conc(){
        System.out.print("Enter rate in units/hr => ");
        float rate = in.nextFloat();
        System.out.print("Enter concentration in units/ml => ");
        float concentration = in.nextFloat();
        
        return by_units(rate, concentration);
    }

    //Problem 1: returns drops/min (rounded to nearest whole drop)
    public static int fig_drops_min(float rate, float dropFactor){
        return Math.round((dropFactor*rate)/60);
    }

    //Problem 2: returns ml/hr
    public static int fig_ml_hr(float hours){
        return Math.round((1000)/hours);
    }

    //Problem 3: 
    public static int by_weight(float rate, float weight, float concentration){
        return Math.round((rate * weight)/concentration);
    }

    //Problem 4:
    public static int by_units(float rate, float concentration){
        return Math.round(rate/concentration);
    }
    
    public static void main(String[] args){
        int choice;
        System.out.println("INTRAVENOUS RATE ASSISTANT");
        
        do{
            choice = get_problem(); //can also set to string and use parseInt to detect character
            switch (choice){
                case 1:{
                    System.out.println("The drop rate per minute is " + get_rate_drop_factor()+ ".");
                    break;
                }case 2:{
                    System.out.print("Enter number of hours => " );
                    float hours = in.nextFloat();
                    System.out.println("The drop rate per minute is " + fig_ml_hr(hours)+ ".");
                    break;
                }case 3:{
                    System.out.println("The drop rate per minute is " + get_kg_rate_conc()+ ".");
                    break;
                }case 4:{
                    System.out.println("The drop rate per minute is " + get_units_conc()+ ".");
                    break;
                }case 5:{
                    break;
                }default:{
                    System.out.println("Invalid Input! Try Again");
                }
            }
        }while(choice != 5);
    }
}
