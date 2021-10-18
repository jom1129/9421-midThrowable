package midlab1;


import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

/*
    Provides utility functions for the Interface class
 */
public class Utility {
    static <T> void printStack(LinkedStack<Token> stack) {
        Node<Token> current = stack.getTop();

        if(stack.isEmpty()) {
            System.out.println("Empty stack.");
            return;
        }

        while (current != null) {
            System.out.print(current.getInfo());
            System.out.print(",");
            current = current.getLink();
        }

    }

    /*
        NOTICE: The provided reference.pdf is only for the tables of the ISP and ICP values.
                For everything else, consult the official Module!!!!
     */

    /*  @Cj @Clarence
        parseInput():
            Gets input from the keyboard
            Creates corresponding Token objects (either operand or operator)
            for every user input.
            return: a Stack of Tokens (Stack<Token>)
     */
    static LinkedStack<Token> parseInput() throws IOException{
        Token token ;
        LinkedStack<Token> stack = new LinkedStack<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        String symbol = "";
        for (int i = line.length() -1; i != -1 ; i--) {
            char c = line.charAt(i);
            symbol = Character.toString(c);
            token = new Token(symbol);
            stack.push(token);
        }
        return stack;
    }

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
    static <T> void postfixEvaluateTable() throws IOException {
        System.out.println("Enter a Postfix String");
        LinkedStack<Token> stack = parseInput();
        Node<Token> current = stack.getTop();
        LinkedStack<Token> operandStack = new LinkedStack<>();
        double operand1, operand2;
        System.out.printf("%-10s%-10s%-10s%-10s%-10s%n", "Symbol", "operand1", "operand2", "value", "operandStack");
        while(current != null){
            if(current.getInfo().isOperand){
                System.out.printf("%-10s", current.getInfo() );
                operandStack.push(current.getInfo());
                System.out.printf("%-10s%-10s%-10s", " ", " ", " ");
                printStack(operandStack);
                System.out.println();
            }
            if(!current.getInfo().isOperand){
                System.out.printf("%-10s", current.getInfo() );
                operand2 = Double.parseDouble(operandStack.pop().toString());
                operand1 = Double.parseDouble(operandStack.pop().toString());
                System.out.printf("%-10.0f", operand1 );
                System.out.printf("%-10.0f", operand2 );
                if(current.getInfo().toString().equals("*")){
                    double result = operand1*operand2;
                    Token tempToken = new Token(String.valueOf(result));
                    System.out.printf("%-10.0f", result );
                    operandStack.push(tempToken);
                }
                if(current.getInfo().toString().equals("/")){
                    double result = operand1/operand2;
                    Token tempToken = new Token(String.valueOf(result));
                    System.out.printf("%-10.0f", result );
                    operandStack.push(tempToken);
                }
                if(current.getInfo().toString().equals("+")){
                    double result = operand1+operand2;
                    Token tempToken = new Token(String.valueOf(result));
                    System.out.printf("%-10.0f", result );
                    operandStack.push(tempToken);
                }
                if(current.getInfo().toString().equals("-")){
                    double result = operand1-operand2;
                    Token tempToken = new Token(String.valueOf(result));
                    System.out.printf("%-10.0f", result );
                    operandStack.push(tempToken);
                }
                if(current.getInfo().toString().equals("^")){
                    double result = Math.pow(operand1,operand2);
                    Token tempToken = new Token(String.valueOf(result));
                    System.out.printf("%-10.0f", result );
                    operandStack.push(tempToken);
                }
                printStack(operandStack);
                System.out.println();
            }
            current = current.getLink();
        }
    }
    public static void main(String[] args) throws IOException {
        postfixEvaluateTable();
    }

}
6y
