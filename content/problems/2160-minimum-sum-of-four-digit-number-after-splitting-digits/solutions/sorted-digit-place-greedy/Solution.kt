class Solution {
    fun minimumSum(numValue:Int):Int{
        var num=numValue;
        val digits=IntArray(4);
        for(i in 0..3){
            digits[i]=num%10;
            num/=10
        };
        digits.sort();
        return 10*(digits[0]+digits[1])+digits[2]+digits[3]
    }
}
