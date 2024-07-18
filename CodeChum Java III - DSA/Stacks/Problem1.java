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
            Stack nextNode = stack.next;
            Stack newNode = new Stack();

            stack.next = newNode;
            newNode.value = item;
            newNode.next = nextNode;

            stack.top++;
        }
    }

    public static char pop(Stack stack) {
        if (!isEmpty(stack)) {
            Stack firstNode = stack.next;
            Stack secondNode = firstNode.next;

            stack.next = secondNode;
            stack.top--;

            return firstNode.value;
        }
        return '\0';
    }

    public static char peek(Stack stack) {
        return (!isEmpty(stack)) ? stack.next.value : '\0';
    }

    public static void display(Stack stack) {
        Stack current = stack.next;
        while (current != null) {
            System.out.printf("%c\n", current.value);
            current = current.next;
        }
    }
}

public class Problem1{
        public static void main(String[] args) {
        Stack stack = Stack.createEmptyStack();
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = in.nextLine();

        for(int i = 0; i < str.length(); i++) {
            Stack.push(stack, str.charAt(i)); 
        }
        
        while(!Stack.isEmpty(stack)) {
            System.out.print(Stack.pop(stack));
        }
    }
}