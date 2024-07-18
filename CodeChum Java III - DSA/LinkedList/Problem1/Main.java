public class Main {
    public static void main(String[] args) {
        Node linkedList = new Node();
        linkedList.value = 0;
        linkedList.next = null;

        Node node1 = new Node();
        node1.value = 5;
        node1.next = null;
        linkedList.next = node1;

        Node node2 = new Node();
        node2.value = 3;
        node2.next = null;
        node1.next = node2;

        Node node3 = new Node();
        node3.value = 22;
        node3.next = null;
        node2.next = node3;

        Node node4 = new Node();
        node4.value = 100;
        node4.next = null;
        node3.next = node4;

        Node node5 = new Node();
        node5.value = -10;
        node5.next = null;
        node4.next = node5;

        NodeOperations.printSquaredValues(linkedList);
    }
}
