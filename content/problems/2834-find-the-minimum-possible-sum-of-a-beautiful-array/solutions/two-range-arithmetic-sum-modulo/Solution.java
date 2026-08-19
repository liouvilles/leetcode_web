class Solution {
    public int minimumPossibleSum(int n,int target){
        long first=Math.min(n,target/2),remaining=n-first;
        long answer=first*(first+1)/2+remaining*(2L*target+remaining-1)/2;
        return (int)(answer%1000000007);
    }
}
