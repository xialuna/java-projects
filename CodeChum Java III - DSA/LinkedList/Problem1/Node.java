public class Node {
    public int value;
    public Node next;

    public Node() {}
    public Node(int value) {
        this.value = value;
    }
}

class NodeOperations {
    public static void printSquaredValues(Node head) {
        Node current = head;
        int square;
        boolean comma = true;
        while(current != null){
            square = current.value * current.value;
            if(square != 0){
                if (!comma)
                System.out.print(" -> ");
                else
                comma = false;
                
                System.out.print(square);
            }
            
            current = current.next;
        }
    }
}