class Solution {
    public long maximumBeauty(int[] flowers,long newFlowers,int target,int full,int partial){
        Arrays.sort(flowers);
        int n=flowers.length;
        for(int i=0;i<n;i++)flowers[i]=Math.min(flowers[i],target);
        long[] prefix=new long[n+1];
        int incomplete=0;
        for(int i=0;i<n;i++){
            prefix[i+1]=prefix[i]+flowers[i];
            if(flowers[i]<target)incomplete++;
        }
        long answer=0,fullCost=0;
        for(int remain=incomplete;remain>=0;remain--){
            if(fullCost>newFlowers)break;
            long budget=newFlowers-fullCost,level=0;
            if(remain>0){
                int left=1,right=remain;
                while(left<right){
                    int middle=(left+right+1)/2;
                    long cost=(long)flowers[middle-1]*middle-prefix[middle];
                    if(cost<=budget)left=middle;
                    else right=middle-1;
                }
                level=Math.min(target-1,(prefix[left]+budget)/left);
            }
            long beauty=(long)(n-remain)*full+level*partial;
            answer=Math.max(answer,beauty);
            if(remain>0)fullCost+=target-flowers[remain-1];
        }
        return answer;
    }
}
