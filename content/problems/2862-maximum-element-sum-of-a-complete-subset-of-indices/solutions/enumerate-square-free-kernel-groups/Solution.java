class Solution {
    public long maximumSum(List<Integer> nums){
        int n=nums.size();
        boolean[] squareFree=new boolean[n+1];
        Arrays.fill(squareFree,true);
        for(int factor=2;factor*factor<=n;factor++){
            int square=factor*factor;
            for(int multiple=square;multiple<=n;multiple+=square)squareFree[multiple]=false;
        }
        long answer=0;
        for(int base=1;base<=n;base++){
            if(!squareFree[base])continue;
            long sum=0;
            for(int multiplier=1;(long)base*multiplier*multiplier<=n;multiplier++)sum+=nums.get(base*multiplier*multiplier-1);
            answer=Math.max(answer,sum);
        }
        return answer;
    }
}
