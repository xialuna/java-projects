import java.util.Scanner;
public class Prob5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer for x: ");
        int x = scanner.nextInt();
        System.out.print("Enter an integer for y: ");
        int y = scanner.nextInt();
        System.out.print("Enter an integer for z: ");
        int z = scanner.nextInt();

        for(int i = x; i <= y; i+= z){
            System.out.print(i);
            if (i + z <= y){
                System.out.print(", ");
            }
        }
    }
}