class Solution {
    public int maxNonOverlapping(int[] nums,int target){
        Set<Integer> seen=new HashSet<>();
        seen.add(0);
        int prefix=0,answer=0;
        for(int value:nums){
            prefix+=value;
            if(seen.contains(prefix-target)){
                answer++;
                seen.clear();
                seen.add(0);
                prefix=0;
            }else seen.add(prefix);
        }
        return answer;
    }
}
