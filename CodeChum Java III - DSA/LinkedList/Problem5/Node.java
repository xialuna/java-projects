public class Node {
    int a;
    int b;
    Node next;
}

class NodeOperations {
    public static Node createPairNode(int a, int b) {
        Node newNode = new Node();
        newNode.a = Math.min(a, b);
        newNode.b = Math.max(a, b);
        return newNode;
    }

    public static void printList(Node node) {
        Node current = node;
        StringBuilder output = new StringBuilder();
        while (current != null) {
            output.append("(").append(current.a).append(", ").append(current.b).append(")");
            current = current.next;
            if (current != null) {
                output.append(" -> ");
            }
        }
        System.out.println(output.toString());
    }

    public static void addFront(Node head, Node node) {
        node.next = head.next;
        head.next = node;
    }
}
