class Solution {
    fun missingRolls(rolls:IntArray,mean:Int,n:Int):IntArray{
        val missing=mean*(rolls.size+n)-rolls.sum();
        if(missing<n||missing>6*n)return intArrayOf();
        return IntArray(n){
            missing/n+if(it<missing%n)1 else 0
        }
    }
}
