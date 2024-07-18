public class Node {
    double value;
    Node next;
}

class NodeOperations {

    public static double sumLinkedList(Node head) {
        double sum = 0; 
        Node current = head;
        while (current != null) {
            sum += current.value;
            current = current.next;
        }

        return sum;
    }
}