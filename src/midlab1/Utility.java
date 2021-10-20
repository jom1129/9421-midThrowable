package midlab1;


/*
    Provides utility functions for the Interface class
 */
public class Utility {
    static <T> void printStack(LinkedStack<T> stack) {

        if (stack.isEmpty()) return;

        T element = stack.peek();
        stack.pop();
        printStack(stack);

        System.out.print(element + " ");
        stack.push(element);
    }

    static LinkedStack<Token> parseInput(String input) {
        Token token;
        String symbol = "";
        LinkedStack<Token> stack = new LinkedStack<>();

        for (int i = input.length() - 1; i != -1; i--) {
            char c = input.charAt(i);
            symbol = Character.toString(c);
            token = new Token(symbol);
            stack.push(token);
        }

        return stack;
    }

    static void infixToPostfixTable(LinkedStack<Token> stack) {

        Node<Token> current = stack.getTop();
        LinkedStack<Token> operatorStack = new LinkedStack<>();
        LinkedStack<Token> postFixStack = new LinkedStack<>();
        LinkedStack<Token> d = new LinkedStack<>();

        System.out.printf("%-10s%-25s%-10s%n", "Symbol", "postfixExpression", "operatorStack");
        while(current != null) {
            System.out.printf("%-10s", current.getInfo());
            if (current.getInfo().toString().equals("(")){
                printStack(postFixStack);
                System.out.printf("%-25s", " ");
                operatorStack.push(current.getInfo());
                printStack(operatorStack);
                System.out.println();
            }
            if (current.getInfo().toString().equals(")")){
                while(!operatorStack.peek().toString().equals("(")) {
                    postFixStack.push(operatorStack.pop());

                    if (operatorStack.peek().toString().equals("(")){
                        d.push(operatorStack.pop());
                        printStack(postFixStack);
                        System.out.printf("%-25s", " ");
                        printStack(operatorStack);
                        System.out.println();
                        break;
                    }
                }
            }

            if (current.getInfo().isOperator) {

                if (current.getInfo().icp < operatorStack.peek().isp) {
                    while (current.getInfo().icp < operatorStack.peek().isp) {
                        postFixStack.push(operatorStack.pop());
                    }
                } else if (current.getInfo().icp > operatorStack.peek().isp) {
                    printStack(postFixStack);
                    System.out.printf("%-25s", " ");
                    operatorStack.push(current.getInfo());
                    printStack(operatorStack);
                    System.out.println();
                }
            }
            if(current.getInfo().isEx) {
                if (operatorStack.isEmpty()) {
                    printStack(postFixStack);
                    System.out.printf("%-25s", " ");
                    operatorStack.push(current.getInfo());
                    printStack(operatorStack);
                    System.out.println();
                }
            }
            if (current.getInfo().isOperand){

                postFixStack.push(current.getInfo());
                printStack(postFixStack);
                System.out.printf("%-25s", " ");
                printStack(operatorStack);
                System.out.println();

            }

            current = current.getLink();
        }
        if(!operatorStack.isEmpty()){
            postFixStack.push(operatorStack.pop());
            System.out.printf("%-10s", " ");
            printStack(postFixStack);
            System.out.printf("%-25s", " ");

            printStack(operatorStack);
            System.out.println();
        }
    }

    static void postfixEvaluateTable(LinkedStack<Token> stack) {
        Node<Token> current = stack.getTop();
        LinkedStack<Token> operandStack = new LinkedStack<>();
        Token newToken;
        String x= "";
        String y ="";
        double operand1, operand2;
        System.out.printf("%-10s%-10s%-10s%-10s%-10s%n", "Symbol", "operand1", "operand2", "value", "operandStack");
        while(current != null){
            if (current.getInfo().toString().equals(" ")) {
                current = current.getLink();
                x=y;
            }

            if (current.getInfo().toString().equals(" ")) {
                current = current.getLink();
            }
            if(current.getInfo().isOperand){
                if(!current.getLink().getInfo().toString().equals(" ")) {
                    x = (current.getInfo().toString());
                    current = current.getLink();
                    y = (current.getInfo().toString());
                    x = x+y;
                    newToken = new Token(x);
                    System.out.printf("%-10s", newToken);
                    operandStack.push(newToken);
                }else {
                    System.out.printf("%-10s", current.getInfo());
                    operandStack.push(current.getInfo());
                }
                System.out.printf("%-10s%-10s%-10s", " ", " ", " ");
                printStack(operandStack);
                System.out.println();
            }

            if(current.getInfo().isOperator | current.getInfo().isEx){
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
            }
            System.out.println();
            current = current.getLink();
        }
    }

}
