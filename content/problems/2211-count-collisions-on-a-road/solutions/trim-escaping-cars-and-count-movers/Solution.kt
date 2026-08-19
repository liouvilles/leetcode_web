class Solution {
    fun countCollisions(directions:String):Int{
        var left=0;
        var right=directions.lastIndex;
        while(left<=right&&directions[left]=='L')left++;
        while(left<=right&&directions[right]=='R')right--;
        var answer=0;
        for(i in left..right)if(directions[i]!='S')answer++;
        return answer
    }
}
