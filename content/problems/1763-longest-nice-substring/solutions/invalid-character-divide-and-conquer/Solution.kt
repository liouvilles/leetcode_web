class Solution {
    fun longestNiceSubstring(text:String):String{
        if(text.length<2)return "";
        val set=text.toSet();
        for(i in text.indices){
            val letter=text[i];
            if(letter.lowercaseChar() !in set||letter.uppercaseChar() !in set){
                val left=longestNiceSubstring(text.substring(0,i));
                val right=longestNiceSubstring(text.substring(i+1));
                return if(left.length>=right.length)left else right
            }
        };
        return text
    }
}
