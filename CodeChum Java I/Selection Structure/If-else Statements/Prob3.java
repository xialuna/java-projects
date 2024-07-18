/*
 An integer total is initialized in the code editor.

Ask the user to input two positive integers and for each
values, add it to total if it is even, otherwise subtract.
Print the final value of total on the next line.
 */

 import java.util.Scanner;
public class Prob3 {
    public static void main(String[] args) {

        int total = 50;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first positive integer: ");
        int num1= scanner.nextInt();
        System.out.print("Enter second positive integer: ");
        int num2= scanner.nextInt();

        if(num1 % 2 == 0)
            total += num1;
        else
            total -= num1;

        if(num2 % 2 == 0)
            total += num2;
        else
            total -= num2;

        
        System.out.println(total);
    }
}