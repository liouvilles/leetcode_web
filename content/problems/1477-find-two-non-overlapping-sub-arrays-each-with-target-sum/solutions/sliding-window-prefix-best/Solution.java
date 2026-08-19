class Solution {
    public int minSumOfLengths(int[] arr,int target){
        int n=arr.length,inf=1_000_000,left=0,sum=0,bestSoFar=inf,result=inf;
        int[] best=new int[n];
        Arrays.fill(best,inf);
        for(int right=0;right<n;right++){
            sum+=arr[right];
            while(sum>target)sum-=arr[left++];
            if(sum==target){
                int length=right-left+1;
                if(left>0&&best[left-1]<inf)result=Math.min(result,length+best[left-1]);
                bestSoFar=Math.min(bestSoFar,length);
            }
            best[right]=bestSoFar;
        }
        return result==inf?-1:result;
    }
}
