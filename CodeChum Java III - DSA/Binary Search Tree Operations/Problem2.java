import java.util.Scanner;
public class Problem2{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter test case number (1 or 2): ");
        int testCase = scanner.nextInt();

        BinaryTree tree = new BinaryTree();
        Node root = null;

        switch (testCase) {
            case 1:
                // Test Case 1
                root = tree.insert(root, 3);
                root = tree.insert(root, 5);
                root = tree.insert(root, 8);
                root = tree.insert(root, 1);
                root = tree.insert(root, 6);
                root = tree.insert(root, 4);
                root = tree.insert(root, 7);
                root = tree.insert(root, 8);

                System.out.println("Elements of the first tree:");
                tree.displayTree(root);

                System.out.println(tree.search(root, 10) != null ? "\n10 exists" : "\n10 does not exist");
                break;

            case 2:
                // Test Case 2
                root = tree.insert(root, 10);
                root = tree.insert(root, 8);
                root = tree.insert(root, -1);
                root = tree.insert(root, 3);
                root = tree.insert(root, 12);
                root = tree.insert(root, 55);
                root = tree.insert(root, 2);
                root = tree.insert(root, 100);

                System.out.println("Elements of the second tree:");
                tree.displayTree(root);

                System.out.println(tree.search(root, 100) != null ? "\n100 exists" : "\n100 does not exist");
                break;

            default:
                System.out.println("Invalid test case number.");
                break;
        }
    }
}
class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }
}

class BinaryTree {
    public void displayTree(Node node) {
        if (node != null) {
            displayTree(node.left);
            System.out.print(node.value + " ");
            displayTree(node.right);
        }
    }

    public Node insert(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }
    
        if (value < node.value) {
            node.left = insert(node.left, value);
        } else if (value > node.value) {
            node.right = insert(node.right, value);
        }
    
        return node;
    }

    public Node search(Node node, int value) {
        if (node == null || node.value == value) {
            return node;
        }
    
        if (value < node.value) {
            return search(node.left, value);
        } else {
            return search(node.right, value);
        }
    }
}