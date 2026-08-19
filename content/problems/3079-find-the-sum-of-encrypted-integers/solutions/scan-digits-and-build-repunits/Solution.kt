class Solution {
    fun sumOfEncryptedInt(nums:IntArray):Int{
        var answer=0;
        for(number in nums){
            var value=number;
            var maximum=0;
            var place=0;
            while(value>0){
                maximum=maxOf(maximum,value%10);
                place=place*10+1;
                value/=10
            };
            answer+=maximum*place
        };
        return answer
    }
}
