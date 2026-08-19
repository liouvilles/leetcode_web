class Solution {
    private fun distances(boundary:Int,fences:IntArray):HashSet<Int>{
        val positions=fences.copyOf(fences.size+2);
        positions[fences.size]=1;
        positions[fences.size+1]=boundary;
        val result=HashSet<Int>();
        for(first in positions.indices)for(second in first+1 until positions.size)result.add(kotlin.math.abs(positions[first]-positions[second]));
        return result
    }
    fun maximizeSquareArea(m:Int,n:Int,hFences:IntArray,vFences:IntArray):Int{
        val horizontal=distances(m,hFences);
        val vertical=distances(n,vFences);
        var side=-1L;
        for(distance in horizontal)if(distance in vertical)side=maxOf(side,distance.toLong());
        if(side<0)return -1;
        return (side*side%1_000_000_007L).toInt()
    }
}
