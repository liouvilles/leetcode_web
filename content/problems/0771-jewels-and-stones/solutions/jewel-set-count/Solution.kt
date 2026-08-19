class Solution {
    fun numJewelsInStones(jewels:String,stones:String):Int{
        val set=jewels.toSet();
        return stones.count{
            it in set
        }
    }
}
