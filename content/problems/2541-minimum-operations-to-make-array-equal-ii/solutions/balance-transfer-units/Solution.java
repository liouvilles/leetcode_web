class Solution {
    public long minOperations(int[] nums1,int[] nums2,int k){
        if(k==0)return Arrays.equals(nums1,nums2)?0:-1;
        long positive=0,negative=0;
        for(int i=0;i<nums1.length;i++){
            int difference=nums1[i]-nums2[i];
            if(difference%k!=0)return -1;
            if(difference>0)positive+=difference/k;
            else negative-=difference/k;
        }
        return positive==negative?positive:-1;
    }
}
