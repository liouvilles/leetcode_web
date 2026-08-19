class Solution {
    fun checkOverlap(radius:Int,xCenter:Int,yCenter:Int,x1:Int,y1:Int,x2:Int,y2:Int):Boolean{
        val closestX=xCenter.coerceIn(x1,x2);
        val closestY=yCenter.coerceIn(y1,y2);
        val dx=(xCenter-closestX).toLong();
        val dy=(yCenter-closestY).toLong();
        return dx*dx+dy*dy<=radius.toLong()*radius
    }
}
