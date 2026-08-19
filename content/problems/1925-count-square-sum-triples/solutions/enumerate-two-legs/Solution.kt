class Solution {
    fun countTriples(n:Int):Int{
        var answer=0;
        for(a in 1..n)for(b in 1..n){
            val square=a*a+b*b;
            val c=kotlin.math.sqrt(square.toDouble()).toInt();
            if(c<=n&&c*c==square)answer++
        };
        return answer
    }
}
