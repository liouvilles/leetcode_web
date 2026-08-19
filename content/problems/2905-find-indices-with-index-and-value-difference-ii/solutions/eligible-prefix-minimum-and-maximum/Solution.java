class Solution {
    public int[] findIndices(int[] nums,int indexDifference,int valueDifference){
        int minValue=Integer.MAX_VALUE,maxValue=Integer.MIN_VALUE,minIndex=-1,maxIndex=-1;
        for(int j=indexDifference;j<nums.length;j++){
            int candidate=j-indexDifference;
            if(nums[candidate]<minValue){
                minValue=nums[candidate];
                minIndex=candidate;
            }
            if(nums[candidate]>maxValue){
                maxValue=nums[candidate];
                maxIndex=candidate;
            }
            if(nums[j]-minValue>=valueDifference)return new int[]{
                minIndex,j
            };
            if(maxValue-nums[j]>=valueDifference)return new int[]{
                maxIndex,j
            };
        }
        return new int[]{
            -1,-1
        };
    }
}
