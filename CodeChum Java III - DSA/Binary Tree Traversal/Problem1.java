import java.util.Scanner;
public class Problem1{
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Node root = null;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a test case number: ");
        int testCase = scanner.nextInt();

        switch (testCase) {
            case 1:
            {
                System.out.println("Test Case 1: Insertion and traversal");
                root = tree.insert(root, 5);
                root = tree.insert(root, 3);
                root = tree.insert(root, 8);
                root = tree.insert(root, 1);
                root = tree.insert(root, 4);
                root = tree.insert(root, 7);
                root = tree.insert(root, 9);

                System.out.println("Inorder Traversal of the tree:");
                tree.inorderTraversal(root);
                System.out.println();
                break;
            }
            case 2:
            {
                System.out.println("Test Case 2: Insertion of more values");
                root = tree.insert(root, 6);
                root = tree.insert(root, 2);
                root = tree.insert(root, 10);

                System.out.println("Inorder Traversal after inserting more values:");
                tree.inorderTraversal(root);
                System.out.println();

                break;
            }

            case 3:
            {
                System.out.println("Test Case 3: Insertion of negative values");
                root = tree.insert(root, -5);
                root = tree.insert(root, -3);

                System.out.println("Inorder Traversal after inserting negative values:");
                tree.inorderTraversal(root);
                System.out.println();
                break;
            }
            case 4:
            {
                System.out.println("Test Case 4: Larger tree");
                 root = tree.insert(root, 15);
                root = tree.insert(root, 12);
                root = tree.insert(root, 20);
                root = tree.insert(root, 11);
                root = tree.insert(root, 14);
                root = tree.insert(root, 18);
                root = tree.insert(root, 22);

                System.out.println("Inorder Traversal of a larger tree:");
                tree.inorderTraversal(root);
                System.out.println();
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

    public void inorderTraversal(Node node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.print(node.value + " ");
            inorderTraversal(node.right);
        }
    }
}