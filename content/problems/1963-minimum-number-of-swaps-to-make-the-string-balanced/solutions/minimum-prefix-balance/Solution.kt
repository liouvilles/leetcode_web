class Solution {
    fun minSwaps(s:String):Int{
        var balance=0;
        var minimum=0;
        for(value in s){
            balance+=if(value=='[')1 else -1;
            minimum=minOf(minimum,balance)
        };
        return (-minimum+1)/2
    }
}
