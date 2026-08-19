class Solution {
    fun longestString(x:Int,y:Int,z:Int):Int{
        return (2*minOf(x,y)+(if(x==y)0 else 1)+z)*2
    }
}
