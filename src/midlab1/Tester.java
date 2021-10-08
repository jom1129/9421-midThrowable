package midlab1;

public class Tester {

    static <T> void printStack(LinkedStack<T> stack) {
        Node<T> current = stack.getTop();
        if(stack.isEmpty()) {
            System.out.println("Empty stack.");
            return;
        }
        System.out.print("Stack content: ");
        while (current != null) {
            System.out.print(current.getInfo());
            current = current.getLink();
        }
    }

    // parseInput()
    //


    public static void main(String[] args) {
        LinkedStack<Integer> integerStack = new LinkedStack<>();
        integerStack.push(1);
        integerStack.push(2);
        integerStack.push(3);
        integerStack.push(4);
        printStack(integerStack);
        integerStack.pop();
        printStack(integerStack);
    }
}
