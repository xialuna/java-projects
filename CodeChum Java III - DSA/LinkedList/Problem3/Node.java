
public class Node {
    public int value;
    public Node next;
}

class NodeOperations {
    public static Node insertAtPos(Node head, int num1, int num2, int pos) {
        Node newNode1 = createNode(num1);
        Node newNode2 = createNode(num2);
        newNode1.next = newNode2;

        if (pos == -1) {
            newNode2.next = head;
            return newNode1;
        }

        Node current = head;
        Node previous = null;
        int i = 0;

        while (current != null) {
            if (i == pos) {
                newNode2.next = current.next;
                current.next = newNode1;
                break;
            } else {
                previous = current;
                current = current.next;
                i++;
            }
        }

        // If position is beyond the last element, append at the end
        if (current == null && i == pos - 1) {
            previous.next = newNode1;
        }


        return head;
    }
 
 
    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            if (current.value != 0) {
                System.out.print(current.value);
                if (current.next != null && current.next.value != 0) {
                    System.out.print(" -> ");
                }
            }
            current = current.next;
        }
    }
 
     public static Node createNode(int value) {
         // Don't modify
         Node newNode = new Node();
         newNode.value = value;
         newNode.next = null;
         return newNode;
     }
 }