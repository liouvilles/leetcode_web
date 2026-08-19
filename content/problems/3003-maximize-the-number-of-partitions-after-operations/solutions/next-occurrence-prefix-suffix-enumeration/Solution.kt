class Solution {
    private var n=0;
    private var limitDistinct=0;
    private lateinit var next:Array<IntArray>;
    private val work=IntArray(26);
    private fun cut(start:Int,changedIndex:Int,oldLetter:Int,replacement:Int):Int{
        next[start].copyInto(work);
        if(changedIndex>=0&&replacement!=oldLetter){
            if(work[oldLetter]==changedIndex)work[oldLetter]=next[changedIndex+1][oldLetter];
            if(changedIndex>=start&&changedIndex<work[replacement])work[replacement]=changedIndex
        };
        work.sort();
        return if(limitDistinct<26)work[limitDistinct] else n
    };
    fun maxPartitionsAfterOperations(s:String,k:Int):Int{
        n=s.length;
        limitDistinct=k;
        next=Array(n+1){
            IntArray(26){
                n
            }
        };
        for(i in n-1 downTo 0){
            next[i+1].copyInto(next[i]);
            next[i][s[i]-'a']=i
        };
        val suffix=IntArray(n+1);
        for(i in n-1 downTo 0){
            val boundary=cut(i,-1,0,0);
            suffix[i]=1+if(boundary<n)suffix[boundary] else 0
        };
        val segmentStart=IntArray(n);
        val prefixPartitions=IntArray(n);
        var mask=0;
        var start=0;
        var parts=0;
        for(i in s.indices){
            val bit=1 shl (s[i]-'a');
            if(Integer.bitCount(mask or bit)>k){
                parts++;
                start=i;
                mask=bit
            }else mask=mask or bit;
            segmentStart[i]=start;
            prefixPartitions[i]=parts
        };
        var answer=suffix[0];
        for(i in s.indices){
            val oldLetter=s[i]-'a';
            for(replacement in 0 until 26){
                val firstBoundary=cut(segmentStart[i],i,oldLetter,replacement);
                val candidate=if(firstBoundary<=i){
                    val secondBoundary=cut(i,i,oldLetter,replacement);
                    prefixPartitions[i]+2+if(secondBoundary<n)suffix[secondBoundary] else 0
                }else prefixPartitions[i]+1+if(firstBoundary<n)suffix[firstBoundary] else 0;
                answer=maxOf(answer,candidate)
            }
        };
        return answer
    }
}
