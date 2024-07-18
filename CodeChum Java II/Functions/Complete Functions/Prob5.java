import java.util.Scanner;

public class Prob5 {
    public static float average(int[] arr, int size){
        float average = 0;
        for (int i = 0; i < size; i++){
            average += arr[i];
        }
        return average/size;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int size = scanner.nextInt();

        int[] arr = new int[size];
        System.out.print("Enter the numbers: ");
        for(int i = 0; i < size; i++){
            arr[i] = scanner.nextInt();
        }

        System.out.printf("Average: %.2f",average(arr,size));
    }
}