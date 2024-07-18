import java.util.Scanner;

public class Prob1 {
    public static void printArr(int[] arr,int size){
        for(int i = 0; i < size-1 ; i++)
            System.out.print(arr[i] + ", ");
        System.out.print(arr[size - 1]);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int size = scanner.nextInt();

        int[] arr = new int[size];

        System.out.println("Enter array values: ");
        for(int i = 0; i < size; i++){
            arr[i] = scanner.nextInt();
        }

        printArr(arr, size);
    }
}
