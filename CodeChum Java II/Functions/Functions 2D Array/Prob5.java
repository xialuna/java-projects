import java.util.Scanner;

public class Prob5 {
    public static float average(float[][] arr, int row, int col){
        float average = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                average += arr[i][j];
            }
        }
        return (average/(row * col));
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int row = scanner.nextInt();
        System.out.print("Enter number of columns: ");
        int col = scanner.nextInt();

        float[][] arr = new float[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                arr[i][j] = scanner.nextFloat();
            }
        }

        System.out.printf("Average: %.2f", average(arr,row,col));
        
    }
}