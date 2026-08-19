class Solution {
    private fun gain(c:DoubleArray):Double=(c[0]+1)/(c[1]+1)-c[0]/c[1];
    fun maxAverageRatio(classes:Array<IntArray>,extraStudentsValue:Int):Double{
        val queue=java.util.PriorityQueue<DoubleArray>{
            a,b->gain(b).compareTo(gain(a))
        };
        for(c in classes)queue.add(doubleArrayOf(c[0].toDouble(),c[1].toDouble()));
        repeat(extraStudentsValue){
            val c=queue.remove();
            c[0]++;
            c[1]++;
            queue.add(c)
        };
        return queue.sumOf{
            it[0]/it[1]
        }/classes.size
    }
}
