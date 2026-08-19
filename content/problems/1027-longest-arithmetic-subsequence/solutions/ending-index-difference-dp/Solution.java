class Solution {
    public int longestArithSeqLength(int[] nums){
        List<Map<Integer,Integer>> dp=new ArrayList<>();
        int answer=2;
        for(int i=0;i<nums.length;i++){
            dp.add(new HashMap<>());
            for(int j=0;j<i;j++){
                int difference=nums[i]-nums[j];
                int length=dp.get(j).getOrDefault(difference,1)+1;
                dp.get(i).merge(difference,length,Math::max);
                answer=Math.max(answer,length);
            }
        }
        return answer;
    }
}
