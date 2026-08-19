class Solution {
    private lateinit var parent:IntArray;
    private fun find(value:Int):Int{
        if(parent[value]!=value)parent[value]=find(parent[value]);
        return parent[value]
    };
    fun validPath(n:Int,edges:Array<IntArray>,source:Int,destination:Int):Boolean{
        parent=IntArray(n){
            it
        };
        for(edge in edges)parent[find(edge[0])]=find(edge[1]);
        return find(source)==find(destination)
    }
}
