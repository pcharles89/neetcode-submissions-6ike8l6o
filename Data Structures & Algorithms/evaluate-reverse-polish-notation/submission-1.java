class Solution{
public int evalRPN(String[] tokens) {
    Stack<Integer> stack = new Stack<>();

    for (String token : tokens) {
        if (isOperator(token)) {
            int b = stack.pop();   // second operand
            int a = stack.pop();   // first operand

            int result = 0;
            switch (token) {
                case "+" -> result = a + b;
                case "-" -> result = a - b;
                case "*" -> result = a * b;
                case "/" -> result = a / b;  // integer division truncates toward 0
            }

            stack.push(result);
        } else {
            stack.push(Integer.parseInt(token));
        }
    }

    return stack.pop();
}

private boolean isOperator(String s) {
    return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
}
}
