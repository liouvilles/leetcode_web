class Solution {
    fun findIndices(nums:IntArray,indexDifference:Int,valueDifference:Int):IntArray{
        var minValue=Int.MAX_VALUE;
        var maxValue=Int.MIN_VALUE;
        var minIndex=-1;
        var maxIndex=-1;
        for(j in indexDifference until nums.size){
            val candidate=j-indexDifference;
            if(nums[candidate]<minValue){
                minValue=nums[candidate];
                minIndex=candidate
            };
            if(nums[candidate]>maxValue){
                maxValue=nums[candidate];
                maxIndex=candidate
            };
            if(nums[j]-minValue>=valueDifference)return intArrayOf(minIndex,j);
            if(maxValue-nums[j]>=valueDifference)return intArrayOf(maxIndex,j)
        };
        return intArrayOf(-1,-1)
    }
}
