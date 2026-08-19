class Solution {
    fun maxSpending(values:Array<IntArray>):Long{
        val heap=java.util.PriorityQueue<IntArray>(compareBy{
            it[0]
        });
        for(row in values.indices){
            val column=values[row].lastIndex;
            heap.add(intArrayOf(values[row][column],row,column))
        };
        var answer=0L;
        var day=1L;
        while(heap.isNotEmpty()){
            val item=heap.remove();
            answer+=day++*item[0];
            if(item[2]>0){
                val column=item[2]-1;
                heap.add(intArrayOf(values[item[1]][column],item[1],column))
            }
        };
        return answer
    }
}
