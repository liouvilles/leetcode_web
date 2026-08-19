class Solution {
    public int smallestDivisor(int[] nums,int threshold){
        int left=1,right=0;
        for(int value:nums)right=Math.max(right,value);
        while(left<right){
            int middle=(left+right)/2,sum=0;
            for(int value:nums)sum+=(value+middle-1)/middle;
            if(sum<=threshold)right=middle;
            else left=middle+1;
        }
        return left;
    }
}
