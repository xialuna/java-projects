/*
Write a program that creates an integer array by asking the
user to input the size of an array and its elements.

Then, print the even numbers of the array first in one line and
the odd numbers of the array on the next line.

Separate them by a comma and a space similar to this
format:

Even: #, #, #
Odd: #, #, #
 */
import java.util.Scanner;
public class Prob6{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        int last_even= 0, last_odd = 0;
        
        int[] arr = new int[size];
        for(int i = 0; i < size; i++){
            System.out.print(String.format("Enter element #%d: ",i+1));
            arr[i] = scanner.nextInt();
            if (arr[i] % 2 == 0) 
                last_even = arr[i];
            else
                last_odd = arr[i];
        }
        
        System.out.print("Even: "); 
        for(int i = 0; i < size; i++){
            if(arr[i] % 2 == 0){
                System.out.print(arr[i]);
                    if(arr[i] != last_even)
                        System.out.print(", ");
            }
        }

        System.out.print("\nOdd: "); 
        for(int i = 0; i < size; i++){
            if(arr[i] % 2 != 0){
                System.out.print(arr[i]);
                    if(arr[i] != last_odd)
                        System.out.print(", ");
            }
        }


        
    }
}