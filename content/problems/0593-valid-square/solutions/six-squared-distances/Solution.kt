class Solution {
    fun validSquare(p1:IntArray,p2:IntArray,p3:IntArray,p4:IntArray):Boolean{
        val points=arrayOf(p1,p2,p3,p4);
        val distances=LongArray(6);
        var index=0;
        for(i in 0..3)for(j in i+1..3)distances[index++]=distance(points[i],points[j]);
        distances.sort();
        return distances[0]>0&&distances[0]==distances[3]&&distances[4]==distances[5]&&distances[4]==2*distances[0]
    };
    private fun distance(a:IntArray,b:IntArray):Long{
        val x=a[0].toLong()-b[0];
        val y=a[1].toLong()-b[1];
        return x*x+y*y
    }
}
