class Solution {
    fun fillCups(amount:IntArray):Int{
        return maxOf(amount.maxOrNull()!!,(amount.sum()+1)/2)
    }
}
