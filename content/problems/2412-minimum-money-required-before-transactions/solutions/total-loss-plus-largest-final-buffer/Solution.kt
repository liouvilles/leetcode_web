class Solution {
    fun minimumMoney(transactions:Array<IntArray>):Long{
        var loss=0L;
        var buffer=0L;
        for(transaction in transactions){
            loss+=maxOf(0,transaction[0]-transaction[1]);
            buffer=maxOf(buffer,minOf(transaction[0],transaction[1]).toLong())
        };
        return loss+buffer
    }
}
