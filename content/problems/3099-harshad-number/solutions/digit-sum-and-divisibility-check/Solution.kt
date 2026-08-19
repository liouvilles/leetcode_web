class Solution {
    fun sumOfTheDigitsOfHarshadNumber(x:Int):Int{
        var value=x;
        var digitSum=0;
        while(value>0){
            digitSum+=value%10;
            value/=10
        };
        return if(x%digitSum==0)digitSum else -1
    }
}
