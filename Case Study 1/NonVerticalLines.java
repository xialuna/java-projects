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
//Choice: 1 Prompts the user for the x-y coordinates of both points 
    public static float[][] get2_pt(){
        float[][] coords = new float[2][2]; //pwede rin dito yung di na mag-parse, 4 float variables nalang gamitin (like ginawa ko sa choice 2), pero same sila na 5 spaces marereserve
        String[] input;
        for(int i = 0; i < 2; i++){
            System.out.printf("Enter the x-y coordinates of the %s point separated by a space =>\n",(i == 0)? "first":"second");
            input = (in.nextLine()).split(" ");
            coords[i][0] = Float.parseFloat(input[0]);
            coords[i][1] = Float.parseFloat(input[1]);
        }return coords;
    }

//Choice 2: Prompts the user for the slope and x-y coordinates of the point
    public static float[] get_pt_slope(){
        System.out.print("Enter the slope=> ");
        float slope = in.nextFloat();
        in.nextLine();
        System.out.print("Enter the x-y coordinates of the point separated by a space=> ");
        float x = in.nextFloat();
        float y = in.nextFloat();

        return new float[]{x,y,slope};
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

//Display Choice 1(Two-point form)
    public static void display2_pt(float p1_x, float p1_y, float p2_x, float p2_y){
        System.out.println("Two-point form");
        System.out.printf("\t(%.2f - %.2f)\n", p2_y,p1_y);
        System.out.println("m = ----------------------");
        System.out.printf("\t(%.2f - %.2f)\n",p2_x,p1_x);   
    }
    
    public static void display_pt_slope(float x, float y, float slope){
        System.out.println("\nPoint-slope form");
        System.out.printf("y - %.2f = %.2f (x - %.2f) \n", x,slope,y);
    }

    public static void display_slope_intcpt(float slope, float y_intercept){
        System.out.println("\nSlope-intercept form");
        System.out.printf("y = %.2fx + %.2f\n", slope,y_intercept);
    }

    public static void main(String[] args){
        char choice; 
        do{
            switch (get_problem()){
                case 1:{
                    in.nextLine();
                    float[][] coords = get2_pt();
                    float[] result = slope_intcpt_from2_pt(coords[0][0],coords[0][1], coords[1][0], coords[1][1]);
                    display2_pt(coords[0][0],coords[0][1], coords[1][0], coords[1][1]);
                    display_slope_intcpt(result[0], result[1]);
                    break;
                }case 2:{
                    float[] coords = get_pt_slope();
                    display_pt_slope(coords[0], coords[1], coords[2]);
                    display_slope_intcpt(coords[2],intcpt_from_pt_slope(coords[0], coords[1], coords[2]));
                    break;
                }default:{
                    break;
                }
            }System.out.print("\nDo another conversion (Y or N)=> ");
            choice = Character.toUpperCase(in.next().charAt(0));

        }while(choice == 'Y');
    }
}
