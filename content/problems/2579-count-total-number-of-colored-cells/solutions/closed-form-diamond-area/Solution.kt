class Solution {
    fun coloredCells(n:Int):Long{
        val side=n.toLong();
        return side*side+(side-1)*(side-1)
    }
}
