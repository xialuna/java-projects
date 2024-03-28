import java.util.Scanner;
public class NonVerticalLines {
    private static Scanner in = new Scanner(System.in);
    public static int get_problem(){
        System.out.println("Select the form that you would like to convert to slope-intercept form:");
        System.out.println("1) Two-point form (you know the points on the line)");
        System.out.println("2) Point-slope form (you know the line's slope and one point)");
        System.out.print("=> ");
        return in.nextInt();
    }
/*
Choice: 1
Prompts the user for the x-y coordinates of both points, inputs the four coordinates,
and returns them to the calling function through output parameters. */
    public static float[] get2_pt(){
        float[][] coords = new float[2][2];
        String[] input;
        for(int i = 0; i < 2; i++){
            System.out.printf("Enter the x-y coordinates of the %s point separated by a space =>\n",(i == 0)? "first":"second");
            input = (in.nextLine()).split(" ");
            coords[i][0] = Float.parseFloat(input[0]);
            coords[i][1] = Float.parseFloat(input[1]);
        }
        return new float[]{coords[0][0],coords[0][1],coords[1][0],coords[1][1]};
    }

/*
Choice 2:
 Prompts the user for the slope and x-y coordinates of the point, inputs the three 
values and returns them to the calling function through output parameters.
 */
    public static float get_pt_slope(){
        float x,y;
        String[] input;
        System.out.print("Enter the slope=> ");
        float slope = in.nextFloat();
        in.nextLine();
        System.out.print("Enter the x-y coordinates of the point separated by a space=> ");
        input = (in.nextLine()).split(" ");
        x = Float.parseFloat(input[0]);
        y = Float.parseFloat(input[1]);
        
        return x;//change
    }


//Choice 1: returns through output parameters the slope (m) and y-intercept (b).
    public static float[] slope_intcpt_from2_pt(float p1_x, float p1_y, float p2_x, float p2_y){
        float slope = (p2_y - p1_y)/(p2_x - p1_x); //pwedeng tanggalin variaable pero for readability naglagay ako
        float y_intercept = p1_y - slope * p1_x;
        return new float[] {slope,y_intercept};
    }

//Choice 2: returns as the function value the y-intercept
    public static float intcpt_from_pt_slope(float x, float y, float slope){
        return y - slope * x;
    }

//Display Choice 1
    public static void display2_pt(float p1_x, float p1_y, float p2_x, float p2_y){
        System.out.println("Two-point form");
        System.out.printf("\t (%.2f - %.2f\n)", p2_y,p1_y);
        System.out.println("m = ----------------");
        System.out.printf("\t (%.2f - %.2f\n)",p2_x,p1_x);
        // System.out.println("\nSlope-intercept form");
        // System.out.printf("y = %.2fx + %.2f",get2_pt()[0],get2_pt()[1]);
        
    }
    

    public static void display_pt_slope(float x, float y, float slope){
        System.out.println("Point-slope form");
        System.out.printf("\t y - %/2f = %.2f (x - .2f)\n)", x,slope,y);
    }

    public static void display_slope_intcpt(float y, float slope){
        System.out.println("Slope-intercept form");
        System.out.printf("\t y = %.2fx - %.2f\n)", slope,y);
    }


    
    public static void main(String[] args){
        
       
    }
}
