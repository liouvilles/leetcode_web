class Solution {
    fun circularPermutation(n:Int,start:Int):List<Int> = (0 until (1 shl n)).map{
        start xor (it xor (it shr 1))
    }
}
