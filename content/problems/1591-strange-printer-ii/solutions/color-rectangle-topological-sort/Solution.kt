class Solution {
    fun isPrintable(grid:Array<IntArray>):Boolean{
        val colors=61;
        val rows=grid.size;
        val cols=grid[0].size;
        val minRow=IntArray(colors){
            rows
        };
        val maxRow=IntArray(colors);
        val minCol=IntArray(colors){
            cols
        };
        val maxCol=IntArray(colors);
        val present=BooleanArray(colors);
        for(row in 0 until rows)for(col in 0 until cols){
            val color=grid[row][col];
            present[color]=true;
            minRow[color]=minOf(minRow[color],row);
            maxRow[color]=maxOf(maxRow[color],row);
            minCol[color]=minOf(minCol[color],col);
            maxCol[color]=maxOf(maxCol[color],col)
        };
        val edge=Array(colors){
            BooleanArray(colors)
        };
        val indegree=IntArray(colors);
        var total=0;
        for(color in 1 until colors)if(present[color]){
            total++;
            for(row in minRow[color]..maxRow[color])for(col in minCol[color]..maxCol[color]){
                val other=grid[row][col];
                if(other!=color&&!edge[color][other]){
                    edge[color][other]=true;
                    indegree[other]++
                }
            }
        };
        val queue=java.util.ArrayDeque<Int>();
        for(color in 1 until colors)if(present[color]&&indegree[color]==0)queue.add(color);
        var processed=0;
        while(queue.isNotEmpty()){
            val color=queue.removeFirst();
            processed++;
            for(other in 1 until colors)if(edge[color][other]){
                indegree[other]--;
                if(indegree[other]==0)queue.addLast(other)
            }
        };
        return processed==total
    }
}
