class Solution {
    private fun bit(value:Char)=when(value){
        'a'->1;
        'e'->2;
        'i'->4;
        'o'->8;
        'u'->16;
        else->0
    };
    fun countVowelSubstrings(word:String):Int{
        var answer=0;
        for(left in word.indices){
            var mask=0;
            for(right in left until word.length){
                val value=bit(word[right]);
                if(value==0)break;
                mask=mask or value;
                if(mask==31)answer++
            }
        };
        return answer
    }
}
