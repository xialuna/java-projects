public class Tesda {
    public static void main(String args[]) {
        
        String s1 = "   Java Training  "; // sting
       
        // Before Trim() method
        System.out.println("Before Trim() - "); // code to be exe.
        
        System.out.println("String - "+s1); // code to be exe.
        
        System.out.println("Length - "+s1.length()); // code to be exe.
        
         
        // applying trim() method on string s1
        s1=s1.trim();// trim
         
        // After Trim() method
        System.out.println("\nAfter Trim() - ");// code to be exe
        System.out.println("String - "+s1); // code to be exe
        System.out.println("Length - "+s1.length());// code to be exe
         
    }
}
