class Solution {
    private lateinit var text:String;
    private lateinit var memo:Array<IntArray>;
    private fun encoded(count:Int)=if(count==1)1 else if(count<10)2 else if(count<100)3 else 4;
    private fun dfs(index:Int,k:Int):Int{
        if(text.length-index<=k)return 0;
        if(k<0)return 1_000_000;
        if(memo[index][k]!=-1)return memo[index][k];
        var answer=dfs(index+1,k-1);
        var same=0;
        var removed=0;
        for(end in index until text.length){
            if(text[end]==text[index])same++ else removed++;
            if(removed>k)break;
            answer=minOf(answer,encoded(same)+dfs(end+1,k-removed))
        };
        memo[index][k]=answer;
        return answer
    };
    fun getLengthOfOptimalCompression(s:String,k:Int):Int{
        text=s;
        memo=Array(s.length){
            IntArray(k+1){
                -1
            }
        };
        return dfs(0,k)
    }
}
