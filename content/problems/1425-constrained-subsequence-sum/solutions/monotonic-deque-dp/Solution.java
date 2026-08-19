class Solution {
    public int constrainedSubsetSum(int[] nums,int k){
        int[] dp=new int[nums.length];
        Deque<Integer> deque=new ArrayDeque<>();
        int answer=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            while(!deque.isEmpty()&&deque.peekFirst()<i-k)deque.removeFirst();
            dp[i]=nums[i]+(deque.isEmpty()?0:Math.max(0,dp[deque.peekFirst()]));
            while(!deque.isEmpty()&&dp[deque.peekLast()]<=dp[i])deque.removeLast();
            deque.addLast(i);
            answer=Math.max(answer,dp[i]);
        }
        return answer;
    }
}
