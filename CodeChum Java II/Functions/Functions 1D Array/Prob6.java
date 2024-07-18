import java.util.Scanner;

public class Prob6 {
    public static int sumAtRange(int[] arr,int start, int end){
        int sum = 0;
        for(int i = start-1; i <= end-1; i++){
            sum += arr[i];
        }
        return sum;
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

        System.out.print("Enter starting range: ");
        int start = scanner.nextInt();
        System.out.print("Enter end range: ");
        int end = scanner.nextInt();
        

        System.out.print("Sum at range: "+ sumAtRange(arr,start,end));
    }
}