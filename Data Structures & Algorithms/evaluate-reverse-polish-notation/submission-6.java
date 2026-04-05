class Solution{
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        
        for(String token : tokens){
            if(isOperator(token)){
                int second = stack.pop();
                int first = stack.pop();
                int result = 0;
                switch(token) {
                    case "+" -> result = first + second;
                    case "-" -> result = first - second;
                    case "*" -> result = first * second;
                    case "/" -> result = first / second;
                }
               stack.push(result);
            }
            else {

            stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
    private boolean isOperator(String s){
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }
}
