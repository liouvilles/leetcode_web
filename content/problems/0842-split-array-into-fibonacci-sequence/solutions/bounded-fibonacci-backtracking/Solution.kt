class Solution {
    fun splitIntoFibonacci(num:String):List<Int>{
        val sequence=mutableListOf<Int>();
        dfs(num,0,sequence);
        return sequence
    };
    private fun dfs(num:String,index:Int,sequence:MutableList<Int>):Boolean{
        if(index==num.length)return sequence.size>=3;
        var value=0L;
        for(end in index until num.length){
            if(end>index&&num[index]=='0')break;
            value=value*10+(num[end]-'0');
            if(value>Int.MAX_VALUE)break;
            if(sequence.size>=2){
                val sum=sequence[sequence.size-1].toLong()+sequence[sequence.size-2];
                if(value<sum)continue;
                if(value>sum)break
            };
            sequence.add(value.toInt());
            if(dfs(num,end+1,sequence))return true;
            sequence.removeAt(sequence.lastIndex)
        };
        return false
    }
}
