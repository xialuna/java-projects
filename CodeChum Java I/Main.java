import java.io.*;
public class Main {
 public static void main(String[] args) {
  
  //CSV = Comma-Separated Values 
  //   text file that uses a comma to separate values
  
  String file = "src\\students.csv"; //file path of students.csv
  BufferedReader reader = null;
  String line = "";
  
  try {
   reader = new BufferedReader(new FileReader(file)); 
   while((line = reader.readLine()) != null) { //continuously read next line
    
    String[] row = line.split(","); //assign values in the array
    //String[] row = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)"); 
	//use this if your values already contain commas
    for(String index : row) { //for each loop
     System.out.printf("%-10s", index); //display whatever is at index
	 // 10 = 10 spaces 
	 // - 10 = left 10 spaces (left justify)
	 // s = strings
    }
    System.out.println();
   }
  }
  catch(Exception e) {
   e.printStackTrace();
  }
  finally {
   try {
    reader.close();
   } catch (IOException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
   }
  }
 }
}
