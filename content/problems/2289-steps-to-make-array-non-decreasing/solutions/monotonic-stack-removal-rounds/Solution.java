class Solution {
    public int totalSteps(int[] nums){
        Deque<int[]> stack=new ArrayDeque<>();
        int answer=0;
        for(int value:nums){
            int steps=0;
            while(!stack.isEmpty()&&stack.peek()[0]<=value)steps=Math.max(steps,stack.pop()[1]);
            if(!stack.isEmpty())steps++;
            else steps=0;
            answer=Math.max(answer,steps);
            stack.push(new int[]{
                value,steps
            });
        }
        return answer;
    }
}
