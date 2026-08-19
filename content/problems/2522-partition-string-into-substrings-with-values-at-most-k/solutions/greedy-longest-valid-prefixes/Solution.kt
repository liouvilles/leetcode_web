class Solution {
    fun minimumPartition(s:String,k:Int):Int{
        var parts=1;
        var current=0L;
        for(character in s){
            val digit=character-'0';
            if(digit>k)return -1;
            if(current*10+digit>k){
                parts++;
                current=digit.toLong()
            }else current=current*10+digit
        };
        return parts
    }
}
