class Solution {
    public int sumCounts(List<Integer> nums){
        int answer=0;
        for(int left=0;left<nums.size();left++){
            Set<Integer> distinct=new HashSet<>();
            for(int right=left;right<nums.size();right++){
                distinct.add(nums.get(right));
                int count=distinct.size();
                answer+=count*count;
            }
        }
        return answer;
    }
}
