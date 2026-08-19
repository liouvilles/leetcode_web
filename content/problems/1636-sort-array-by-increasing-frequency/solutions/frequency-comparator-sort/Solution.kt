class Solution {
    fun frequencySort(nums:IntArray):IntArray{
        val frequency=nums.toList().groupingBy{
            it
        }.eachCount();
        return nums.toList().sortedWith(compareBy<Int>{
            frequency[it]!!
        }.thenByDescending{
            it
        }).toIntArray()
    }
}
