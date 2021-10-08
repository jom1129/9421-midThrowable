package midlab1;

public class Token {
    String token;
    boolean isOperand = false;
    int isp, icp;

    public Token(String token) {
        this.token = token;
        setPriority(token);
    }

    void setPriority(String token) {
        switch (token) {
            case "^":
                icp = 3;
                isp = 3;
                break;
            case "*":
            case "/":
                icp = 2;
                isp = 2;
                break;
            case "+":
            case "-":
                icp = 1;
                isp = 1;
                break;
            case "(":
                icp = 4;
                isp = 0;
                break;
            case ")":
            case "#":
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
