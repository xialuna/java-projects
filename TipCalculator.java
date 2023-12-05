import java.util.Scanner;
public class TipCalculator {
    public static void main(String[] args) {
        System.out.println("SHARED BILL TIP CALCULATOR");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the total bill: ₱");
        float bill = scanner.nextFloat();

        System.out.print("Enter tip percentage to give: ");
        int tipPercent = scanner.nextInt();

        System.out.print("Enter number of people to split the bill: ");
        int personNum = scanner.nextInt();

        tipPercent /= 100.0f;

        float totalTip = bill * tipPercent;
        float indivTip = totalTip / personNum;
        float totalBill = (bill / personNum) + indivTip;

        System.out.println("\n------------ R E S U L T ------------");
        System.out.printf("\tTotal Tip (%d%%): ₱%.2f\n", (int) (tipPercent * 100), totalTip);
        System.out.printf("\tTip per Person: ₱%.2f\n", indivTip);
        System.out.printf("\tTotal Bill Amount: ₱%.2f\n", (bill + totalTip));
        System.out.printf("\tTotal Bill per Person: ₱%.2f\n", totalBill);

        
        scanner.close();
    }
}
