class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int best = 0;
        for (int index = 0; index <= heights.length; index++) {
            int height = index == heights.length ? 0 : heights[index];
            while (stack.peek() != -1 && heights[stack.peek()] > height) {
                int rectangleHeight = heights[stack.pop()];
                best = Math.max(best, rectangleHeight * (index - stack.peek() - 1));
            }
            stack.push(index);
        }
        return best;
    }
}
