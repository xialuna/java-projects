/*
     * Write a program that creates an integer array based on the
user-inputted size and list of elements (one input per line).

After creating the array, ask for another integer input and
print the element at that index on the next line.
     */
import java.util.Scanner;
public class Prob2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter array size: ");
        int size = scanner.nextInt();
        System.out.println("Enter elements of the array: ");

        int[] arr = new int[size];
        
        for(int i = 0; i < size; i++){
            arr[i] = scanner.nextInt();
        }

        System.out.print("Enter an index: ");
        int index = scanner.nextInt();
        System.out.print(arr[index]);
    }
}
