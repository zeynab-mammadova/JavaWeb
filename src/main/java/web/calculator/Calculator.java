package web.calculator;

public class Calculator {
    public String operate(String op1, String op2, String operation) {
        int a;
        int b;
        try {
            a = Integer.parseInt(op1);
            b = Integer.parseInt(op2);
        } catch (Exception e){
            return "Invalid input";
        }
        switch (operation) {
            case "add":
                return String.format("%d", add(a, b));
            case "sub":
                return String.format("%d", subtract(a, b));
            case "div":
                return String.format("%s", divide(a, b));
            case "mul":
                return String.format("%d", multiply(a, b));
            default:
                return "Wrong operation.";
        }
    }

    private int add(int a, int b) {
        return a + b;
    }

    private int subtract(int a, int b) {
        return a - b;
    }

    private String divide(int a, int b) throws NullPointerException {
        if(b == 0) return "Division by zero.";
        return String.format("%s",(double) a / b);
    }

    private int multiply(int a, int b) {
        return a * b;
    }
}
