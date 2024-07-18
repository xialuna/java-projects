/*
 * Ask the user to create two integer arrays by inputting the size
of an array and its respective elements.

Print the sum of the first element of the first array and the last
element of the second array on the next line.
Also, print the product of the second element of the first array
with the second to the last element of the second array on the
next line.
 */
import java.util.Scanner;
public class Prob5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter size of the first array: ");
        int size1 = scanner.nextInt();
        System.out.println("Enter elements of the first array: ");

        int[] arr1 = new int[size1];
        
        for(int i = 0; i < size1; i++){
            arr1[i] = scanner.nextInt();
        }

        
        System.out.print("Enter size of the second array: ");
        int size2 = scanner.nextInt();
        System.out.println("Enter elements of the second array: ");

        int[] arr2 = new int[size2];
        
        for(int i = 0; i < size2; i++){
            arr2[i] = scanner.nextInt();
        }

    
        System.out.println("Sum of first and last: " + (arr1[0] + arr2[size2-1]));
        System.out.println("Product of second and second to the last: " + (arr1[1] * arr2[size2-2]));
        
    }
}