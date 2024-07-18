import java.util.Scanner;

public class Prob3 {
    public static float sumGreaterThan(float[] arr,int size, float x){
        float sum = 0;
        for(int i = 0; i < size; i++){
            if (arr[i] > x)
                sum += arr[i];
        }    
        return sum;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter array size: ");
        int size = scanner.nextInt();

        float[] arr = new float[size];

        System.out.print("Enter array values: ");
        for(int i = 0; i < size; i++){
            arr[i] = scanner.nextFloat();
        }

        System.out.print("Enter x value: ");
        float x = scanner.nextFloat();

        System.out.printf("Sum of values greater than %.2f: %.2f", x, sumGreaterThan(arr,size,x));
    }
}