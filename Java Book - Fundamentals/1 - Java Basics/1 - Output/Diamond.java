public class Diamond {
    public static void main(String[] args) {
        for(int height = 1, slash = 5;height <= 5; height++, slash--){
            for (int width = 0; width <= 10; width++){
                if(width == slash)
                    System.out.print("/");
                else if(width == 10 - slash+1)
                    System.out.print("\\");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }

        for(int height = 1, slash = 1;height <= 5; height++, slash++){
            for (int width = 0; width <= 10; width++){
                if(width == slash)
                    System.out.print("\\");
                else if(width == 10 - slash+1)
                    System.out.print("/");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
}
