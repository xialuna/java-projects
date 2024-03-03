public class Diamond {
    public static void main(String[] args) {
        for(int height = 1, bracket = 5;height <= 5; height++, bracket--){
            for (int width = 0; width <= 10; width++){
                if(width == bracket){
                    System.out.print("/");
                }else if(width == 10 - bracket+1){
                    System.out.print("\\");
                }else{
                    System.out.print(" ");
                } 
            }
            System.out.println();
        }

        for(int height = 1, bracket = 1;height <= 5; height++, bracket++){
            for (int width = 0; width <= 10; width++){
                if(width == bracket){
                    System.out.print("\\");
                }else if(width == 10 - bracket+1){
                    System.out.print("/");
                }else{
                    System.out.print(" ");
                } 
            }
            System.out.println();
        }
    }
}
