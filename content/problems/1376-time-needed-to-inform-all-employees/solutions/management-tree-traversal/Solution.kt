class Solution {
    fun numOfMinutes(n:Int,headID:Int,manager:IntArray,informTime:IntArray):Int{
        val children=Array(n){
            mutableListOf<Int>()
        };
        for(employee in 0 until n)if(manager[employee]!=-1)children[manager[employee]].add(employee);
        val stack=java.util.ArrayDeque<IntArray>();
        stack.push(intArrayOf(headID,0));
        var answer=0;
        while(stack.isNotEmpty()){
            val state=stack.pop();
            val node=state[0];
            val time=state[1];
            answer=maxOf(answer,time);
            for(child in children[node])stack.push(intArrayOf(child,time+informTime[node]))
        };
        return answer
    }
}
