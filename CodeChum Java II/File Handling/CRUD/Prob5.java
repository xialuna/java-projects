import java.io.File;
import java.util.Scanner;
import java.io.IOException;

public class Prob5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        File test1 = new File("test1.txt");
        File test2 = new File("test2.txt");
        File test3 = new File("test3.txt");
        
        try {
            test1.createNewFile();
            test2.createNewFile();
            test3.createNewFile();
        } catch (IOException e) {
            System.out.print("Error");
        }

        System.out.print("Enter file to remove: ");
        String fileNum = scanner.nextLine();

        switch(fileNum){
            case "1":
                test1.delete();
                break;
            case "2":
                test2.delete();
                break;
            case "3":
                test3.delete();
                break;
            default:
                break;
        }
    }
}