import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class Prob3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        File letterFolder = new File("letters");
        File numberFolder = new File("numbers");
        letterFolder.mkdir();
        numberFolder.mkdir();
        char userInput;
        boolean hasNumber = false;
        
        File fileLetter = new File(letterFolder, "inputted.txt");
        File fileNum = new File(numberFolder, "inputted.txt");
        
        try {
            fileLetter.createNewFile();
            do {
                System.out.print("Enter a character: ");
                userInput = scanner.next().charAt(0);
                if (Character.isDigit(userInput)) {
                    hasNumber = true;
                    if (!fileNum.exists())
                        fileNum.createNewFile();
                    FileWriter numFileWriter = new FileWriter(fileNum, true); 
                    BufferedWriter numWriter = new BufferedWriter(numFileWriter);
                    numWriter.write(userInput);
                    numWriter.newLine();
                    numWriter.close();
                } else if (Character.isLetter(userInput)) {
                    FileWriter letterFileWriter = new FileWriter(fileLetter, true); 
                    BufferedWriter letterWriter = new BufferedWriter(letterFileWriter);
                    letterWriter.write(userInput);
                    letterWriter.newLine();
                    letterWriter.close();
                } else {
                    if (!hasNumber) {
                        fileNum.createNewFile();
                    }
                    break;
                }
            } while (true);
            
        } catch (IOException e) {
            System.out.println("Error");
        } 
    }
}