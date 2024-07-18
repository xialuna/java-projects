/*
Ask the user to input the rows and columns of a
multidimensional array and its elements.
Print the elements by turning the rows into columns and
columns into rows.
 */
import java.util.Scanner;
public class Prob5 {
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

        for(int i= 0; i < col_size; i++){
            for(int j= 0; j < row_size; j++){
                System.out.print(arr[j][i]);
                if(j != row_size-1){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }
}