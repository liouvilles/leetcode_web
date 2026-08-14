class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length]; Deque<Integer> stack = new ArrayDeque<>();
        for (int day = 0; day < temperatures.length; day++) { while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[day]) { int previous = stack.pop(); answer[previous] = day - previous; } stack.push(day); }
        return answer;
    }
}
