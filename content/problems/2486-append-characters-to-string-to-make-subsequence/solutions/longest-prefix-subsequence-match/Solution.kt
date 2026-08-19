class Solution {
    fun appendCharacters(s:String,t:String):Int{
        var matched=0;
        for(character in s)if(matched<t.length&&character==t[matched])matched++;
        return t.length-matched
    }
}
