class Solution {
    fun reorganizeString(s:String):String{
        val counts=IntArray(26);
        for(c in s)counts[c-'a']++;
        val heap=java.util.PriorityQueue<IntArray>{
            a,b->if(a[1]!=b[1])b[1]-a[1] else a[0]-b[0]
        };
        for(c in 0 until 26)if(counts[c]>0)heap.add(intArrayOf(c,counts[c]));
        val answer=StringBuilder();
        var previous:IntArray?=null;
        while(heap.isNotEmpty()){
            val current=heap.remove();
            answer.append(('a'.code+current[0]).toChar());
            if(previous!=null&&previous[1]>0)heap.add(previous);
            current[1]--;
            previous=current
        };
        return if(previous!=null&&previous[1]>0)"" else answer.toString()
    }
}
