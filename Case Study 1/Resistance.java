import java.util.Scanner;
//Program that calculates the resistance and displays it in kilo-ohms
public class Resistance {
    private static Scanner in = new Scanner(System.in);

    // Method for searching target in colorCode array
    public static int search(String[] colorCode, int size, String target){
        for(int i = 0; i < size; i++){
            if(colorCode[i].equals(target)){ // checks each element if it matches target
                return i;
            } 
        } 
        return -1; // returns -1 if color code is not found in the array
    } 
    
    public static void main(String[] args){
        char choice; 
        String[] color_codes = {"black","brown", "red","orange","yellow","green","blue","violet","gray", "white"};

        do{
            System.out.println("\nEnter the colors of the resistor\'s three bands, beginning with the band nearest the end. Type the colors in lowercase letters only, NO CAPS.");
            int[] bands = new int[3];       
            String invalidWord = "none";     
            for (int i = 0; i < 3; i++){    
                System.out.print("Band "+ (i+1) + " => ");
                String target = in.nextLine().toLowerCase();   // Takes user input for 3 bands and converts it to lowercase
                bands[i] = search(color_codes,color_codes.length,target);   // Assigns index of color (if found) to bands array
                
                if(bands[i] == -1)  // Detects invalid color inputs
                    invalidWord = target;               
            } 

            
            if (!(invalidWord.equals("none"))){  // Detects if an invalidWord is inputted by the user
                System.out.println("Invalid color: "+ invalidWord);
            } else {
                double resistance = ((bands[0] * 10 + bands[1]) * Math.pow(10,bands[2])); // Calculates resistance value
                int kiloohms = (int) resistance / 1000;                                   // Converts ohms to kilo-ohms 
                System.out.print("Resistance value: " + kiloohms + " kilo-ohms");  

                    if (kiloohms == 0)  // display values smaller than 1 kilo-ohm
                        System.out.print(" ("+ (int)resistance + " ohms)");                
            } 
           
            System.out.println("\nDo you want to decode another resistor(y/n)?");
            choice = Character.toLowerCase(in.next().charAt(0)); // Takes user input for continuation
            in.nextLine();   // Consumes excess newline left by previous input
        } while(choice == 'y'); // Continues the program if user inputs 'y'/'Y'
       
        in.close();
    } 
}
