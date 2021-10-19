package midlab1;

public class Token {
    String token;
    boolean isOperand = false;
    boolean isOperator = false;
    boolean isEx = false;
    int isp, icp;

    public Token(String token) {
        this.token = token;
        setPriority(token);
    }

    public String toString() {return token;}

    void setPriority(String token) {
        switch (token) {
            case "^":
                icp = 6;
                isp = 5;
                isEx = true;
                break;
            case "*":
            case "/":
                icp = 3;
                isp = 4;
                isOperator = true;
                break;
            case "+":
            case "-":
                icp = 1;
                isp = 2;
                isOperator = true;
                isOperand = false;
                break;
            case "(":
            case ")":
                icp = 0;
                isp = 0;
                break;
            default:
                icp = 1;
                isp = 1;
                isOperand = true;
        }
    }

}
