import java.util.Scanner;
public class Problem5{
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Node root = null;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a test case number: ");
        int testCase = scanner.nextInt();

        switch (testCase) {
            case 1: {
                System.out.println("Test Case 1: Insertion and calculation of sum of even nodes");
                root = tree.insert(root, 5);
                root = tree.insert(root, 3);
                root = tree.insert(root, 8);
                root = tree.insert(root, 1);
                root = tree.insert(root, 4);
                root = tree.insert(root, 7);
                root = tree.insert(root, 9);
                root = tree.insert(root, 6);
                root = tree.insert(root, 2);
                root = tree.insert(root, 10);
                root = tree.insert(root, -5);
                root = tree.insert(root, -3);
                root = tree.insert(root, 15);
                root = tree.insert(root, 12);
                root = tree.insert(root, 20);
                root = tree.insert(root, 11);
                root = tree.insert(root, 14);
                root = tree.insert(root, 18);
                root = tree.insert(root, 22);

                System.out.println("Sum of even nodes: " + tree.sumEvenNodes(root));
                break;
            }
            case 2: {
                System.out.println("Test Case 2: Insertion of more values and recalculation of sum of even nodes");
                root = tree.insert(root, -5);
                root = tree.insert(root, -6);
                root = tree.insert(root, -10);
                root = tree.insert(root, 11);
                root = tree.insert(root, 105);

                System.out.println("Sum of even nodes: " + tree.sumEvenNodes(root));
                break;
            }
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

    public int sumEvenNodes(Node node) {
        if (node == null) {
            return 0;
        }
        int sum = 0;
        if (node.value % 2 == 0) {
            sum = node.value;
        }
        return sum + sumEvenNodes(node.left) + sumEvenNodes(node.right);
    }
}