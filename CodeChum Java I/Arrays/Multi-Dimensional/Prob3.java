/*
Ask the user to input the rows and columns of a
multidimensional array and its elements.
Then, ask the user to input an integer and check if it exists in
the multidimensional array.

Print "Found!" if it exists, otherwise print "Sorry, {value}
not found."
 */

import java.util.Scanner;
public class Prob3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int found = 0;
        
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

        System.out.print("Enter x: ");
        int num_find = scanner.nextInt();
        

        for(int i=0; i<row_size; i++){
            for(int j=0; j<col_size; j++){
                if(arr[i][j] == num_find){
                    found = 1;
                }
            }
        }

        System.out.print((found == 1)?"Found!":"Sorry, "+num_find+" not found.");
        

    }
}