class Solution {
    fun fib(n:Int):Int{
        var first=0;
        var second=1;
        repeat(n){
            val next=first+second;
            first=second;
            second=next
        };
        return first
    }
}
