import java.util.Scanner;

public class Try {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input coordinates of the two points
        System.out.println("Enter the x-y coordinates of the first point separated by a space:");
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();

        System.out.println("Enter the x-y coordinates of the second point separated by a space:");
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();

        // Call the function to calculate slope and y-intercept
        double[] result = calculateSlopeAndYIntercept(x1, y1, x2, y2);

        // Output slope-intercept form equation
        System.out.println("Slope-intercept form equation: y = " + result[0] + "x + " + result[1]);
    }

    public static double[] calculateSlopeAndYIntercept(double x1, double y1, double x2, double y2) {
        double slope = (y2 - y1) / (x2 - x1);
        double yIntercept = y1 - slope * x1;
        return new double[]{slope, yIntercept};
    }
}
