class RangeModule {
    private val intervals=java.util.TreeMap<Int,Int>();
    fun addRange(leftValue:Int,rightValue:Int){
        var left=leftValue;
        var right=rightValue;
        var entry=intervals.floorEntry(left);
        if(entry==null||entry.value<left)entry=intervals.ceilingEntry(left);
        val keys=mutableListOf<Int>();
        while(entry!=null&&entry.key<=right){
            if(entry.value>=left)keys.add(entry.key);
            entry=intervals.higherEntry(entry.key)
        };
        for(key in keys){
            left=minOf(left,key);
            right=maxOf(right,intervals.remove(key)!!)
        };
        intervals[left]=right
    };
    fun queryRange(left:Int,right:Int):Boolean{
        val entry=intervals.floorEntry(left);
        return entry!=null&&entry.value>=right
    };
    fun removeRange(left:Int,right:Int){
        var entry=intervals.floorEntry(left);
        if(entry==null||entry.value<=left)entry=intervals.ceilingEntry(left);
        val overlaps=mutableListOf<Pair<Int,Int>>();
        while(entry!=null&&entry.key<right){
            if(entry.value>left)overlaps.add(entry.key to entry.value);
            entry=intervals.higherEntry(entry.key)
        };
        for((start,end) in overlaps){
            intervals.remove(start);
            if(start<left)intervals[start]=left;
            if(end>right)intervals[right]=end
        }
    }
}
