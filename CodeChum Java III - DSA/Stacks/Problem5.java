 import java.util.Scanner;
 class Stack {
    public int top;
    public String value;
    public Stack next;

    public static Stack createEmptyStack() {
        Stack stack = new Stack();
        stack.top = -1;
        return stack;
    }

    public static boolean isFull(Stack stack, int size) {
        return stack.top == size - 1;
    }

    public static boolean isEmpty(Stack stack) {
        return stack.top == -1;
    }

    public static void push(Stack stack, String item) {
        if (!isFull(stack, 100)) {
            Stack nextNode = stack.next;
            Stack newNode = new Stack();

            stack.next = newNode;
            newNode.value = item;
            newNode.next = nextNode;
            stack.top++;
        }
    }

    public static String pop(Stack stack) {
        if (!isEmpty(stack)) {
            Stack firstNode = stack.next;
            stack.next = firstNode.next;
            stack.top--;
            return firstNode.value;
        }
        return "";
    }

    public static String peek(Stack stack) {
        return (!isEmpty(stack)) ? stack.next.value : "";
    }
}
public class Problem5{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter expression: ");
        String postfix = scanner.nextLine();

        System.out.println(postfixToPrefix(postfix));
    }

    public static String postfixToPrefix(String postfix) {
        Stack stack = Stack.createEmptyStack();

        for (int i = 0; i < postfix.length(); i++) {
            char c = postfix.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                stack.push(stack, String.valueOf(c));
            } else {
                String op1 = Stack.pop(stack);
                String op2 = Stack.pop(stack);
                String prefix = c + op2 + op1;
                Stack.push(stack, prefix);
            }
        }

        return Stack.pop(stack);
    }
}