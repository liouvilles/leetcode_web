class Solution {
    fun findMaximumElegance(items:Array<IntArray>,k:Int):Long{
        items.sortWith(Comparator{
            a,b->b[0].compareTo(a[0])
        });
        val categories=HashSet<Int>();
        val duplicates=java.util.PriorityQueue<Int>();
        var sum=0L;
        for(i in 0 until k){
            sum+=items[i][0];
            if(!categories.add(items[i][1]))duplicates.add(items[i][0])
        };
        var answer=sum+categories.size.toLong()*categories.size;
        var i=k;
        while(i<items.size&&duplicates.isNotEmpty()){
            if(items[i][1] !in categories){
                sum+=items[i][0]-duplicates.poll();
                categories.add(items[i][1]);
                answer=maxOf(answer,sum+categories.size.toLong()*categories.size)
            };
            i++
        };
        return answer
    }
}
