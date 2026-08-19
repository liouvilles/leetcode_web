class Solution {
    private val memo=HashMap<String,IntArray>();
    private fun enumerate(n:Int,first:Int,second:Int,pair:Int,beforeFirst:Int,beforeSecond:Int,states:MutableSet<Int>){
        if(pair>n/2){
            var a=beforeFirst;
            var b=beforeSecond;
            if(n%2==1){
                val middle=(n+1)/2;
                if(middle<first)a++;
                if(middle<second)b++
            };
            states.add(a*32+b);
            return
        };
        val left=pair;
        val right=n+1-pair;
        fun advance(winner:Int)=enumerate(n,first,second,pair+1,beforeFirst+if(winner<first)1 else 0,beforeSecond+if(winner<second)1 else 0,states);
        when{
            left==first||right==first->advance(first);
            left==second||right==second->advance(second);
            else->{
                advance(left);
                advance(right)
            }
        }
    };
    private fun solve(n:Int,firstValue:Int,secondValue:Int):IntArray{
        if(firstValue+secondValue==n+1)return intArrayOf(1,1);
        var first=firstValue;
        var second=secondValue;
        if(first+second>n+1){
            val old=first;
            first=n+1-second;
            second=n+1-old
        };
        val key="$n,$first,$second";
        memo[key]?.let{
            return it
        };
        val states=HashSet<Int>();
        enumerate(n,first,second,1,0,0,states);
        var earliest=100;
        var latest=0;
        val nextN=(n+1)/2;
        for(state in states){
            val result=solve(nextN,state/32+1,state%32+1);
            earliest=minOf(earliest,result[0]+1);
            latest=maxOf(latest,result[1]+1)
        };
        return intArrayOf(earliest,latest).also{
            memo[key]=it
        }
    };
    fun earliestAndLatest(n:Int,firstPlayer:Int,secondPlayer:Int):IntArray=solve(n,firstPlayer,secondPlayer)
}
