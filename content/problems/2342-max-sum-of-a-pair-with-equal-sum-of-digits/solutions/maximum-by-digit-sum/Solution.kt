class Solution {
    fun maximumSum(nums:IntArray):Int{
        val maximum=HashMap<Int,Int>();
        var answer=-1;
        for(value in nums){
            var x=value;
            var sum=0;
            while(x>0){
                sum+=x%10;
                x/=10
            };
            maximum[sum]?.let{
                answer=maxOf(answer,value+it)
            };
            maximum[sum]=maxOf(maximum[sum]?:0,value)
        };
        return answer
    }
}
