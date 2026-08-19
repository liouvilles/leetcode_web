class Solution {
    fun closestPrimes(left:Int,right:Int):IntArray{
        val prime=BooleanArray(right+1){
            true
        };
        prime[0]=false;
        if(right>=1)prime[1]=false;
        var value=2;
        while(value*value<=right){
            if(prime[value]){
                var multiple=value*value;
                while(multiple<=right){
                    prime[multiple]=false;
                    multiple+=value
                }
            };
            value++
        };
        var previous=-1;
        var best=Int.MAX_VALUE;
        val answer=intArrayOf(-1,-1);
        for(number in maxOf(2,left)..right)if(prime[number]){
            if(previous>=0&&number-previous<best){
                best=number-previous;
                answer[0]=previous;
                answer[1]=number
            };
            previous=number
        };
        return answer
    }
}
