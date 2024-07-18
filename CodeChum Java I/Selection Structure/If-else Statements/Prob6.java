/*
 * Ask the user to input three decimal values, x, y, and z.

Then, check if the value of z is within the range of x and y
(inclusive).
If it is, print "{z} is within {x} and {y}" on the next line,
otherwise print "{z} is outside {x} and {y}".
 */

 import java.util.Scanner;
public class Prob6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float max, min;
        System.out.print("Enter x: ");
        float x= scanner.nextFloat();
        System.out.print("Enter y: ");
        float y= scanner.nextFloat();
        System.out.print("Enter z: ");
        float z= scanner.nextFloat();

        if (x > y){
            max = x; 
            min = y;
        }else{
            max = y; 
            min = x;
        }
        if(z >= min && z <= max)
            System.out.println(String.format("%.2f is within %.2f and %.2f",z,x,y));
        else
            System.out.println(String.format("%.2f is outside %.2f and %.2f",z,x,y));
    }
}