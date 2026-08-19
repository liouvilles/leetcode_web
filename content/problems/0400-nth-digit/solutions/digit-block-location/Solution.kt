class Solution {
    fun findNthDigit(n:Int):Int{
        var position=n.toLong();
        var digit=1L;
        var start=1L;
        var count=9L;
        while(position>digit*count){
            position-=digit*count;
            digit++;
            start*=10;
            count*=10
        };
        val number=start+(position-1)/digit;
        return number.toString()[((position-1)%digit).toInt()]-'0'
    }
}
