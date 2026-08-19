class Solution {
    public int countCompleteSubarrays(int[] nums){
        Set<Integer> all=new HashSet<>();
        for(int value:nums)all.add(value);
        Map<Integer,Integer> frequency=new HashMap<>();
        int required=all.size(),distinct=0,left=0,answer=0;
        for(int value:nums){
            int count=frequency.getOrDefault(value,0);
            if(count==0)distinct++;
            frequency.put(value,count+1);
            while(distinct==required){
                int removed=nums[left++],remaining=frequency.get(removed)-1;
                frequency.put(removed,remaining);
                if(remaining==0)distinct--;
            }
            answer+=left;
        }
        return answer;
    }
}
