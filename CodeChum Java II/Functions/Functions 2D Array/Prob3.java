import java.util.Scanner;

public class Prob3 {
    public static int exists(int[][] arr, int row, int col, int x){
        int max = arr[0][0];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(arr[i][j] == x)
                    return 1;
            }
        }
        return 0;
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

        System.out.print("Enter value to find: ");
        int x = scanner.nextInt();

        int result = exists(arr, row, col, x);
        System.out.println((result == 1)? "yes": "no");
        
    }
}