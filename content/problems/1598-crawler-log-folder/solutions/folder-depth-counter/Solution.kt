class Solution {
    fun minOperations(logs:Array<String>):Int{
        var depth=0;
        for(log in logs)if(log=="../")depth=maxOf(0,depth-1)else if(log!="./")depth++;
        return depth
    }
}
