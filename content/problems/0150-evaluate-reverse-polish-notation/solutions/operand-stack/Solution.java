class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) { if (token.length() == 1 && "+-*/".contains(token)) { int right = stack.pop(), left = stack.pop(); if (token.equals("+")) stack.push(left + right); else if (token.equals("-")) stack.push(left - right); else if (token.equals("*")) stack.push(left * right); else stack.push(left / right); } else stack.push(Integer.parseInt(token)); }
        return stack.pop();
    }
}
