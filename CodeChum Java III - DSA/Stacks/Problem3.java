import java.util.Scanner;
class Stack {
    public int top;
    public char value;
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

    public static void push(Stack stack, char item) {
        if (!isFull(stack, 100)) {
            Stack newNode = new Stack();
            newNode.value = item;
            newNode.next = stack.next;
            stack.next = newNode;
            stack.top++;
        }
    }

    public static char pop(Stack stack) {
        if (!isEmpty(stack)) {
            Stack firstNode = stack.next;
            stack.next = firstNode.next;
            stack.top--;
            return firstNode.value;
        }
        return '\0';
    }

    public static char peek(Stack stack) {
        return (!isEmpty(stack)) ? stack.next.value : '\0';
    }
}
public class Problem3{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter string: ");
        String input = scanner.nextLine();

        System.out.println(isBalanced(input) ? "True" : "False");
    }

    public static boolean isBalanced(String s) {
        Stack stack = Stack.createEmptyStack();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                Stack.push(stack, c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (Stack.isEmpty(stack)) {
                    return false;
                }
                char top = Stack.pop(stack);
                if ((c == ')' && top != '(') || (c == ']' && top != '[') || (c == '}' && top != '{')) {
                    return false;
                }
            }
        }

        return Stack.isEmpty(stack);
    }
}