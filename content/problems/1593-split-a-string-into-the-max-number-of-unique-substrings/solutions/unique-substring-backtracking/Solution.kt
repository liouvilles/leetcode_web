class Solution {
    private lateinit var text:String;
    private var answer=0;
    private fun dfs(index:Int,used:MutableSet<String>){
        if(index==text.length){
            answer=maxOf(answer,used.size);
            return
        };
        if(used.size+text.length-index<=answer)return;
        for(end in index+1..text.length){
            val part=text.substring(index,end);
            if(used.add(part)){
                dfs(end,used);
                used.remove(part)
            }
        }
    };
    fun maxUniqueSplit(s:String):Int{
        text=s;
        dfs(0,mutableSetOf());
        return answer
    }
}
