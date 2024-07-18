import java.util.Scanner;

public class Prob4 {
    public static void printEven(int[] arr,int size){
        for(int i = 0; i < size; i++){
            if (arr[i] % 2 == 0)
                System.out.print(arr[i] + " ");
        }    
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int size = scanner.nextInt();

        int[] arr = new int[size];

        System.out.print("Enter array values: ");
        for(int i = 0; i < size; i++){
            arr[i] = scanner.nextInt();
        }

        System.out.print("Even values: ");
        printEven(arr,size);
    }
}