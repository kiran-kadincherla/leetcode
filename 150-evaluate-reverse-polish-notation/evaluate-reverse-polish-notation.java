class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> prevNumbers = new Stack<>();
        Set<String> operators = new HashSet<>(List.of("+", "-", "*", "/"));

        for (String token : tokens) {
            if (operators.contains(token)) {
                int right = prevNumbers.pop();
                int left = prevNumbers.pop();
                int num3 = calculate(left, right, token);
                prevNumbers.push(num3);
            } else {
                prevNumbers.push(Integer.valueOf(token));
            }
        }
        return prevNumbers.pop();
    }

    public static int calculate(int left, int right, String operator) {
    return switch (operator) {
        case "+" -> left + right;
        case "-" -> left - right;
        case "*" -> left * right;
        case "/" -> {
            if (right == 0) throw new ArithmeticException("Division by zero");
            yield left / right;
        }
        default -> throw new IllegalArgumentException("Unknown operator: " + operator);
    };
}
}