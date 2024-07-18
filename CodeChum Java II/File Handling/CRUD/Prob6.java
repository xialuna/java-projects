import java.io.*;
import java.util.Scanner;

public class Prob6 {
    public static void main(String[] args) throws IOException {
        FileWriter dataFile = new FileWriter("data.txt");
        dataFile.write("5\n3\n2\n");
        dataFile.close();

        // reading numbers from file
        FileReader fileReader = new FileReader("data.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line; //store each line read from filke
        FileWriter appendWriter = new FileWriter("data.txt", true); // True for appending

        while ((line = bufferedReader.readLine()) != null) {
            int num = Integer.parseInt(line.trim());
            int square = num * num;
            appendWriter.write("\n"+square);
        }

        bufferedReader.close();
        appendWriter.close();
    }
}