class Solution {
    fun resultArray(nums:IntArray):IntArray{
        val first=IntArray(nums.size)
        val second=IntArray(nums.size)
        var firstSize=1
        var secondSize=1
        first[0]=nums[0];second[0]=nums[1]
        for(index in 2 until nums.size){
            if(first[firstSize-1]>second[secondSize-1])first[firstSize++]=nums[index]
            else second[secondSize++]=nums[index]
        }
        val answer=IntArray(nums.size)
        for(index in 0 until firstSize)answer[index]=first[index]
        for(index in 0 until secondSize)answer[firstSize+index]=second[index]
        return answer
    }
}
