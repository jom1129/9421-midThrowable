package midlab1;

/**
 * Data Structure that represents a Token
 */
public class Token {
    // FIELDS
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

    /**
     * Sets the priority automatically
     * according to established ICP (Incoming priority)
     * and ISP (In-Stack Priority) variables.
     * @param token
     */
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
