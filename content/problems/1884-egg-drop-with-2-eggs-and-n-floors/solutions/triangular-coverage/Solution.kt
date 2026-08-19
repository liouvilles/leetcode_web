class Solution {
    fun twoEggDrop(n:Int):Int{
        var moves=0;
        var covered=0;
        while(covered<n)covered+=++moves;
        return moves
    }
}
