import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Node linkedList = new Node(0);

        int newValue;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print("Enter an integer: ");
            newValue = scanner.nextInt();

            if (newValue != 0) {
                linkedList = NodeOperations.addNode(linkedList, newValue);
            }
        } while (newValue != 0);

        NodeOperations.printList(linkedList);

        Node nextNode = linkedList.next;

        while (linkedList != null) {
            System.gc();
            linkedList = nextNode;

            if (nextNode != null) {
                nextNode = nextNode.next;
            }
        }
    }
}
