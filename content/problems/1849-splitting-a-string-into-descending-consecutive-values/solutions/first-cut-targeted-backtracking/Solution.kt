class Solution {
    private lateinit var text:String;
    private fun dfs(position:Int,previous:Long):Boolean{
        if(position==text.length)return true;
        if(previous==0L)return false;
        val target=previous-1;
        var value=0L;
        for(end in position until text.length){
            val digit=text[end]-'0';
            if(value>(Long.MAX_VALUE-digit)/10)break;
            value=value*10+digit;
            if(value==target&&dfs(end+1,value))return true;
            if(value>target)break
        };
        return false
    };
    fun splitString(s:String):Boolean{
        text=s;
        var first=0L;
        for(end in 0 until s.lastIndex){
            val digit=s[end]-'0';
            if(first>(Long.MAX_VALUE-digit)/10)break;
            first=first*10+digit;
            if(dfs(end+1,first))return true
        };
        return false
    }
}
