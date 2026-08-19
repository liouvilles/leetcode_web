class Solution {
    fun maxConsecutive(bottom:Int,top:Int,special:IntArray):Int{
        special.sort();
        var answer=special[0]-bottom;
        for(i in 1 until special.size)answer=maxOf(answer,special[i]-special[i-1]-1);
        return maxOf(answer,top-special.last())
    }
}
