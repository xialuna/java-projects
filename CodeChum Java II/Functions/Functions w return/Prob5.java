import java.util.Scanner;
public class Prob5 {
    public static int return10() {
        return 10;
      }
    
    public static void main(String[] args) {
        int total = 0;
        for(int i = 0; i < 3; i++){
            total += return10();
        }
        System.out.printf("Total: %d", total);
    }
}