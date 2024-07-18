/*
A float array is initialized with 10 elements in the code editor.

Multiply the first element with the fifth element and print the
product with 2 decimal places on the next line.
 */

 public class Prob4 {

    public static void main(String[] args) {
        float[] numArr = {3.14f, 9.2f, 8.812f, 10.5f, 0.4f, -23.23f, -1.56f, 12.3f, 9.45f, -0.968f};
        
        float product = numArr[0] * numArr[4];

        System.out.println(String.format("%.2f",product));
    }
}