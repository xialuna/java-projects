import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int[][] arr = new int[3][4];
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your: ");
        int num = scanner.nextInt();

        for(int i=0; i<3; i++){
            for(int j=0; j<4; j++){
                arr[i][j] = scanner.nextInt();
            }
        }

        for(int i=0; i<3; i++){
            System.out.println(arr[i]);
        }

        System.out.print(String.format(""));
    }
}