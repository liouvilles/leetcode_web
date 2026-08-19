class Solution {
    public long countExcellentPairs(int[] nums,int k){
        Set<Integer> unique=new HashSet<>();
        for(int value:nums)unique.add(value);
        long[] frequency=new long[31];
        for(int value:unique)frequency[Integer.bitCount(value)]++;
        long answer=0;
        for(int i=0;i<31;i++)for(int j=0;j<31;j++)if(i+j>=k)answer+=frequency[i]*frequency[j];
        return answer;
    }
}
