import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // create the head node
        Node linkedList = new Node();

        Node node1 = NodeOperations.addNode(linkedList, 5);
        Node node2 = NodeOperations.addNode(node1, 3);
        Node node3 = NodeOperations.addNode(node2, 22);
        Node node4 = NodeOperations.addNode(node3, 100);
        Node node5 = NodeOperations.addNode(node4, -10);
        Node node6 = NodeOperations.addNode(node5, 55);
        Node node7 = NodeOperations.addNode(node6, -7);

        System.out.println("Original linked list:");
        NodeOperations.printList(linkedList.next);

        Scanner scanner = new Scanner(System.in);
        int num1, num2, pos, posToDelete;

        System.out.print("Enter first number: ");
        num1 = scanner.nextInt();

        System.out.print("Enter second number: ");
        num2 = scanner.nextInt();

        System.out.print("Enter position: ");
        pos = scanner.nextInt();

        System.out.print("Enter position to delete: ");
        posToDelete = scanner.nextInt();

        NodeOperations.deleteAtPos(linkedList, posToDelete);
        NodeOperations.insertAtPos(linkedList, num1, pos);
        NodeOperations.insertAtPos(linkedList, num2, pos);

        // Display all the values of the linked list
        NodeOperations.printList(linkedList.next);
    }
}