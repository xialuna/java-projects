public class Node {
    int value;
    Node next;
}

class NodeOperations {
    public static Node addNode(Node node, int value) {
        Node newNode = new Node();
        newNode.value = value;
        newNode.next = null;

        if (node == null) {
            return newNode;
        } else {
            Node lastNode = node;
            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
            lastNode.next = newNode;
            return node;
        }
    }

    public static Node insertAtPos(Node linkedList, int newValue, int pos) {
        Node newNode = new Node();
        newNode.value = newValue;
        newNode.next = null;

        if (pos == -1) {
            newNode.next = linkedList;
            return newNode; 
        } else {
            Node current = linkedList;
            int i = 0;
            while (current != null && i < pos) {
                current = current.next;
                i++;
            }
            newNode.next = current.next;
            current.next = newNode;
            return linkedList; 
        }
    }


    public static Node deleteAtPos(Node head, int pos) {
        if (head == null) {
            return null; 
        }
        if (pos == -1) {
            return head.next; 
        }
        Node current = head;
        Node previous = null;
        int i = -1;
        while (current != null && i < pos) {
            previous = current;
            current = current.next;
            i++;
        }
        if (current != null) {
            if (previous != null) {
                previous.next = current.next; // Skip the node to delete
            } else {
                head = current.next; // If deleting the head, update the head reference
            }
        }
        return head;
    }

    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.value);
            if (node.next != null) {
                System.out.print(" -> ");
            }
            node = node.next;
        }
        System.out.println();
    }
}