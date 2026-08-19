class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums,int k){
        int count=nums.length-k+1;
        int[] sums=new int[count];
        int window=0;
        for(int i=0;i<nums.length;i++){
            window+=nums[i];
            if(i>=k)window-=nums[i-k];
            if(i>=k-1)sums[i-k+1]=window;
        }
        int[] left=new int[count],right=new int[count];
        int best=0;
        for(int i=0;i<count;i++){
            if(sums[i]>sums[best])best=i;
            left[i]=best;
        }
        best=count-1;
        for(int i=count-1;i>=0;i--){
            if(sums[i]>=sums[best])best=i;
            right[i]=best;
        }
        int[] answer=new int[3];
        int maximum=-1;
        for(int middle=k;middle<=count-k-1;middle++){
            int first=left[middle-k],third=right[middle+k];
            int total=sums[first]+sums[middle]+sums[third];
            if(total>maximum){
                maximum=total;
                answer=new int[]{
                    first,middle,third
                };
            }
        }
        return answer;
    }
}
