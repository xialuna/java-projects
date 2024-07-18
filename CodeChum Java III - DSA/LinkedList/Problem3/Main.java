import java.util.Scanner;

public class Main {
    public static void manuallyConnectNodes(Node head) {
        Node current = head;
        int[] values = { 5, 3, 22, 100, -10, 55, -7 };
        for (int value : values) {
            current.next = NodeOperations.createNode(value);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        Node linkedList = NodeOperations.createNode(0);
        manuallyConnectNodes(linkedList);

        System.out.println("Original linked list:");
        NodeOperations.printList(linkedList);
        System.out.println();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter second number: ");
        int num2 = scanner.nextInt();

        System.out.print("Enter position: ");
        int pos = scanner.nextInt();

        scanner.close();

        NodeOperations.insertAtPos(linkedList, num1, num2, pos);

        NodeOperations.printList(linkedList);
    }
}