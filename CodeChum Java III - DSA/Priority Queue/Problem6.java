import java.util.Scanner;
class PriorityQueue {
    public static class Node {
        int value;
        int priority;
        Node next;
    }

    private static Node front;
    private static int count;

    public static void enqueue(int item, int priority) {
        Node newItem = new Node();
        newItem.value = item;
        newItem.priority = priority;
        newItem.next = null;

        if (isEmpty() || priority > front.priority) {
            newItem.next = front;
            front = newItem;
        } else {
            Node current = front;
            while (current.next != null && current.next.priority >= priority) {
                current = current.next;
            }
            newItem.next = current.next;
            current.next = newItem;
        }
        count++;
    }

    public static int dequeue() {
        if (front != null) {
            int value = front.value;
            front = front.next;
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
            System.out.print(temp.value + "(" + temp.priority + ") ");
            temp = temp.next;
        }
        System.out.println();
    }
}
public class Problem6{
    public static void main(String[] args) {
        PriorityQueue queue = new PriorityQueue();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter operations:");
        while (true) {
            String operation = scanner.next();

            if (operation.equals("+")) {
                int value = scanner.nextInt();
                int priority = scanner.nextInt();
                queue.enqueue(value, priority);
            } else if (operation.equals("-")) {
                queue.dequeue();
            } else if (operation.equals("#")) {
                break;
            }
        }

        System.out.print("Enter priority number: ");
        int priorityToRemove = scanner.nextInt();
        PriorityQueue.Node current = queue.getFront();
        while (current != null) {
            if (current.priority < priorityToRemove) {
                System.out.println("Value: " + current.value + ", Priority: " + current.priority);
            }
            current = current.next;
        }
    }
}