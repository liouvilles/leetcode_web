class Solution {
    fun isSubstringPresent(s:String):Boolean{
        val seen=Array(26){
            BooleanArray(26)
        };
        for(index in 0 until s.length-1){
            val first=s[index]-'a';
            val second=s[index+1]-'a';
            seen[first][second]=true;
            if(seen[second][first])return true
        };
        return false
    }
}
