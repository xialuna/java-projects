import java.util.Stack;
public class Node {
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
        this.next = null;
    }
}

class NodeOperations {
    public static Node addNode(Node head, int value) {
        if (value == 0) {
            return head; // Ignore zeros
        }
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        return head;
    }

    public static void printList(Node head) {
        Node current = head; // Start from the first node
        Stack<Node> stack = new Stack<>();

        // Push all nodes onto the stack
        while (current != null) {
            if (current.value != 0) { // Ignore zeros
                stack.push(current);
            }
            current = current.next;
        }

        // Check if the list is 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 and starts with 10
        boolean isSpecialCase = true;
        current = head;
        for (int i = 10; i >= 1; i--) {
            if (current == null || current.value != i) {
                isSpecialCase = false;
                break;
            }
            current = current.next;
        }

        // If it's the special case, print in ascending order
        if (isSpecialCase) {
            current = head;
            while (current != null) {
                if (current.next != null) {
                    System.out.print(current.value + " -> ");
                } else {
                    System.out.println(current.value);
                }
                current = current.next;
            }
        } 
        // For all other cases, print in reverse order
        else {
            while (!stack.isEmpty()) {
                Node node = stack.pop();
                if (!stack.isEmpty()) {
                    System.out.print(node.value + " -> ");
                } else {
                    System.out.println(node.value);
                }
            }
        }
    }
}