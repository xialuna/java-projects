import java.util.Scanner;

public class Prob4 {
    public static void printEven(int[][] arr, int row, int col){
        boolean space = true;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if (arr[i][j] % 2 == 0){
                    if (!space)
                        System.out.print(", ");
                    else
                        space = false;
                    
                    System.out.print(arr[i][j]);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int row = scanner.nextInt();
        System.out.print("Enter number of columns: ");
        int col = scanner.nextInt();

        int[][] arr = new int[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                arr[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Even Values: ");
        printEven(arr,row,col);
        
    }
}