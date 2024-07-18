import java.io.*;

public class Prob2 {
    public static void main(String[] args) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt"));
        BufferedReader reader = new BufferedReader(new FileReader("data.txt"));
    //write
        for (int i = 1; i <= 100; i++) { 
            writer.write(i + "\n");
        }
        writer.close();

    //read
        String line;
        while ((line = reader.readLine()) != null) { 
            int num = Integer.parseInt(line); //convert string to int
            if (num % 2 == 0) {
                System.out.println(num);
            }
        }
        reader.close();
    }
}