import java.util.Scanner;
class Stack {
    public int top;
    public int value;
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

    public static void push(Stack stack, int item) {
        if (!isFull(stack, 100)) {
            Stack nextNode = stack.next;
            Stack newNode = new Stack();
            newNode.value = item;
            newNode.next = nextNode;
            stack.next = newNode;
            stack.top++;
        }
    }

    public static int pop(Stack stack) {
        if (!isEmpty(stack)) {
            Stack firstNode = stack.next;
            stack.next = firstNode.next;
            stack.top--;
            return firstNode.value;
        }
        return 0;
    }

    public static int peek(Stack stack) {
        return (!isEmpty(stack)) ? stack.next.value : 0;
    }
}
public class Problem6{
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter expression: ");
        String exp = scanner.nextLine();

        System.out.println(evaluatePostfix(exp.split(" ")));
    }

    public static int evaluatePostfix(String[] exp) {
        Stack stack = Stack.createEmptyStack();

        for (int i = 0; i < exp.length; i++) {
            String c = exp[i];

            if (Character.isDigit(c.charAt(0))) {
                Stack.push(stack, Integer.parseInt(c));
            } else {
                int val1 = Stack.pop(stack);
                int val2 = Stack.pop(stack);

                switch (c.charAt(0)) {
                    case '+':
                        Stack.push(stack, val2 + val1);
                        break;

                    case '-':
                        Stack.push(stack, val2 - val1);
                        break;

                    case '/':
                        Stack.push(stack, val2 / val1);
                        break;

                    case '*':
                        Stack.push(stack, val2 * val1);
                        break;
                }
            }
        }

        return Stack.pop(stack);
    }
}