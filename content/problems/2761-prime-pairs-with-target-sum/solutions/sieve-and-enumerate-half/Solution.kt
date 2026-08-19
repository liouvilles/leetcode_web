class Solution {
    fun findPrimePairs(n:Int):List<List<Int>>{
        val prime=BooleanArray(n+1);
        for(value in 2..n)prime[value]=true;
        var value=2;
        while(value*value<=n){
            if(prime[value]){
                var multiple=value*value;
                while(multiple<=n){
                    prime[multiple]=false;
                    multiple+=value
                }
            };
            value++
        };
        val answer=mutableListOf<List<Int>>();
        for(first in 2..n/2)if(prime[first]&&prime[n-first])answer.add(listOf(first,n-first));
        return answer
    }
}
