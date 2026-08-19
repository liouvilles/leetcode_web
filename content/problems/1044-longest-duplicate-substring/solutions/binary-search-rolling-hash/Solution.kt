class Solution {
    private val base=911382323L;
    private lateinit var text:String;
    fun longestDupSubstring(s:String):String{
        text=s;
        var low=1;
        var high=s.length-1;
        var bestStart=-1;
        var bestLength=0;
        while(low<=high){
            val length=(low+high)/2;
            val start=search(length);
            if(start>=0){
                bestStart=start;
                bestLength=length;
                low=length+1
            }else high=length-1
        };
        return if(bestStart<0)"" else s.substring(bestStart,bestStart+bestLength)
    };
    private fun search(length:Int):Int{
        var power=1L;
        var hash=0L;
        for(i in 0 until length){
            power*=base;
            hash=hash*base+text[i].code
        };
        val seen=mutableMapOf<Long,MutableList<Int>>();
        seen.getOrPut(hash){
            mutableListOf()
        }.add(0);
        for(start in 1..text.length-length){
            hash=hash*base+text[start+length-1].code-power*text[start-1].code;
            for(previous in seen[hash]?:emptyList())if(text.regionMatches(previous,text,start,length))return start;
            seen.getOrPut(hash){
                mutableListOf()
            }.add(start)
        };
        return -1
    }
}
