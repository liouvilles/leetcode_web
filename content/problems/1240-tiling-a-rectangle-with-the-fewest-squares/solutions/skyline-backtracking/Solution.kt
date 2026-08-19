class Solution {
    private var rows=0;
    private var columns=0;
    private var best=0;
    private lateinit var heights:IntArray;
    fun tilingRectangle(n:Int,m:Int):Int{
        rows=maxOf(n,m);
        columns=minOf(n,m);
        heights=IntArray(columns);
        best=rows*columns;
        dfs(0);
        return best
    };
    private fun dfs(used:Int){
        if(used>=best)return;
        var minimum=rows;
        var start=-1;
        for(i in 0 until columns)if(heights[i]<minimum){
            minimum=heights[i];
            start=i
        };
        if(minimum==rows){
            best=used;
            return
        };
        var width=0;
        while(start+width<columns&&heights[start+width]==minimum)width++;
        val maximum=minOf(width,rows-minimum);
        for(size in maximum downTo 1){
            for(i in 0 until size)heights[start+i]+=size;
            dfs(used+1);
            for(i in 0 until size)heights[start+i]-=size
        }
    }
}
