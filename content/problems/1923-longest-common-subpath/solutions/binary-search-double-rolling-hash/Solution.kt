class Solution {
    companion object{
        const val M1=1_000_000_007L;
        const val M2=1_000_000_009L;
        const val BASE=911382L
    };
    private lateinit var power1:LongArray;
    private lateinit var power2:LongArray;
    private fun hashes(path:IntArray,length:Int):MutableSet<Long>{
        val first=LongArray(path.size+1);
        val second=LongArray(path.size+1);
        for(i in path.indices){
            first[i+1]=(first[i]*BASE+path[i]+1)%M1;
            second[i+1]=(second[i]*BASE+path[i]+1)%M2
        };
        val result=HashSet<Long>();
        for(left in 0..path.size-length){
            val a=(first[left+length]-first[left]*power1[length]%M1+M1)%M1;
            val b=(second[left+length]-second[left]*power2[length]%M2+M2)%M2;
            result.add((a shl 32) xor b)
        };
        return result
    };
    private fun check(paths:Array<IntArray>,length:Int):Boolean{
        var common:MutableSet<Long>?=null;
        for(path in paths){
            val current=hashes(path,length);
            if(common==null)common=current else common.retainAll(current);
            if(common.isEmpty())return false
        };
        return true
    };
    fun longestCommonSubpath(n:Int,paths:Array<IntArray>):Int{
        val maximum=paths.maxOf{
            it.size
        };
        power1=LongArray(maximum+1);
        power2=LongArray(maximum+1);
        power1[0]=1;
        power2[0]=1;
        for(i in 1..maximum){
            power1[i]=power1[i-1]*BASE%M1;
            power2[i]=power2[i-1]*BASE%M2
        };
        var left=0;
        var right=paths.minOf{
            it.size
        };
        while(left<right){
            val middle=left+(right-left+1)/2;
            if(check(paths,middle))left=middle else right=middle-1
        };
        return left
    }
}
