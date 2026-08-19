class Solution {
    fun minimumOperations(nums:List<Int>):Int{
        var one=0;
        var two=0;
        var three=0;
        for(value in nums){
            val nextOne=one+if(value==1)0 else 1;
            val nextTwo=minOf(one,two)+if(value==2)0 else 1;
            val nextThree=minOf(one,two,three)+if(value==3)0 else 1;
            one=nextOne;
            two=nextTwo;
            three=nextThree
        };
        return minOf(one,two,three)
    }
}
