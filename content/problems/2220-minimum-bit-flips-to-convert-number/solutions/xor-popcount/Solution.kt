class Solution {
    fun minBitFlips(start:Int,goal:Int)=Integer.bitCount(start xor goal)
}
