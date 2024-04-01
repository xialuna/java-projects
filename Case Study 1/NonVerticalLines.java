import java.util.Scanner;

public class NonVerticalLines {
    private static Scanner in = new Scanner(System.in);

    // Displays menu for user to choose the problem type
    public static int get_problem(){
        System.out.println("Select the form that you would like to convert to slope-intercept form:");
        System.out.println("1) Two-point form (you know the points on the line)");
        System.out.println("2) Point-slope form (you know the line's slope and one point)");
        System.out.print("=> ");
        
        return in.nextInt();
    }

    // Prompts the user for the x-y coordinates of both points (Choice: 1)
    public static double[] get2_pt(){
        System.out.print("Enter the x-y coordinates of the first point separate by a space=> ");
        double x1 = in.nextDouble();
        double y1 = in.nextDouble();
        System.out.print("Enter the x-y coordinates of the second point separated by a space=> ");
        double x2 = in.nextDouble();
        double y2 = in.nextDouble();

        return new double[] {x1, y1, x2, y2};
    }

    // Prompts the user for the slope and x-y coordinates of the point (Choice: 2)
    public static double[] get_pt_slope(){
        System.out.print("Enter the slope=> ");
        double slope = in.nextFloat();
        System.out.print("Enter the x-y coordinates of the point separated by a space=> ");
        double x = in.nextFloat();
        double y = in.nextFloat();

        return new double[]{x,y,slope};
    }

    // Calculates slope and y-intercept from two points (Choice: 1)
    public static double[] slope_intcpt_from2_pt(double x1, double y1, double x2, double y2){
        double slope = (y2 - y1)/(x2 - x1); 
        double y_intercept = y1 - slope * x1;

        return new double[] {slope,y_intercept};
    }

    // Calculates y-intercept from point-slope form (Choice: 2)
    public static double intcpt_from_pt_slope(double x, double y, double slope){
        return y - slope * x;
    }

    // Displays the two-point form equation
    public static void display2_pt(double x1, double y1, double x2, double y2){
        System.out.println("Two-point form");
        System.out.printf("\t(%.2f - %.2f)\n", y2, y1);
        System.out.println("m = ----------------------");
        System.out.printf("\t(%.2f - %.2f)\n",x2, x1);   
    }
    
    // Displays the point-slope form equation
    public static void display_pt_slope(double x, double y, double slope){
        System.out.println("\nPoint-slope form");
        System.out.printf("y - %.2f = %.2f (x - %.2f) \n", x, slope, y);
    }

    // Displays the slope-intercept form equation
    public static void display_slope_intcpt(double slope, double y_intercept){
        System.out.println("\nSlope-intercept form");
        System.out.printf("y = %.2fx + %.2f\n",slope, y_intercept);
    }

    public static void main(String[] args){
        char choice; 
        do{
            switch (get_problem()){
                //Slope-intercept form to Two-point form 
                case 1:{
                    in.nextLine();  // Consumes excess newline left by previous input
                    double[] coords = get2_pt(); // Retrieves and assign the x-y coordinates of two points from the user
                    double x1 = coords[0], y1 = coords[1], x2 = coords[2], y2 = coords[3]; 
                    double[] result = slope_intcpt_from2_pt(x1, y1 ,x2 ,y2); //Assign slope and y-intercept
                    double slope = result[0], y_intercept = result[1];  
                    display2_pt(x1, y1, x2, y2);
                    display_slope_intcpt(slope, y_intercept);
                    break;
                }//Slope-intercept form to Point-slope form
                case 2:{ 
                    double[] coords = get_pt_slope(); // Retrieves and assign slope and coordinates of a point from the user
                    double x = coords[0], y = coords[1], slope = coords[2]; 
                    display_pt_slope(x, y, slope);
                    display_slope_intcpt(slope, intcpt_from_pt_slope(x, y, slope));
                    break;
                }default:{//If user input is not 1 or 2
                    System.out.println("\nInvalid input. Please try again.");
                    break;
                }
            }
            System.out.print("\nDo another conversion (Y or N)=> "); 
            choice = Character.toUpperCase(in.next().charAt(0));
        } while(choice == 'Y');//ends when user inputs another  character other than 'Y'/'y'
    } 
}
