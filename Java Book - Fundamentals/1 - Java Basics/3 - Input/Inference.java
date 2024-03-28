import java.util.Scanner;
public class Inference {
    public static void main(String[] args) {
        String[] name = new String[3];
        Scanner scanner = new Scanner(System.in);
    
        for(int i = 0; i < 3; i++){
            System.out.print(String.format("Enter name %d: ", i+1));
            name[i] = scanner.nextLine();
        }
        
    


    }
}
