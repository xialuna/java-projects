import java.util.*;
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
public class Problem6{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue queue = new Queue();

        System.out.println("Enter operations: ");

        String operation;

        while (!(operation = scanner.nextLine()).equals("#")) {
            char op = operation.charAt(0);
            if (op == '+' && operation.length() > 1) {
                int value = Integer.parseInt(operation.substring(1).trim());
                queue.enqueue(value);
            } else if (op == '-') {
                queue.dequeue();
            }
        }

        // Find mode after the loop terminates
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        Queue.Node node = queue.getFront();
        while (node != null) {
            frequencyMap.put(node.value, frequencyMap.getOrDefault(node.value, 0) + 1);
            node = node.next;
        }

        int mode = Collections.max(frequencyMap.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();

        System.out.println("Mode: " + mode);
    }
}