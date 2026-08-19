class Solution {
    fun sumFourDivisors(nums:IntArray):Int{
        var answer=0;
        for(value in nums){
            var count=0;
            var sum=0;
            var divisor=1;
            while(divisor*divisor<=value&&count<=4){
                if(value%divisor==0){
                    val other=value/divisor;
                    count++;
                    sum+=divisor;
                    if(other!=divisor){
                        count++;
                        sum+=other
                    }
                };
                divisor++
            };
            if(count==4)answer+=sum
        };
        return answer
    }
}
