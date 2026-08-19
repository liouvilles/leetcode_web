class Solution {
    fun findNumbers(nums:IntArray):Int{
        var answer=0;
        for(value in nums){
            var number=value;
            var digits=0;
            while(number>0){
                digits++;
                number/=10
            };
            if(digits%2==0)answer++
        };
        return answer
    }
}
