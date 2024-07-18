
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create the head node
        Node linkedList = new Node();

        int n, a, b;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of pairs: ");
        n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter pair " + (i + 1) + ":");

            a = scanner.nextInt();

            b = scanner.nextInt();
            System.out.println();

            NodeOperations.addFront(linkedList, NodeOperations.createPairNode(a, b));
        }

        NodeOperations.printList(linkedList.next);
    }
}