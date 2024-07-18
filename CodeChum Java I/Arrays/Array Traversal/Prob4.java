/*
Write a program that asks the user to input the size of an
array and its elements.

Print the elements on the next line, separated by a comma
and a space, in one line starting at the last element going to
the first element.
 */

 import java.util.Scanner;
 public class Prob4 {
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
         
         for(int i = size - 1; i >= 0; i--){
             System.out.print(arr[i]);
             if(i != 0){
                 System.out.print(", ");
             }
         }
     }
 }