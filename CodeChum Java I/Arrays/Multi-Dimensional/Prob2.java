/*
Ask the user to input the number of rows and columns of a
multidimensional array and its corresponding elements.

Then, print its elements starting from the end (i.e. last row,
last column) all the way to the start (i.e. first row, first
column). Print the elements by separating each element by
\tby column and a new line per row.
 */

import java.util.Scanner;
public class Prob2 {
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

        for(int i= (row_size - 1); i >= 0; i--){
            for(int j= (col_size - 1); j >= 0; j--){
                System.out.print(arr[i][j]);
                if(j != 0){
                    System.out.print("\t");
                }
            }
            System.out.println();
        }

    }
}