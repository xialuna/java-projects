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

public class Problem2{
    public static void main(String[] args) {
        PriorityQueue queue = new PriorityQueue();
        Scanner scanner = new Scanner(System.in);

        String operation;
        double sum = 0;
        int count = 0;
        System.out.println("Enter operations:");
        do {
            operation = scanner.nextLine();

            if (operation.startsWith("+")) {
                String[] parts = operation.split(" ");
                int value = Integer.parseInt(parts[1]);
                int priority = Integer.parseInt(parts[2]);
                queue.enqueue(value, priority);
            } else if (operation.startsWith("-")) {
                queue.dequeue();
            }
        } while (!operation.equals("#"));

        // Calculate and print running average after all operations are performed
        PriorityQueue.Node node = queue.getFront();
        while (node != null) {
            sum += node.value;
            count++;
            System.out.printf("Running Average: %.2f\n", sum / count);
            node = node.next;
        }

        scanner.close();
    }
}