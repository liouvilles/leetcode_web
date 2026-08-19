class Solution {
    public int numberOfGoodPartitions(int[] nums){
        final long MOD=1000000007;
        Map<Integer,Integer> last=new HashMap<>();
        for(int i=0;i<nums.length;i++)last.put(nums[i],i);
        int components=0,farthest=0;
        for(int i=0;i<nums.length;i++){
            farthest=Math.max(farthest,last.get(nums[i]));
            if(i==farthest)components++;
        }
        long answer=1,base=2;
        int exponent=components-1;
        while(exponent>0){
            if((exponent&1)==1)answer=answer*base%MOD;
            base=base*base%MOD;
            exponent>>=1;
        }
        return (int)answer;
    }
}
