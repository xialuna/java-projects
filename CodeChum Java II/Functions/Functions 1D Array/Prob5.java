import java.util.Scanner;

public class Prob5 {
    public static void printOdd(int[] arr1,int[] arr2, int size1, int size2){
        int firstNum = 1;
            for(int i = 0; i < size1; i++){
                if (arr1[i] % 2 != 0 )
                    System.out.print(arr1[i] + ", ");
            }  
                
    
            for(int i = 0; i < size2; i++){
                if (arr2[i] % 2 != 0 ){
                    if(firstNum == 0)
                        System.out.print(", ");
                    else
                        firstNum = 0;
                    System.out.print(arr2[i]);
                }   
            }  
            
            
        }
    
        public static int[] getArrInput(Scanner scanner, int size){
            int[] arr = new int[size];
            for(int i = 0; i < size; i++){
                arr[i] = scanner.nextInt();
            }
            return arr;
        }
        
        
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter first array size: ");
            int size1 = scanner.nextInt();
            System.out.print("Enter second array size: ");
            int size2 = scanner.nextInt();
    
            System.out.print("Enter first array values: ");
            int[] arr1 = getArrInput(scanner, size1);
    
            System.out.print("Enter second array values: ");
            int[] arr2 =getArrInput(scanner, size2);
    
            printOdd(arr1,arr2,size1, size2);
    
        }
}