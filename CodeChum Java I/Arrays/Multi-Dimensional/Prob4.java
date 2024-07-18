import java.util.Scanner;
public class Prob4{
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         int last_3 = 0, last_5 = 0;
         System.out.print("Enter number of rows: ");
         int row_size = scanner.nextInt();
         System.out.print("Enter number of columns: ");
         int col_size = scanner.nextInt();
 
         int[][] arr = new int[row_size][col_size];
         
         for(int i=0; i<row_size; i++){
             for(int j=0; j<col_size; j++){
                 System.out.print(String.format("Enter element at row %d, column %d: ", i, j));
                 arr[i][j] = scanner.nextInt();
                 if(arr[i][j] % 3 == 0) // to take note of the last one that doesn't have a comma
                     last_3 = arr[i][j]; 
                 if (arr[i][j] % 5 == 0)
                     last_5 = arr[i][j]; 
             }
         }
 
         System.out.print("Divisible by 3: ");
         for(int i=0; i<row_size; i++){
             for(int j=0; j<col_size; j++){
                 if(arr[i][j] % 3 == 0){
                     System.out.print(arr[i][j]);
                     if(arr[i][j] == last_3)
                         break;
                     
                     if(j != col_size - 1 || j + 1 == col_size)
                         System.out.print(", ");
                 }
             }
         }
 
         System.out.print("\nDivisible by 5: ");
         for(int i=0; i<row_size; i++){
             for(int j=0; j<col_size; j++){
                 if(arr[i][j] % 5 == 0){
                     System.out.print(arr[i][j]);
                     if(arr[i][j] == last_5)
                         break;
                     
                     if(j != col_size - 1 || j + 1 == col_size)
                         System.out.print(", ");
                 }
             }
         }       
     }
 }