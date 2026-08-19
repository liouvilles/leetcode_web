class Solution {
    fun minElements(nums:IntArray,limit:Int,goal:Int):Int{
        val difference=kotlin.math.abs(goal.toLong()-nums.sumOf{
            it.toLong()
        });
        return ((difference+limit-1)/limit).toInt()
    }
}
