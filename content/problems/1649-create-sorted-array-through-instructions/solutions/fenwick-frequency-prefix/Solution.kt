class Solution {
    private class Fenwick(n:Int){
        val tree=IntArray(n+1);
        fun add(indexValue:Int){
            var index=indexValue;
            while(index<tree.size){
                tree[index]++;
                index+=index and -index
            }
        };
        fun query(indexValue:Int):Int{
            var index=indexValue;
            var sum=0;
            while(index>0){
                sum+=tree[index];
                index-=index and -index
            };
            return sum
        }
    };
    fun createSortedArray(instructions:IntArray):Int{
        val mod=1_000_000_007L;
        val fenwick=Fenwick(instructions.maxOrNull()!!);
        var cost=0L;
        for(i in instructions.indices){
            val value=instructions[i];
            val less=fenwick.query(value-1);
            val greater=i-fenwick.query(value);
            cost=(cost+minOf(less,greater))%mod;
            fenwick.add(value)
        };
        return cost.toInt()
    }
}
