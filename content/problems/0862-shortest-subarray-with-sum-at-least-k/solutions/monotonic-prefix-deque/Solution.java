class Solution {
    public int shortestSubarray(int[] nums,int k){
        long[] prefix=new long[nums.length+1];
        for(int i=0;i<nums.length;i++)prefix[i+1]=prefix[i]+nums[i];
        Deque<Integer> deque=new ArrayDeque<>();
        int answer=nums.length+1;
        for(int right=0;right<prefix.length;right++){
            while(!deque.isEmpty()&&prefix[right]-prefix[deque.peekFirst()]>=k)answer=Math.min(answer,right-deque.removeFirst());
            while(!deque.isEmpty()&&prefix[deque.peekLast()]>=prefix[right])deque.removeLast();
            deque.addLast(right);
        }
        return answer>nums.length?-1:answer;
    }
}
