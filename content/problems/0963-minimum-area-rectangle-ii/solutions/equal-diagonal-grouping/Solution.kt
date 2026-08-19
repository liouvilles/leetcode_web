class Solution {
    fun minAreaFreeRect(points:Array<IntArray>):Double{
        val groups=mutableMapOf<String,MutableList<IntArray>>();
        for(i in points.indices)for(j in i+1 until points.size){
            val dx=points[i][0].toLong()-points[j][0];
            val dy=points[i][1].toLong()-points[j][1];
            val key=(points[i][0]+points[j][0]).toString()+","+(points[i][1]+points[j][1])+","+(dx*dx+dy*dy);
            groups.getOrPut(key){
                mutableListOf()
            }.add(intArrayOf(i,j))
        };
        var answer=Double.MAX_VALUE;
        for(group in groups.values)for(a in group.indices)for(b in a+1 until group.size){
            val p=points[group[a][0]];
            val q=points[group[b][0]];
            val r=points[group[b][1]];
            val area=kotlin.math.abs((q[0]-p[0]).toLong()*(r[1]-p[1])-(q[1]-p[1]).toLong()*(r[0]-p[0]));
            if(area>0)answer=minOf(answer,area.toDouble())
        };
        return if(answer==Double.MAX_VALUE)0.0 else answer
    }
}
