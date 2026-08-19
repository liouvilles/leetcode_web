class Solution { public:int kItemsWithMaximumSum(int numOnes,int numZeros,int numNegOnes,int k){int ones=min(k,numOnes);k-=ones;k-=min(k,numZeros);return ones-k;} };
