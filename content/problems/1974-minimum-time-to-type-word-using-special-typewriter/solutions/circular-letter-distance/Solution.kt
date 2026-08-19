class Solution {
    fun minTimeToType(word:String):Int{
        var answer=0;
        var current='a';
        for(target in word){
            val difference=kotlin.math.abs(target-current);
            answer+=minOf(difference,26-difference)+1;
            current=target
        };
        return answer
    }
}
