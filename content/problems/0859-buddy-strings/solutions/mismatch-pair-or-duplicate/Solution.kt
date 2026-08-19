class Solution {
    fun buddyStrings(s:String,goal:String):Boolean{
        if(s.length!=goal.length)return false;
        if(s==goal){
            val seen=mutableSetOf<Char>();
            for(c in s)if(!seen.add(c))return true;
            return false
        };
        var first=-1;
        var second=-1;
        for(i in s.indices)if(s[i]!=goal[i]){
            if(first<0)first=i else if(second<0)second=i else return false
        };
        return second>=0&&s[first]==goal[second]&&s[second]==goal[first]
    }
}
