package midlab1;

/*
    Provides utility functions for the Interface class
 */
public class Utility {
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

    /*  @Cj @Clarence
        parseInput():
            Gets input from the keyboard
            Creates corresponding Token objects (either operand or operator)
            for every user input.
            return: a Stack of Tokens (Stack<Token>)
     */

    /*  @Enrico @Clarence @Cj (less workload for Clarence, since assigned to parseInput())
        fromInfixtoPostfixTable():
            Take the stack of tokens from parseInput()
            Then output a table of values shown on PAGES 11-12
     */

    /*  @Jerome @Cj (less workload for CJ, since assigned to parseInput())
        fromPostfixToInfixTable():
            Take the stack of tokens from parseInput()
            Then output a table of values shown on PAGES 12-13
     */

}
