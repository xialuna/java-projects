import java.util.Scanner;

public class Prob2{
    public static int min(int[] arr,int size){
        int min = arr[0];
        for(int i = 0; i < size-1 ; i++){
            if (arr[i] < min)
                min = arr[i];
        }    
        return min;
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

        System.out.print("Minimum Value in the Array: "+ min(arr, size));
    }
}