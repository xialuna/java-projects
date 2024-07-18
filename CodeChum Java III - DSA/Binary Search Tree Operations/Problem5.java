import java.util.Scanner;
public class Problem5{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter test case number (1 or 2): ");
        int testCase = scanner.nextInt();

        BinaryTree tree = new BinaryTree();
        Node root = null;

        switch (testCase) {
            case 1:
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

                root = tree.delete(root, 8);
                System.out.println("\nAfter deleting 8 from the first tree:");
                tree.displayTree(root);
                break;

            case 2:
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

                root = tree.delete(root, 100);
                System.out.println("\nAfter deleting 100 from the second tree:");
                tree.displayTree(root);
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

    public Node getMaximumValueNode(Node node) {
        if (node.right == null) {
            return node;
        } else {
            return getMaximumValueNode(node.right);
        }
    }

    public Node delete(Node node, int value) {
        if (node == null) {
            return null;
        }
    
        if (value < node.value) {
            node.left = delete(node.left, value);
        } else if (value > node.value) {
            node.right = delete(node.right, value);
        } else {
            // node with no leaf nodes
            if (node.left == null && node.right == null) {
                return null;
            } else if (node.left == null) {
                // node with one node (no left node)
                return node.right;
            } else if (node.right == null) {
                // node with one node (no right node)
                return node.left;
            } else {
                // nodes with two nodes
                // search for min number in right sub tree
                Node min = getMaximumValueNode(node.right);
                node.value = min.value;
                // delete the value from right subtree.
                node.right = delete(node.right, min.value);
            }
        }
    
        return node;
    }
}