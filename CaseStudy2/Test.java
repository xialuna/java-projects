/**
 * @author GROUP # 2
 * Members:
 * - Cheng, Xian
 * - Pascual, Ian Nevri
 * - Quinto, Raven Luke
 * 
 * CASE STUDY 2: MyDate Class 
 */
import java.util.Scanner;
//test program for MyDate Class
public class Test {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("[1] Print out test program\n[2] Print out each day from 28 Dec 2011 to 2 Mar 2012\n>> ");
        int option = scan.nextInt();

        switch (option) {
            case 1:
                // Test program
                MyDate d1 = new MyDate(2012, 2, 28);

                System.out.println(d1);
                System.out.println(d1.nextDay());
                System.out.println(d1.nextDay());
                System.out.println(d1.nextMonth());
                System.out.println(d1.nextYear());
                System.out.println();

                MyDate d2 = new MyDate(2012, 1, 2);
                System.out.println(d2);
                System.out.println(d2.previousDay());
                System.out.println(d2.previousDay());
                System.out.println(d2.previousMonth());
                System.out.println(d2.previousYear());
                System.out.println();

                MyDate d3 = new MyDate(2012, 2, 29);
                System.out.println(d3.previousYear());
                break;
            case 2:
                // Printing each day from 28 Dec 2011 to 2 Mar 2012
                MyDate test = new MyDate(2011, 12, 28);
                System.out.println(test);
                while (!(test.getYear() == 2012 && test.getMonth() == 3 && test.getDay() == 2)) {
                    System.out.println(test.nextDay());
                }
                break;
            default:
                System.out.println("Invalid Input");
                break;
        }
        scan.close();
    }
}
