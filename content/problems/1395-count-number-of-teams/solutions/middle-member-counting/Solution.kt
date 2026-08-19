class Solution {
    fun numTeams(rating:IntArray):Int{
        var answer=0;
        for(middle in rating.indices){
            var lessLeft=0;
            var greaterLeft=0;
            var lessRight=0;
            var greaterRight=0;
            for(left in 0 until middle)if(rating[left]<rating[middle])lessLeft++ else greaterLeft++;
            for(right in middle+1 until rating.size)if(rating[right]<rating[middle])lessRight++ else greaterRight++;
            answer+=lessLeft*greaterRight+greaterLeft*lessRight
        };
        return answer
    }
}
