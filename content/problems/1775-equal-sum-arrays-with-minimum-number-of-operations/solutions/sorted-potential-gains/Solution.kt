class Solution {
    fun minOperations(firstInput:IntArray,secondInput:IntArray):Int{
        if(firstInput.size*6<secondInput.size||secondInput.size*6<firstInput.size)return -1;
        var first=firstInput;
        var second=secondInput;
        var sum1=first.sum();
        var sum2=second.sum();
        if(sum1>sum2){
            val array=first;
            first=second;
            second=array;
            val sum=sum1;
            sum1=sum2;
            sum2=sum
        };
        val gains=first.map{
            6-it
        }+second.map{
            it-1
        };
        var difference=sum2-sum1;
        var operations=0;
        for(gain in gains.sortedDescending()){
            if(difference<=0)break;
            difference-=gain;
            operations++
        };
        return operations
    }
}
