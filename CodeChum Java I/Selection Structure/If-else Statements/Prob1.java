/*
 * Ask the user for their age.

If their age is at least 18 years old, print "adult" on the next
line, otherwise print "minor".
 */

import java.util.Scanner;
public class Prob1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter age: ");
        int age= scanner.nextInt();

        if(age >= 18)
            System.out.println("adult");
        else
            System.out.println("minor");
    }
}