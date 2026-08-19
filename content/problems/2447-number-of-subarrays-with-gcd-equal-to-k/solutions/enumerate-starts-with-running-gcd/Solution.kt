class Solution {
    fun subarrayGCD(nums:IntArray,k:Int):Int{
        fun gcd(aValue:Int,bValue:Int):Int{
            var a=aValue;
            var b=bValue;
            while(b!=0){
                val t=a%b;
                a=b;
                b=t
            };
            return a
        };
        var answer=0;
        for(left in nums.indices){
            var value=0;
            for(right in left until nums.size){
                value=gcd(value,nums[right]);
                if(value==k)answer++;
                if(value%k!=0)break
            }
        };
        return answer
    }
}
