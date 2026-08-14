class MinStack {
    private final Deque<int[]> stack = new ArrayDeque<>();
    public MinStack() {}
    public void push(int value) { int minimum = stack.isEmpty() ? value : Math.min(value, stack.peek()[1]); stack.push(new int[] {value, minimum}); }
    public void pop() { stack.pop(); }
    public int top() { return stack.peek()[0]; }
    public int getMin() { return stack.peek()[1]; }
}
