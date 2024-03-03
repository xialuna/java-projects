public class DiamondFilled {
    public static void main(String[] args) {
        for(int height = 1, slash = 5;height <= 5; height++, slash--){
            for (int width = 0; width <= 10; width++){
                if(width == slash){
                    for(;width!=6;width++)
                        System.out.print("/");
                        
                    for(int b_slash = 4; b_slash >= slash - 1; b_slash--)
                        System.out.print("\\");
                }else
                    System.out.print(" ");
            }
            System.out.println();
        }

        for(int height = 1, slash = 1;height <= 5; height++, slash++){
            for (int width = 0; width <= 10; width++){
                if(width == slash){
                    for(;width!=6;width++)
                        System.out.print("\\");
                        
                    for(int f_slash = slash; f_slash <= 5 ; f_slash++)
                        System.out.print("/");
                }else
                    System.out.print(" ");
            }
            System.out.println();
        }

        
    }
}
