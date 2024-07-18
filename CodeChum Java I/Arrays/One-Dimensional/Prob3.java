/*
 * Ask the user create an integer array by asking them to input
the size of the array and its elements.
Then, print the last element of the array on the next line.
 */

import java.util.Scanner;
public class Prob3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter array size: ");
        int size = scanner.nextInt();
        System.out.println("Enter elements of the array: ");

        int[] arr = new int[size];
        
        for(int i = 0; i < size; i++){
            arr[i] = scanner.nextInt();
        }

        System.out.print("Last element: " + arr[size - 1]);
    }
}