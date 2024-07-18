/*
Write a program that asks the user to input an integer and
create two integer arrays with that size, then input the
elements (one input per line).

Create another integer array which contains the sum of the
elements between these two arrays with respect to their
indexes.

Print these elements in this format: "{array1[i]} +
{array2[i]} = {sum[i]}" (one equation per line)
 */

import java.util.Scanner;
public class Prob2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the arrays: ");
        int size = scanner.nextInt();

        int[] arr1 = new int[size];
        int[] arr2 = new int[size];
        System.out.println("Enter the elements of the first array:");
        for(int i = 0; i < size; i++){
            System.out.print(String.format("Enter element #%d: ",i+1));
            arr1[i] = scanner.nextInt();
        }

        System.out.println("Enter the elements of the second array:");
        for(int i = 0; i < size; i++){
            System.out.print(String.format("Enter element #%d: ",i+1));
            arr2[i] = scanner.nextInt();
        }

        for(int i = 0; i < size; i++){
            System.out.println(String.format("%d + %d = %d",arr1[i], arr2[i], arr1[i]+arr2[i]));
        }
        
    }
}