import java.util.Scanner;
class Queue {
    public static class Node {
        int value;
        Node next;
    }

    public static Node front, rear;
    public static int count;

    public static void enqueue(int item) {
        Node newItem = new Node();
        newItem.value = item;
        newItem.next = null;

        if (rear != null) {
            rear.next = newItem;
        }

        rear = newItem;

        if (front == null) {
            front = newItem;
        }

        count++;
    }

    public static int dequeue() {
        if (front != null) {
            int value = front.value;
            front = front.next;

            if (front == null) {
                rear = null;
            }

            count--;
            return value;
        }

        return 0;
    }

    public static boolean isEmpty() {
        return count == 0;
    }

    public static Node getFront() {
        return front;
    }

    public static void printQueue() {
        Node temp = front;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
public class Problem4{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter operations: ");

        String operation;

        while (!(operation = scanner.nextLine()).equals("#")) {
            char op = operation.charAt(0);
            if (op == '+' && operation.length() > 1) {
                int value = Integer.parseInt(operation.substring(1).trim());
                Queue.enqueue(value);
            } else if (op == '-') {
                Queue.dequeue();
            }
        }

        System.out.print("Enter number to remove from the queue: ");
        int numberToRemove = scanner.nextInt();
        scanner.nextLine(); // Consume the leftover newline character

        // Create a temporary node and enqueue only the elements not equal to numberToRemove
        Queue.Node tempFront = null, tempRear = null;
        Queue.Node node = Queue.getFront();
        while (node != null) {
            if (node.value != numberToRemove) {
                Queue.Node newNode = new Queue.Node();
                newNode.value = node.value;
                newNode.next = null;
                if (tempRear != null) {
                    tempRear.next = newNode;
                }
                tempRear = newNode;
                if (tempFront == null) {
                    tempFront = newNode;
                }
            }
            node = node.next;
        }

        // Clear the original queue
        while (!Queue.isEmpty()) {
            Queue.dequeue();
        }

        // Enqueue the elements from the temporary queue to the original queue
        node = tempFront;
        while (node != null) {
            Queue.enqueue(node.value);
            node = node.next;
        }

        System.out.println("Queue after removal: ");
        // Print the queue manually
        node = Queue.getFront();
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }
}