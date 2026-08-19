class Solution {
    private lateinit var children:Array<MutableList<Int>>;
    private lateinit var nums:IntArray;
    private lateinit var visited:BooleanArray;
    private lateinit var seen:BooleanArray;
    private fun add(node:Int){
        if(visited[node])return;
        visited[node]=true;
        if(nums[node]<seen.size)seen[nums[node]]=true;
        for(child in children[node])add(child)
    };
    fun smallestMissingValueSubtree(parents:IntArray,nums:IntArray):IntArray{
        this.nums=nums;
        val n=parents.size;
        children=Array(n){
            mutableListOf()
        };
        var one=-1;
        for(i in parents.indices){
            if(i>0)children[parents[i]].add(i);
            if(nums[i]==1)one=i
        };
        val answer=IntArray(n){
            1
        };
        if(one<0)return answer;
        visited=BooleanArray(n);
        seen=BooleanArray((nums.maxOrNull()?:1)+n+2);
        var missing=1;
        var node=one;
        while(node!=-1){
            add(node);
            while(seen[missing])missing++;
            answer[node]=missing;
            node=parents[node]
        };
        return answer
    }
}
