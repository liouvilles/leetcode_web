class Solution {
    public long numberOfSubarrays(int[] nums){
        ArrayDeque<int[]> stack=new ArrayDeque<>();
        long answer=0;
        for(int value:nums){
            while(!stack.isEmpty()&&stack.peekLast()[0]<value)stack.removeLast();
            if(stack.isEmpty()||stack.peekLast()[0]>value){
                stack.addLast(new int[]{
                    value,1
                });
                answer++;
            }else{
                int[] top=stack.peekLast();
                answer+=top[1]+1L;
                top[1]++;
            }
        }
        return answer;
    }
}
