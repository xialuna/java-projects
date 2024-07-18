import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class Prob4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        File file = new File("people.txt");
        String[] names = new String[80]; 
        int count = 0; 

        try {
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            
            System.out.print("Enter the number of names: ");
            int num = scanner.nextInt();
            scanner.nextLine(); 
            
            for(int i = 0; i < num; i++){
                System.out.printf("Enter name %d: ", i+1);
                String name = scanner.nextLine();
                
                boolean isDuplicate = false;
                for (int j = 0; j < count; j++) {
                    if (names[j].equals(name)) {
                        isDuplicate = true;
                        break;
                    }
                }
                
                if (!isDuplicate) {
                    names[count] = name;
                    count++;
                    writer.write(name);
                    writer.newLine();
                } 
            }
            
            writer.close();
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}