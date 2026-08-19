class Solution {
    fun minimumTimeToInitialState(word:String,k:Int):Int{
        val n=word.length;
        var shift=k;
        while(shift<n){
            var same=true;
            for(index in shift until n)if(word[index]!=word[index-shift]){
                same=false;
                break
            };
            if(same)return shift/k;
            shift+=k
        };
        return (n+k-1)/k
    }
}
