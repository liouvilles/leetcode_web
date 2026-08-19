class Solution {
    fun maximumWealth(accounts:Array<IntArray>):Int=accounts.maxOf{
        it.sum()
    }
}
