import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();

        switch (testCase) {
            case 1:
                Node linkedList1 = createLinkedList(new double[] {0, 5, 35.5, 22.13, 100.123, -10.55});
                double sum1 = NodeOperations.sumLinkedList(linkedList1);
                System.out.printf("%.2f\n", sum1);
                break;

            case 2:
                Node linkedList2 = createLinkedList(new double[] {0, 10, 20, 30});
                double sum2 = NodeOperations.sumLinkedList(linkedList2);
                System.out.printf("%.2f\n", sum2);
                break;

            default:
                System.out.println("Invalid test case");
                break;
        }

        scanner.close();
    }

    private static Node createLinkedList(double[] values) {
        Node head = new Node();
        Node current = head;
        for (double value : values) {
            current.next = new Node();
            current.next.value = value;
            current = current.next;
        }
        return head.next; // Skip the initial dummy head node
    }
}