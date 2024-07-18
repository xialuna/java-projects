/*
Ask the user to create an integer array by inputting the size
of an array and its elements.

If the size of the array is odd, print the middle of the array.
If the size of the array is even, print the two middle elements
instead.
 */

import java.util.Scanner;
public class Prob6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter array size: ");
        int size = scanner.nextInt();
        System.out.println("Enter elements of the array: ");

        int[] arr = new int[size];
        for(int i = 0; i < size; i++){
            arr[i] = scanner.nextInt();
        }

        int median = (size / 2) - 1;

        if(size % 2 == 0){
            System.out.print(String.format("Medians: %d and %d",arr[median], arr[median + 1]));
        }else{
            System.out.print("Median: " + arr[median+1]);
        }

        
    }
}