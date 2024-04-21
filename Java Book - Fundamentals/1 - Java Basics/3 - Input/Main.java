public class Main { // main class
    
    public static void main(String[] args) {     //main methods 
        
        
    //Creating two variables for age and weight    
    int age=25;    // data type int age variable 25 value
    
    int weight=60;   // data type int weight variable   48 value 
    
    //applying condition on age and weight    
    if(age>=18){  // if condition true 
        
        if(weight>50){  //if condition true  
            
            System.out.println("You are eligible to donate blood"); // code to be exe.   
        } else{  
            System.out.println("You are not eligible to donate blood");  // code to be exe  
        }  
    } else{  
      System.out.println("Age must be greater than 18");  // code to be exe
    }  
}  }