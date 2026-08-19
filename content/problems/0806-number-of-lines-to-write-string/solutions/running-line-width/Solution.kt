class Solution {
    fun numberOfLines(widths:IntArray,s:String):IntArray{
        var lines=1;
        var width=0;
        for(c in s){
            val next=widths[c-'a'];
            if(width+next>100){
                lines++;
                width=next
            }else width+=next
        };
        return intArrayOf(lines,width)
    }
}
