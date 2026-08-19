class Solution {
    fun numRabbits(answers:IntArray):Int{
        val frequency=answers.toList().groupingBy{
            it
        }.eachCount();
        var result=0;
        for((answer,count)in frequency){
            val size=answer+1;
            result+=(count+size-1)/size*size
        };
        return result
    }
}
