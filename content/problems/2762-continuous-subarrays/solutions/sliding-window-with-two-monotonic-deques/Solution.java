class Solution {
    public long continuousSubarrays(int[] nums){
        Deque<Integer> maximum=new ArrayDeque<>(),minimum=new ArrayDeque<>();
        int left=0;
        long answer=0;
        for(int right=0;right<nums.length;right++){
            while(!maximum.isEmpty()&&nums[maximum.peekLast()]<nums[right])maximum.removeLast();
            while(!minimum.isEmpty()&&nums[minimum.peekLast()]>nums[right])minimum.removeLast();
            maximum.addLast(right);
            minimum.addLast(right);
            while(nums[maximum.peekFirst()]-nums[minimum.peekFirst()]>2){
                if(maximum.peekFirst()==left)maximum.removeFirst();
                if(minimum.peekFirst()==left)minimum.removeFirst();
                left++;
            }
            answer+=right-left+1;
        }
        return answer;
    }
}
