import java.util.Scanner;
public class Resistance {
    private static Scanner in = new Scanner(System.in);
    public static int search(String[] colorCode, int size, String target){
        for(int i = 0; i < size; i++){
            if(colorCode[i].equals(target)){
                return i;
            }
        }return -1;
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
                String target = in.nextLine().toLowerCase();
                bands[i] = search(color_codes,color_codes.length,target);
                if(bands[i] == -1)
                    invalidWord = target;
            }

           if(!(invalidWord.equals("none"))){
                System.out.println("Invalid color: "+ invalidWord);
           }else{
                double resistance = ((bands[0] * 10 + bands[1]) * Math.pow(10,bands[2]));
                int kiloohms = (int) resistance / 1000;
                System.out.print("Resistance value: " + kiloohms + " kilo-ohms");
                    if (kiloohms == 0)
                        System.out.print(" ("+ (int)resistance + " ohms)"); 
           }
           
            System.out.println("\nDo you want to decode another resistor(y/n)?");
            choice = Character.toLowerCase(in.next().charAt(0));
            in.nextLine(); //get \n excess
        }while(choice == 'y');
    }
}
