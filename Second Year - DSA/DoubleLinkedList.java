import java.util.Scanner;

class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class DoublyLinkedList {
    Node head;

    void insert(int num) {
        Node newNode = new Node(num);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }
    }

    void delete(int num) {
        Node temp = head;
        while (temp != null && temp.data != num) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println(num + " is NOT FOUND in the list.");
        } else {
            if (temp.prev != null) {
                temp.prev.next = temp.next;
            } else {
                head = temp.next;
            }

            if (temp.next != null) {
                temp.next.prev = temp.prev;
            }

            System.out.println(num + " has been deleted.");
        }
    }

    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    void traverse() {
        Node temp = head;
        while (temp != null) {
            System.out.println("Node: " + temp.data + " , Next: " + (temp.next != null ? temp.next.data : "null"));
            temp = temp.next;
        }
    }

    void search(int num) {
        Node temp = head;
        while (temp != null && temp.data != num) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("The " + num + " was NOT FOUND.");
        } else {
            System.out.println("The " + num + " was FOUND.");
        }
    }

    void sort(int order) {
        // Bubble Sort
        Node current, index;
        int temp;

        if (head == null) {
            return;
        }

        for (current = head; current.next != null; current = current.next) {
            for (index = current.next; index != null; index = index.next) {
                if (order == 1 && current.data > index.data) {
                    temp = current.data;
                    current.data = index.data;
                    index.data = temp;
                } else if (order == 2 && current.data < index.data) {
                    temp = current.data;
                    current.data = index.data;
                    index.data = temp;
                }
            }
        }
    }
}

public class DoubleLinkedList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DoublyLinkedList list = new DoublyLinkedList();

        int choice;

        do {
            System.out.println("=================================");
            System.out.println("Doubly Linked List Operations:");
            System.out.println("[1] Insert");
            System.out.println("[2] Delete");
            System.out.println("[3] Display");
            System.out.println("[4] Traverse");
            System.out.println("[5] Search");
            System.out.println("[6] Sort");
            System.out.println("[7] Exit");
            System.out.print("Enter Choice: ");
            choice = scanner.nextInt();
            System.out.println("=================================");

            switch (choice) {
                case 1:
                    System.out.print("Enter how many numbers to insert: ");
                    int count = scanner.nextInt();
                    for (int i = 0; i < count; i++) {
                        System.out.print("Enter number " + (i + 1) + ": ");
                        int num = scanner.nextInt();
                        list.insert(num);
                    }
                    System.out.println("Updated list:");
                    list.display();
                    break;
                case 2:
                    System.out.print("Enter number to delete: ");
                    int numToDelete = scanner.nextInt();
                    list.delete(numToDelete);
                    System.out.println("Updated list:");
                    list.display();
                    break;
                case 3:
                    System.out.println("Current linked list:");
                    list.display();
                    break;
                case 4:
                    System.out.println("Traversing the list:");
                    list.traverse();
                    break;
                case 5:
                    System.out.print("Enter number to search: ");
                    int numToSearch = scanner.nextInt();
                    list.search(numToSearch);
                    break;
                case 6:
                    System.out.println("[1] Ascending\n[2] Descending");
                    System.out.print("Enter Choice: ");
                    int sortChoice = scanner.nextInt();
                    list.sort(sortChoice);
                    System.out.println("Sorted list:");
                    list.display();
                    break;
                case 7:
                    System.out.println("Thank you for using our program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        } while (choice != 7);
    }
}
