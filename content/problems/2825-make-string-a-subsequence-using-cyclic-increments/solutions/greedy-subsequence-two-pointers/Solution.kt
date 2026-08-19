class Solution {
    fun canMakeSubsequence(str1:String,str2:String):Boolean{
        var target=0;
        for(source in str1){
            if(target==str2.length)break;
            val wanted=str2[target];
            if(source==wanted||(source-'a'+1)%26==wanted-'a')target++
        };
        return target==str2.length
    }
}
