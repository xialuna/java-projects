/**
 * @author GROUP 2 - BSIT 2-4
 * Cheng, Xian Hui B.
 * Pascual, Ian Nevri B.
 * Quinto, Raven Luke E.
 * 
 * OOP - CASE STUDY 1 (Item #1: Intravenous Rate Assistant)
 */

 import java.util.Scanner;

 public class IntravenousRateAssistant {
 
     private static final Scanner scanner = new Scanner(System.in);
     
     // Method to prompt user to select a problem
     static int get_problem() {
         System.out.println("Enter the number of the problem you wish to solve.");
         System.out.println("\t GIVEN A MEDICAL ORDER IN \t      CALCULATE RATE IN");
         System.out.println("(1)  ml/hr & tubing drop factor \t\t drops / min");
         System.out.println("(2)  1 L for n hr \t\t\t\t ml / hr");
         System.out.println("(3)  mg/kg/hr & concentration in mg/ml \t\t ml / hr");
         System.out.println("(4)  units/hr & concentration in units/ml \t ml / hr");
         System.out.println("(5)  QUIT");
 
         System.out.print("Problem => ");
         return scanner.nextInt();
     } 
 
     // Method to prompt user for data required in Problem 1 and returns it
     static float[] get_rate_drop_factor() {
         System.out.print("Enter rate in ml/hr=> ");
         float mlRateInput = scanner.nextFloat();
         System.out.print("Enter tubing's drop factor (drops/ml)=> ");
         float dropFactorInput = scanner.nextFloat();
         return new float[] {mlRateInput, dropFactorInput};     
     }
 
     // Method to prompt user for data required in Problem 3 and returns it
     static float[] get_kg_rate_conc() {
         System.out.print("Enter rate in mg/kg/hr=> ");
         float mgRateInput = scanner.nextFloat();
         System.out.print("Enter patient weight in kg=> ");
         float patientWeightInput = scanner.nextFloat();
         System.out.print("Enter concentration in mg/ml=> ");
         float concInput = scanner.nextFloat();
         return new float[] {mgRateInput, patientWeightInput, concInput};
     }
 
     // Method to prompt user for data required in Problem 4 and returns it
     static float[] get_units_conc() {
         System.out.print("Enter rate in units/hr=> ");
         float unitsRateInput = scanner.nextFloat();
         System.out.print("Enter concentration in units/ml=> ");
         float unitsConcInput = scanner.nextFloat();
         return new float[] {unitsRateInput, unitsConcInput};
     }
 
     // Method to calculate drop rate per minute rounded to nearest whole (Calculates Problem 1)
     static int fig_drops_min(float mlRate, float dropFactor) {
        return Math.round((dropFactor * mlRate)/60);
     }
 
     // Method to calculate rate in ml/hr given number of hours (Calculates Problem 2)
     static int fig_ml_hr(int numHr) {
        return Math.round((1000)/numHr);
     }
 
     // Method to calculate rate in ml/hr (Calculates Problem 3)
     static int by_weight(float rate, float patientWeight, float concentration) {
        return Math.round((rate * patientWeight)/concentration);
     }
 
     // Method to calculate rate in ml/hr (Calculates Problem 4)
     static int by_units(float rateUnits, float concUnits) {
         return Math.round(rateUnits / concUnits);
     }
 
     public static void main(String[] args) {
 
         System.out.println("INTRAVENOUS RATE ASSISTANT\n");
         int choice;
 
         // Loop to repeatedly prompt user for problem selection until they choose to quit
         do {
             choice = get_problem();
             switch(choice) {
                case 1:
                // Prompt user for rate in ml/hr & tubing drop factor and assigns it to respective variables
                    float[] rateDropFactorArr = get_rate_drop_factor();
                    float mlRate = rateDropFactorArr[0];
                    float dropFactor = rateDropFactorArr[1];
                // Calculate and display the drop rate per minute
                    System.out.println("The drop rate per minute is " + fig_drops_min(mlRate, dropFactor) + ".\n");
                    break;
                case 2:
                // Prompt user for number of hours 
                    System.out.print("Enter number of hours=> ");
                    int numHr = scanner.nextInt();
                // Calculate and display the rate in milliliters per hour
                    System.out.println("The rate in milliliters per hour is " + fig_ml_hr(numHr) + ".\n");
                    break;
                case 3:
                // Prompt user for rate(mg/kg/hr), patient weight(kg),& concentration (mg/ml) and assigns it to respective variables
                    float[] kgRateConcArr = get_kg_rate_conc();
                    float mgRate = kgRateConcArr[0];
                    float patientWeight = kgRateConcArr[1];
                    float conc = kgRateConcArr[2];
                // Calculate and display the rate in milliliters per hour based on weight
                    System.out.println("The rate in milliliters per hour is " + by_weight(mgRate, patientWeight, conc) + ".\n");
                    break;
                case 4:
                // Prompt user for rate(units/hr) & concentration (units/ml) and assigns it to respective variables
                    float[] unitcsConcArr = get_units_conc();
                    float rateUnits = unitcsConcArr[0];
                    float concUnits = unitcsConcArr[1];
                // Calculate and display the rate in milliliters per hour based on units
                    System.out.println("The rate in milliliters per hour is " + by_units(rateUnits, concUnits) + ".\n");
                    break;
                case 5:
                    System.out.println("Thank you for using the program!");
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
                    break;
            }
            
         } while(choice != 5);
 
         scanner.close();
     } 
 }
 