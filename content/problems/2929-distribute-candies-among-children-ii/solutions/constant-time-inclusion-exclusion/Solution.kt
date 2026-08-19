class Solution {
    private fun ways(sum:Long):Long=if(sum<0)0 else (sum+1)*(sum+2)/2;
    fun distributeCandies(n:Int,limit:Int):Long{
        val step=limit+1L;
        return ways(n.toLong())-3*ways(n-step)+3*ways(n-2*step)-ways(n-3*step)
    }
}
