/*
 Write a program that creates an integer array by asking the
user to input the size and its elements (one input per line).
Then, ask for another integer input and check if that value
exists in the array.

Print "Found!" if it exists, otherwise print "Sorry, {value}
not found." on the next line.
 */
import java.util.Scanner;
public class Prob3{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int found = 0;
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        int[] arr = new int[size];
        System.out.println("Enter the elements of the array: ");
        for(int i = 0; i < size; i++){
            System.out.print(String.format("Enter element #%d: ",i+1));
            arr[i] = scanner.nextInt();
        }
        System.out.print("Enter a value to search for: ");
        int value = scanner.nextInt();
        

        for(int i = 0; i < size; i++){
            if(arr[i]==value)
                found = 1;
        }

        System.out.println((found == 1)?"Found!":"Sorry, "+value+" not found." );
        
    }
}