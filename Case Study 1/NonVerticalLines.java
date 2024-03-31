import java.util.Scanner;
import java.math.RoundingMode;
import java.text.DecimalFormat;
public class NonVerticalLines {
    private static Scanner in = new Scanner(System.in);
    public static int get_problem(){
        System.out.println("Select the form that you would like to convert to slope-intercept form:");
        System.out.println("1) Two-point form (you know the points on the line)");
        System.out.println("2) Point-slope form (you know the line's slope and one point)");
        System.out.print("=> ");
        return in.nextInt();
    }
//Choice: 1 Prompts the user for the x-y coordinates of both points 
    public static double[] get2_pt(){
        System.out.print("Enter the x-y coordinates of the first point separate by a space=> ");
        double x1 = in.nextDouble();
        double y1 = in.nextDouble();
        System.out.print("Enter the x-y coordinates of the second point separated by a space=> ");
        double x2 = in.nextDouble();
        double y2 = in.nextDouble();
        return new double[] {x1, y1, x2, y2};
    }

//Choice 2: Prompts the user for the slope and x-y coordinates of the point
    public static double[] get_pt_slope(){
        System.out.print("Enter the slope=> ");
        double slope = in.nextFloat();
        System.out.print("Enter the x-y coordinates of the point separated by a space=> ");
        double x = in.nextFloat();
        double y = in.nextFloat();

        return new double[]{x,y,slope};
    }

//Choice 1: returns through output parameters the slope (m) and y-intercept (b).
    public static double[] slope_intcpt_from2_pt(double x1, double y1, double x2, double y2){
        double slope = (y2 - y1)/(x2 - x1); 
        double y_intercept = y1 - slope * x1;
        return new double[] {slope,y_intercept};
    }

//Choice 2: returns as the function value the y-intercept
    public static double intcpt_from_pt_slope(double x, double y, double slope){
        return y - slope * x;
    }

//Display Choice 1(Two-point form)
    public static void display2_pt(double x1, double y1, double x2, double y2){
        System.out.println("Two-point form");
        System.out.printf("\t(%.2f - %.2f)\n", y2, y1);
        System.out.println("m = ----------------------");
        System.out.printf("\t(%.2f - %.2f)\n",x2, x1);   
    }
    
    public static void display_pt_slope(double x, double y, double slope){
        System.out.println("\nPoint-slope form");
        System.out.printf("y - %.2f = %.2f (x - %.2f) \n", x, slope, y);
    }

    public static void display_slope_intcpt(double slope, double y_intercept){
        System.out.println("\nSlope-intercept form");
        System.out.printf("y = %.2fx + %.2f\n",slope, y_intercept);
    }

    public static void main(String[] args){
        char choice; 
        do{
            switch (get_problem()){
                case 1:{
                    in.nextLine();
                    double[] coords = get2_pt();
                    double x1 = coords[0], y1 = coords[1], x2 = coords[2], y2 = coords[3]; //assign coords[] values for readability
                    double[] result = slope_intcpt_from2_pt(x1, y1 ,x2 ,y2);
                    double slope = result[0], y_intercept = result[1]; //assign result[] values for readability
                    display2_pt(x1, y1, x2, y2);
                    display_slope_intcpt(slope, y_intercept);
                    break;
                }case 2:{
                    double[] coords = get_pt_slope();
                    double x = coords[0], y = coords[1], slope = coords[2]; //assign coords[] values for readability
                    display_pt_slope(x, y, slope);
                    display_slope_intcpt(slope, intcpt_from_pt_slope(x, y, slope));
                    break;
                }default:{
                    System.out.println("\nInvalid input. Please try again.");
                    break;
                }
            }System.out.print("\nDo another conversion (Y or N)=> ");
            choice = Character.toUpperCase(in.next().charAt(0));

        }while(choice == 'Y');
    }
}
