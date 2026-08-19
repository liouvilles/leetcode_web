class Solution {
    fun isPrefixString(s:String,words:Array<String>):Boolean{
        val builder=StringBuilder();
        for(word in words){
            builder.append(word);
            if(builder.length>=s.length)return builder.toString()==s
        };
        return false
    }
}
