class Solution { public int minimumSum(int n,int k){long first=Math.min(n,k/2),remaining=n-first;long answer=first*(first+1)/2+remaining*(2L*k+remaining-1)/2;return (int)answer;} }
