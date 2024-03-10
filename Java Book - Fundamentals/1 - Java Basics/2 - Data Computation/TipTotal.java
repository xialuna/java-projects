import java.util.Scanner;
public class TipTotal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int personNum;
        float bill, totalTip, indivTip, totalBill,tipPercent;

        System.out.println("SHARED TIP CALCULATOR");
        System.out.print("Enter the total bill: ");
        bill = scanner.nextFloat();
        System.out.print("Enter the tip percent: ");
        tipPercent = scanner.nextFloat();
        System.out.print("Enter the number of people to split the bill: ");
        personNum = scanner.nextInt();

        tipPercent /= 100;
        totalTip = bill * tipPercent;
        indivTip = totalTip/personNum;
        totalBill = (bill/personNum) + indivTip;

        System.out.println("\n------------ R E S U L T ------------");
        System.out.println(String.format("\tTotal Tip (%d%%): %.2f",(int)(tipPercent * 100),totalTip));
        System.out.println(String.format("\tTip per Person: %.2f",indivTip));
        System.out.println(String.format("\tTotal Bill Amount: %.2f",(bill + totalTip)));
        System.out.println(String.format("\tTotal Bill per Person: %.2f",totalBill));

    }
}
