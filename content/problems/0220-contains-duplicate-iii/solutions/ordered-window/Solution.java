class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums,int indexDiff,int valueDiff){
        TreeSet<Long> window=new TreeSet<>();
        for(int i=0;i<nums.length;i++){
            if(i>indexDiff)window.remove((long)nums[i-indexDiff-1]);
            long value=nums[i];
            Long candidate=window.ceiling(value-valueDiff);
            if(candidate!=null&&candidate<=value+valueDiff)return true;
            window.add(value);
        }
        return false;
    }
}
