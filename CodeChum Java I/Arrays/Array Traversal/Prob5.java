/*
Write a program that creates an integer array by asking the
user to input the size of an array and its elements (one input
per line). Then, traverse through the array and compute for
the sum of the elements and its average.

Print the sum and average in 2 decimal places on the next
line in this format:

Sum: {value}
Average: {value.##}
 */
import java.util.Scanner;
public class Prob5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        int sum = 0;
        float average;
        int[] arr = new int[size];
        for(int i = 0; i < size; i++){
            System.out.print(String.format("Enter element #%d: ",i+1));
            arr[i] = scanner.nextInt();
        }

        for(int i = 0; i < size; i++){
            sum += arr[i];
        }
        average = (float)sum/size;

        System.out.print(String.format("Sum: %d\nAverage: %.2f",sum,average));
        
    }
}