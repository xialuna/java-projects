import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class CircularLinkedList {
    private Node head;
    private Node tail;

    public CircularLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insert(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }

    public void delete(int value) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node current = head;
        Node prev = null;
        do {
            if (current.data == value) {
                if (prev == null) {
                    head = current.next;
                    tail.next = head;
                } else {
                    prev.next = current.next;
                    if (current == tail) {
                        tail = prev;
                        tail.next = head;
                    }
                }
                System.out.println(value + " deleted from the list.");
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);

        System.out.println(value + " is not found in the list.");
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node current = head;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }

    public void traverse() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node current = head;
        do {
            System.out.println("Node: " + current.data + ", Next: " + current.next.data);
            current = current.next;
        } while (current != head);
    }

    public void search(int value) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node current = head;
        do {
            if (current.data == value) {
                System.out.println("The " + value + " was FOUND");
                return;
            }
            current = current.next;
        } while (current != head);

        System.out.println("The " + value + " was NOT FOUND");
    }

    public void sort(int order) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        int size = 0;
        Node current = head;
        do {
            size++;
            current = current.next;
        } while (current != head);

        int[] array = new int[size];
        current = head;
        for (int i = 0; i < size; i++) {
            array[i] = current.data;
            current = current.next;
        }

        bubbleSort(array, order);

        current = head;
        for (int i = 0; i < size; i++) {
            current.data = array[i];
            current = current.next;
        }

        System.out.println("List sorted in " + (order == 1 ? "ascending" : "descending") + " order.");
    }

    private void bubbleSort(int[] array, int order) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if ((order == 1 && array[j] > array[j + 1]) || (order == 2 && array[j] < array[j + 1])) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        CircularLinkedList circularList = new CircularLinkedList();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("==================================");
            System.out.println("Circular Linked List Operations:");
            System.out.println("[1] Insert");
            System.out.println("[2] Delete");
            System.out.println("[3] Display");
            System.out.println("[4] Traverse");
            System.out.println("[5] Search");
            System.out.println("[6] Sort");
            System.out.println("[7] Exit");
            System.out.print("Enter Choice: ");
            choice = scanner.nextInt();
             System.out.println("==================================");

            switch (choice) {
                case 1:
                    System.out.print("Enter how many numbers to insert: ");
                    int count = scanner.nextInt();
                    for (int i = 0; i < count; i++) {
                        System.out.print("Enter number " + (i + 1) + ": ");
                        int value = scanner.nextInt();
                        circularList.insert(value);
                    }
                    circularList.display();
                    break;

                case 2:
                    System.out.print("Enter the number to delete: ");
                    int deleteValue = scanner.nextInt();
                    circularList.delete(deleteValue);
                    circularList.display();
                    break;

                case 3:
                    circularList.display();
                    break;

                case 4:
                    circularList.traverse();
                    break;

                case 5:
                    System.out.print("Enter the number to search: ");
                    int searchValue = scanner.nextInt();
                    circularList.search(searchValue);
                    break;

                case 6:
                    System.out.println("[1] Ascending");
                    System.out.println("[2] Descending");
                    System.out.print("Enter Choice: ");
                    int sortChoice = scanner.nextInt();
                    circularList.sort(sortChoice);
                    circularList.display();
                    break;

                case 7:
                    System.out.println("Thank you for using our program.");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }

        } while (choice != 7);

        scanner.close();
    }
}
