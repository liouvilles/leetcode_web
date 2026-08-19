class Solution {
    fun kthFactor(n:Int,kValue:Int):Int{
        var k=kValue;
        for(value in 1..n)if(n%value==0){
            k--;
            if(k==0)return value
        };
        return -1
    }
}
