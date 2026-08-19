class Solution {
    fun kidsWithCandies(candies:IntArray,extraCandies:Int):List<Boolean>{
        val maximum=candies.maxOrNull()!!;
        return candies.map{
            it+extraCandies>=maximum
        }
    }
}
