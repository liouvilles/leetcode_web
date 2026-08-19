class Solution {
    fun maximumHappinessSum(happiness:IntArray,k:Int):Long{
        happiness.sort()
        var answer=0L
        for(selected in 0 until k)answer+=maxOf(0L,happiness[happiness.lastIndex-selected].toLong()-selected)
        return answer
    }
}
