class Solution {
    public int maxWidthRamp(int[] nums){
        Deque<Integer> stack=new ArrayDeque<>();
        for(int i=0;i<nums.length;i++)if(stack.isEmpty()||nums[i]<nums[stack.peek()])stack.push(i);
        int answer=0;
        for(int j=nums.length-1;j>=0;j--)while(!stack.isEmpty()&&nums[stack.peek()]<=nums[j])answer=Math.max(answer,j-stack.pop());
        return answer;
    }
}
