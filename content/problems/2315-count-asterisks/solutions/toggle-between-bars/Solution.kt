class Solution {
    fun countAsterisks(s:String):Int{
        var inside=false;
        var answer=0;
        for(ch in s)if(ch=='|')inside=!inside else if(ch=='*'&&!inside)answer++;
        return answer
    }
}
