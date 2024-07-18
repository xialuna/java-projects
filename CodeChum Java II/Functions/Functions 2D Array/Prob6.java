import java.util.Scanner;

public class Prob6 {
    public static int sumAtRange(int[][] arr, int row, int col, int start, int end){
        int sum = 0;
        
        for(int i = start - 1; i < end; i++){
            int rowIndex = i / col;
            int colIndex = i % row;
            sum += arr[rowIndex][colIndex];
        }
        return sum;
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

        System.out.print("Sum starts at: ");
        int start = scanner.nextInt();
        System.out.print("Sum ends at: ");
        int end = scanner.nextInt();

        System.out.print("Sum: " + sumAtRange(arr,row,col, start, end));
        
    }
}