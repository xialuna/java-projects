/*
Ask the user to input the rows and columns of a
multidimensional integer array and its elements.
Loop through the multidimensional array and find the largest
element.

Print the largest element on the next line in this format:
"Largest: {number}"
 */
import java.util.Scanner;
public class Prob6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number of rows: ");
        int row_size = scanner.nextInt();
        System.out.print("Enter number of columns: ");
        int col_size = scanner.nextInt();

        int[][] arr = new int[row_size][col_size];
        
        for(int i=0; i<row_size; i++){
            for(int j=0; j<col_size; j++){
                System.out.print(String.format("Enter element at row %d, column %d: ", i, j));
                arr[i][j] = scanner.nextInt();
            }
        }
      int largest = arr[0][0];
        for(int i=0; i<row_size; i++){
            for(int j=0; j<col_size; j++){
                if(arr[i][j] > largest){
                    largest = arr[i][j];
                }
            }
        }

        System.out.print("Largest: "+largest);
        

    }
}