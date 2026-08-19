class Solution {
    fun findLucky(arr:IntArray):Int{
        val count=arr.toList().groupingBy{
            it
        }.eachCount();
        return count.filter{
            it.key==it.value
        }.keys.maxOrNull()?:-1
    }
}
