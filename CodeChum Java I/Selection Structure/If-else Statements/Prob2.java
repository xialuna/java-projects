/*
 * Ask the user to input three integers, a, b, and c.
Compute for the sum of a and b and check if it is greater than
C.

If it is, print "yes", otherwise print "no".
Print it in this format: ** {a} + {b} > {c} = yes /no **
 */
import java.util.Scanner;
public class Prob2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a: ");
        int a= scanner.nextInt();
        System.out.print("Enter b: ");
        int b= scanner.nextInt();
        System.out.print("Enter c: ");
        int c= scanner.nextInt();

        System.out.print(a + " + " + b + " > " + c + " = ");
        if((a + b)>c)
            System.out.print("yes");
        else
            System.out.print("no");
    }
}