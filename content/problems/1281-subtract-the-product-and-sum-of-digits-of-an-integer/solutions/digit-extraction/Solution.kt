class Solution {
    fun subtractProductAndSum(nValue:Int):Int{
        var n=nValue;
        var product=1;
        var sum=0;
        while(n>0){
            val digit=n%10;
            product*=digit;
            sum+=digit;
            n/=10
        };
        return product-sum
    }
}
