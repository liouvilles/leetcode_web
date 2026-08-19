class Solution {
    fun mostVisited(n:Int,rounds:IntArray):List<Int>{
        val start=rounds.first();
        val end=rounds.last();
        return if(start<=end)(start..end).toList()else(1..end).toList()+(start..n).toList()
    }
}
