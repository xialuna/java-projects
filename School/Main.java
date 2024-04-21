public class Main { // main class
    
    
  public static void main(String[] args) { // main methods
      String str1 = "aabbaaac"; // string
      
      String str2 = "Learn223Java55@";//string

      // regex for sequence of digits
      String regex = "\\d+"; // 

      // all occurrences of "aa" is replaceAll with "zz"
      System.out.println(str1.replaceAll("aa", "zz"));  // zzbbzzac


      // replace a digit or sequence of digits with a whitespace
      System.out.println(str2.replaceAll(regex, " "));  // Learn Java @
  }
}