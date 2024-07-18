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
public class Problem5{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue queue = new Queue();

        System.out.println("Enter operations: ");

        int sum = 0;
        int count = 0;
        String operation;

        while (!(operation = scanner.nextLine()).equals("#")) {
            char op = operation.charAt(0);
            if (op == '+' && operation.length() > 1) {
                int value = Integer.parseInt(operation.substring(1).trim());
                queue.enqueue(value);
                sum += value;
                count++;
            } else if (op == '-') {
                int value = queue.dequeue();
                sum -= value;
                count--;
            }
        }

        // Compute running sum after the loop terminates
        Queue.Node node = queue.getFront();
        int tempSum = 0;
        while (node != null) {
            tempSum += node.value;
            System.out.println("Running Sum: " + tempSum);
            node = node.next;
        }
    }
}