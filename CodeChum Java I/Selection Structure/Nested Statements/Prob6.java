import java.util.Scanner;
public class Prob6 {
    public static void main(String[] args) {
        int total = 10;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter x: ");
        int x = scanner.nextInt();
        System.out.print("Enter y: ");
        int y = scanner.nextInt();
        System.out.print("Enter z: ");
        int z = scanner.nextInt();
    
        if(z >=x && z <= y){
            System.out.println(String.format("%d is just within %d and %d",z,x,y));
        }else{
            if(Math.abs(x - z) > Math.abs(z - y)){
                System.out.println(String.format("%d is farther from %d",z,x));
            }else{
                System.out.println(String.format("%d is farther from %d",z,y));
            }
        }
          
            
    }
}