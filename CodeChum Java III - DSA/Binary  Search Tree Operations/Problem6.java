import java.util.Scanner;
public class Problem6{
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

                int sum1 = tree.sumOfAllElements(root);
                System.out.println("\nSum of all elements in the first tree: " + sum1);
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

                int sum2 = tree.sumOfAllElements(root);
                System.out.println("\nSum of all elements in the second tree: " + sum2);
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

    public int sumOfAllElements(Node node) {
        if (node == null) {
            return 0;
        }
    
        int leftSum = sumOfAllElements(node.left);
        int rightSum = sumOfAllElements(node.right);
    
        return node.value + leftSum + rightSum;
    }
}