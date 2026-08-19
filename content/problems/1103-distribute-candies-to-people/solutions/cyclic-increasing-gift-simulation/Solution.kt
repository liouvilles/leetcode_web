class Solution {
    fun distributeCandies(candiesInput:Int,numPeople:Int):IntArray{
        var candies=candiesInput;
        val answer=IntArray(numPeople);
        var give=1;
        var index=0;
        while(candies>0){
            val amount=minOf(candies,give);
            answer[index%numPeople]+=amount;
            candies-=amount;
            give++;
            index++
        };
        return answer
    }
}
