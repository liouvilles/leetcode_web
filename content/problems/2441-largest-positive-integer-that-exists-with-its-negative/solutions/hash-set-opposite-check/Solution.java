class Solution {
    public int findMaxK(int[] nums){
        Set<Integer> values=new HashSet<>();
        for(int value:nums)values.add(value);
        int answer=-1;
        for(int value:nums)if(value>0&&values.contains(-value))answer=Math.max(answer,value);
        return answer;
    }
}
