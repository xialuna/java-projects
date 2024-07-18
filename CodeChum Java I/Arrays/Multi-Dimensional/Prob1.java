/*
 A multidimensional integer array is initialized in the code
editor.

Print the elements by row starting from the first row going
down to the last row.

Separate the elements per row by a comma and a space
similar to this format (note: # represents integer elements):
 */

 public class Prob1 {

    public static void main(String[] args) {
        int[][] numArray = {{1, 2, 3, 4}, {3, 5, 7, 9}};
        int row_size = 2;
        int col_size = 4;
        
        for(int i=0; i < row_size; i++){
            for(int j=0; j < col_size; j++){
                System.out.print(numArray[i][j]);
                if(j != col_size-1){
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }
}