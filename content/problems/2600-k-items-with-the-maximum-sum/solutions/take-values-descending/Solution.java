class Solution { public int kItemsWithMaximumSum(int numOnes,int numZeros,int numNegOnes,int k){int ones=Math.min(k,numOnes);k-=ones;k-=Math.min(k,numZeros);return ones-k;} }
