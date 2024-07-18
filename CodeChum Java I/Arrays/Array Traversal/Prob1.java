/*
 Create an array by asking the user to input the size of an
array and its elements.
Then print all of its elements on the next line in one line,
separated by a comma with a space, starting from index 0.
 */

 import java.util.Scanner;
public class Prob1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        int[] arr = new int[size];
        for(int i = 0; i < size; i++){
            System.out.print(String.format("Enter element #%d: ",i+1));
            arr[i] = scanner.nextInt();
        }

        for(int i = 0; i < size; i++){
            System.out.print(arr[i]);
            if(i != size - 1){
                System.out.print(", ");
            }
        }
        
    }
}