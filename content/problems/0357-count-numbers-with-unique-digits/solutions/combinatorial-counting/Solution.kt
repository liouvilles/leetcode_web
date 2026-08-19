class Solution {
    fun countNumbersWithUniqueDigits(n:Int):Int{
        if(n==0)return 1;
        var total=10;
        var unique=9;
        var available=9;
        for(digits in 2..n){
            unique*=available--;
            total+=unique
        };
        return total
    }
}
