class Solution {
    private int count(int[] singles,int[] pairs){
        int answer=0;
        for(int value:singles){
            long square=(long)value*value;
            for(int left=0;left<pairs.length;left++)for(int right=left+1;right<pairs.length;right++)if((long)pairs[left]*pairs[right]==square)answer++;
        }
        return answer;
    }
    public int numTriplets(int[] nums1,int[] nums2){
        return count(nums1,nums2)+count(nums2,nums1);
    }
}
