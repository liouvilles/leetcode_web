class Solution {
    private fun gcd(a:Int,b:Int):Int=if(b==0)a else gcd(b,a%b);
    fun simplifiedFractions(n:Int):List<String>{
        val answer=mutableListOf<String>();
        for(denominator in 2..n)for(numerator in 1 until denominator)if(gcd(numerator,denominator)==1)answer.add("$numerator/$denominator");
        return answer
    }
}
