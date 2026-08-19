class Solution {
    private val mod=1_000_000_007;
    private lateinit var low:String;
    private lateinit var high:String;
    private lateinit var evil:String;
    private lateinit var transition:Array<IntArray>;
    private lateinit var memo:Array<Array<Array<IntArray>>>;
    private var n=0;
    private var m=0;
    private fun dfs(position:Int,matched:Int,tightLow:Int,tightHigh:Int):Int{
        if(matched==m)return 0;
        if(position==n)return 1;
        if(memo[position][matched][tightLow][tightHigh]!=-1)return memo[position][matched][tightLow][tightHigh];
        val from=if(tightLow==1)low[position] else 'a';
        val to=if(tightHigh==1)high[position] else 'z';
        var answer=0L;
        for(value in from..to)answer=(answer+dfs(position+1,transition[matched][value-'a'],if(tightLow==1&&value==from)1 else 0,if(tightHigh==1&&value==to)1 else 0))%mod;
        memo[position][matched][tightLow][tightHigh]=answer.toInt();
        return answer.toInt()
    };
    fun findGoodStrings(n:Int,s1:String,s2:String,evil:String):Int{
        this.n=n;
        this.low=s1;
        this.high=s2;
        this.evil=evil;
        this.m=evil.length;
        val prefix=IntArray(m);
        for(i in 1 until m){
            var length=prefix[i-1];
            while(length>0&&evil[i]!=evil[length])length=prefix[length-1];
            if(evil[i]==evil[length])length++;
            prefix[i]=length
        };
        transition=Array(m){
            IntArray(26)
        };
        for(state in 0 until m)for(letter in 0..25){
            var length=state;
            val value=('a'.code+letter).toChar();
            while(length>0&&evil[length]!=value)length=prefix[length-1];
            if(evil[length]==value)length++;
            transition[state][letter]=length
        };
        memo=Array(n){
            Array(m){
                Array(2){
                    IntArray(2){
                        -1
                    }
                }
            }
        };
        return dfs(0,0,1,1)
    }
}
