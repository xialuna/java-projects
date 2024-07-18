/*
 * Ask the user to input their birth year.

Then, assuming that it's January 1, 2022 today and their
birthdate is also on January 1, compute for their age.
Print "senior citizen" on the next line if their age is at least
60 years old, otherwise print "not senior citizen".
 */

import java.util.Scanner;
public class Prob4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your birth year: ");
        int birthYear = scanner.nextInt();

        int age = 2022 - birthYear;

        if(age >= 60)
            System.out.println("senior citizen");
        else
            System.out.println("not senior citizen");
    }
}