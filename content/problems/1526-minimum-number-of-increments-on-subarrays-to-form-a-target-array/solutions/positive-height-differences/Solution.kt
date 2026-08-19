class Solution {
    fun minNumberOperations(target:IntArray):Int{
        var answer=target[0];
        for(i in 1 until target.size)answer+=maxOf(0,target[i]-target[i-1]);
        return answer
    }
}
