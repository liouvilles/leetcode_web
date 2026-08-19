class Solution {
    fun isReachableAtTime(sx:Int,sy:Int,fx:Int,fy:Int,t:Int):Boolean{
        val distance=maxOf(kotlin.math.abs(sx-fx),kotlin.math.abs(sy-fy));
        return distance<=t&&!(distance==0&&t==1)
    }
}
